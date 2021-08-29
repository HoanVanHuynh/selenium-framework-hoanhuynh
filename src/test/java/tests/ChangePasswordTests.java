package tests;

import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class ChangePasswordTests extends BaseTest {

    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private LoginPage loginPage = new LoginPage();
    private RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can change password successfully with valid password and valid confirm password")
    public void tc001_ChangePasswordWithValidInformation() {
        LogHelper.info("Click on Register tab");
        registerPage.clickRegisterTab();
        String validEmail = DataHelper.getRandomEmail();
        String validPassword = DataHelper.getRandomPassword();
        String validPid = DataHelper.getRandomDigits(10);
        registerPage.register(validEmail, validPassword, validPassword, validPid);

        LogHelper.info("Click on Login tab");
        registerPage.clickLoginTab();
        loginPage.login(validEmail, validPassword);
        loginPage.clickChangePasswordTab();
        String validNewPassword = DataHelper.getRandomPassword();
        changePasswordPage.changePassword(validEmail, validNewPassword, validNewPassword);

        String actualMessage = changePasswordPage.getChangePasswordMessage();
        String expectedMessage = "Your password has been updated!";

        Assert.assertEquals(actualMessage, expectedMessage, "message displays incorrectly");
    }
}
