package tests;

import common.Constants;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.LoginPage;

public class LogoutTests extends BaseTest {

    private LoginPage loginPage = new LoginPage();
    private BasePage basePage = new BasePage();

    @Test(description = "User can log out successfully")
    public void tc001_CheckLogout() {
        LogHelper.info("Click on login tab");
        basePage.clickLoginTab();
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);
        LogHelper.info("Click on logout tab");
        basePage.clickLogoutTab();

        String actualResult = basePage.getGreetingMessage();
        String expectedResult = "Welcome guest!";

        Assert.assertEquals(actualResult, expectedResult, "Greeting message displays incorrectly");
    }
}
