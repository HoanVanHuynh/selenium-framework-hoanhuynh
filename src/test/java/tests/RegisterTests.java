package tests;

import common.Constants;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.RegisterPage;

public class RegisterTests extends BaseTest {

    private RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can create an account successfully with valid register information")
    public void tc001_RegisterWithValidInformation() {
        LogHelper.info("Click on Register tab");
        registerPage.clickRegisterTab();
        String validEmail = DataHelper.getRandomEmail();
        String validPassword = DataHelper.getRandomPassword();
        String validPid = DataHelper.getRandomDigits(10);

        LogHelper.info("Enter register information");
        registerPage.register(validEmail, validPassword, validPassword, validPid);

        String actualResult = registerPage.getRegisterSuccessMessage();
        String expectedResult = "You're here";

        Assert.assertEquals(actualResult, expectedResult, "Register success message displays incorrectly");
    }

    @Test(description = "Error message display when user register with exist email, valid password and confirm password, valid pid")
    public void tc002_RegisterWithExistEmail() {
        LogHelper.info("Click on Register tab");
        registerPage.clickRegisterTab();
        String validPassword = DataHelper.getRandomPassword();
        String validPid = DataHelper.getRandomDigits(10);

        LogHelper.info("Enter register information");
        registerPage.register(Constants.USERNAME, validPassword, validPassword, validPid);

        String actualResult = registerPage.getRegisterErrorMessage();
        String expectedResult = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualResult, expectedResult, "error message displays incorrectly");
    }

}
