package tests;

import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.TicketPricePage;

public class TicketPriceTests extends BaseTest {

    private HomePage homePage = new HomePage();
    private TicketPricePage ticketPricePage = new TicketPricePage();

    @Test(description = "User can check ticket price by clicking on check price button")
    public void tc001_ClickingCheckPriceButton() {
        LogHelper.info("Click on ticket price tab");
        homePage.clickTicketPriceTab();
        String departToArrive = "Sài Gòn to Quảng Ngãi";
        ticketPricePage.clickCheckPriceButton(departToArrive);

        String actualTitle = ticketPricePage.getTicketPriceTableTitle(departToArrive);
        String expectedTitle = "Ticket price from Sài Gòn to Quảng Ngãi";

        Assert.assertEquals(actualTitle, expectedTitle, "Title of the table display incorrectly");
    }
}
