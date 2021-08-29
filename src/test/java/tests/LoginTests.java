package tests;


import common.Constants;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class LoginTests extends BaseTest {

    private LoginPage loginPage = new LoginPage();

    @Test(description = "Login with valid username and password")
    public void tc001_LoginWithValidInformation() {
        LogHelper.info("Click on login tab");
        loginPage.clickLoginTab();
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);

        String actualMessage = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constants.USERNAME;

        Assert.assertEquals(actualMessage, expectedMsg, "message is not displayed as expected");

    }

    @Test(description = "Login with invalid username and valid password")
    public void tc002_LoginWithInvalidUsername() {
        LogHelper.info("Click on login tab");
        loginPage.clickLoginTab();
        String invalidUserName = "ddddddddd";
        String validPassword = DataHelper.getRandomPassword();
        loginPage.login(invalidUserName, validPassword);

        String actualMessage = loginPage.getErrorMessageAtTop();
        String expectedMessage = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMessage, expectedMessage, "message does not display correctly");
    }

}
