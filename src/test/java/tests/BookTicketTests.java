package tests;

import common.Constants;
import common.Ticket;
import helpers.DateHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;

public class BookTicketTests extends BaseTest {

    private BookTicketPage bookTicketPage = new BookTicketPage();
    private LoginPage loginPage = new LoginPage();
    private Ticket ticket = new Ticket();

    @BeforeMethod
    public void precondition() {
        LogHelper.info("Click on login tab");
        loginPage.clickLoginTab();
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);
        LogHelper.info("Click on book ticket tab");
        bookTicketPage.clickBookTicketTab();
    }

    @Test(description = "User can book ticket successfully")
    public void tc001_BookTicket() {
        String departDate = DateHelper.getDateFromToday(5);
        ticket.setDepartDate(departDate);
        ticket.setDepartFrom("Quảng Ngãi");
        ticket.setArriveAt("Nha Trang");
        ticket.setSeatType("Hard seat");
        ticket.setTicketAmount("1");
        bookTicketPage.bookTicket(ticket);

        String actualMessage = bookTicketPage.getBookTicketMessage();
        String expectedMessage = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMessage, expectedMessage, "Message does not display correctly");
    }

    @Test(description = "User can select from 1 to 10 tickets from ticket amount dropdown")
    public void tc002_CheckTicketAmountValues() {
        Boolean actualResult = bookTicketPage.isTicketAmountDisplayed(10);

        Assert.assertTrue(actualResult, "Ticket amount has to be 10");
    }

    @Test(description = "User can check first depart date of 3 days ahead from today ")
    public void tc003_CheckFirstDepartDate() {
        String actualDate = bookTicketPage.getFirstDepartDate();
        String expectedDate = DateHelper.getDateFromToday(3);

        Assert.assertEquals(actualDate, expectedDate, "3 days ahead from today");
    }

    @Test(description = "Depart date contains 30 values")
    public void tc004_CheckTotalDepartDate() {
        int actualTotal = bookTicketPage.getTotalDepartDate();
        int expectedTotal = 30;

        Assert.assertEquals(actualTotal, expectedTotal, "Total should be 30");
    }

    @Test(description = "User has 10 options for ticket amount dropdown, each value of that option increases from 1 to 10")
    public void tc005_CheckTotalTicketAmount() {
        int actualTotal = bookTicketPage.getTotalTicketAmount(10);
        int expectedTotal = 55;

        Assert.assertEquals(actualTotal, expectedTotal, "Total should be 55");

    }
}
