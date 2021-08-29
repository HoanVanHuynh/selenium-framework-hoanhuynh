package tests;

import common.Constants;
import common.Ticket;
import helpers.DateHelper;
import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;
import page_objects.MyTicketPage;


public class CancelTicketTests extends BaseTest {

    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private MyTicketPage myTicketPage = new MyTicketPage();
    private Ticket ticket = new Ticket();

    @BeforeMethod
    public void precondition() {
        LogHelper.info("Click on login tab");
        loginPage.clickLoginTab();
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);
        LogHelper.info("Click on book ticket tab");
        bookTicketPage.clickBookTicketTab();
    }

    @Test(description = "User can cancel ticket successfully")
    public void tc001_CancelTicket() {
        String departDate = DateHelper.getDateFromToday(5);
        String bookDate = DateHelper.getCurrentDate();
        String departStation = "Sài Gòn";
        String arriveStation = "Phan Thiết";
        String ticketAmount = "3";
        ticket.setDepartDate(departDate);
        ticket.setDepartFrom(departStation);
        ticket.setArriveAt(arriveStation);
        ticket.setSeatType("Hard seat");
        ticket.setTicketAmount(ticketAmount);

        bookTicketPage.bookTicket(ticket);
        myTicketPage.clickMyTicketTab();

        String beforeCancelTicketResult = myTicketPage.getCancelTicketNoteWithMoreThan1Ticket(ticketAmount, "10");
        LogHelper.info(beforeCancelTicketResult);
        myTicketPage.cancelTicket(departStation, arriveStation, departDate, bookDate, ticketAmount);
        DriverHelper.clickOKButtonOfAlert();

        String afterCancelTicketResult = myTicketPage.getCancelTicketNoteWith0Or1Ticket("0", "10");
        LogHelper.info(afterCancelTicketResult);
        String expectedResult = "You currently book 0 ticket, you can book 10 more.";

        Assert.assertEquals(afterCancelTicketResult, expectedResult, "Cancel ticket note must be displayed correctly");
    }

}
