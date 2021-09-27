package tests;

import common.Constants;
import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;

public class TryTests extends BaseTest {
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User is redirected to Book ticket page after logging in")
    public void tc04_UserIsRedirectedToBookTicketPage() {
        LogHelper.info("Click on Book ticket tab");
        loginPage.clickBookTicketTab();

        LogHelper.info("Get topic content at the top of login page in the middle");
        String actualContent = loginPage.getTopicContentAtTop();

        LogHelper.info("Login with valid account");
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);

        LogHelper.info("Get Book ticket form title on the left hand side of Book ticket page");
        String actualTitle = bookTicketPage.getBookTicketFormTitle();

        LogHelper.info("Verify that user is directed to Login page after clicking on Book Ticket tab");
        Assert.assertEquals(actualContent, "Login Page", "Topic content of Login page is displayed incorrectly as expected");

        LogHelper.info("Verify that Book ticket page displays with Book ticket form opens");
        Assert.assertEquals(actualTitle, "Book ticket form", "Title of Book ticket form is displayed incorrectly as expected");
    }
}
