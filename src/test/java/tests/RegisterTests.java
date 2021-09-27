package tests;

import common.Account;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.RegisterPage;

public class RegisterTests extends BaseTest {

    private Account account = new Account();
    private RegisterPage registerPage = new RegisterPage();
    private String email = DataHelper.getRandomEmail();
    private String password = DataHelper.getRandomPassword(10);
    private String pid = DataHelper.getRandomDigits(10);


    @Test(description = "User can create an account successfully with valid register information")
    public void tc001_RegisterWithValidInformation() {
        LogHelper.info("Set all valid register information");
        account.setEmail(email);
        account.setPassword(password);
        account.setConfirmPassword(password);
        account.setPid(pid);

        LogHelper.info("Click on Register tab");
        registerPage.clickRegisterTab();

        LogHelper.info("Register a account");
        registerPage.register(account);

        String actualResult = registerPage.getRegisterSuccessMessage();
        String expectedResult = "You're here";

        Assert.assertEquals(actualResult, expectedResult, "Register success message displays incorrectly");
    }
}
