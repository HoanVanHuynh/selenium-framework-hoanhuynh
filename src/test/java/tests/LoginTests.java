package tests;


import common.Constants;
import helpers.DataHelper;
import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class LoginTests extends BaseTest {

    private LoginPage loginPage = new LoginPage();

    @Test(description = "System shows message when user enters wrong password several times")
    public void tc05_SystemShowsMessage() {
        LogHelper.info("Click on Login tab");
        loginPage.clickLoginTab();

        String invalidPassword = "11122233345";

        LogHelper.info("Log in 4 times with valid username but invalid password");
        for (int i = 0; i < 4; i++) {
            loginPage.login(Constants.USERNAME, invalidPassword);
        }

        LogHelper.info("Get error message after logging in 4 times with invalid password");
        String actualMessage = loginPage.getErrorMessageAtTop();
        String expectedMessage = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        LogHelper.info("Verify that error message displays correctly after logging in 4 times with invalid password");
        Assert.assertEquals(actualMessage, expectedMessage, "Error message is displayed incorrectly as expected");
    }
}

// Invalid username or password. Please try again.