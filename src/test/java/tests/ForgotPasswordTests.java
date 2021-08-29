package tests;

import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ForgotPasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class ForgotPasswordTests extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test(description = "Error message displays when user resets password with not exist email")
    public void tc001_ResetPassword() {
        LogHelper.info("Click on Login tab");
        homePage.clickLoginTab();
        loginPage.clickForgotPasswordPageLink();

        String randomEmail = "workreallyhard123@gmail.com";

        forgotPasswordPage.enterEmailAddress(randomEmail);
        forgotPasswordPage.clickSendInstructionsButton();

        String actualMessage = forgotPasswordPage.getErrorMessage();
        String expectedMessage = "This email address doesn't exist";

        Assert.assertEquals(actualMessage, expectedMessage, "Error message displays incorrectly");
    }

}
