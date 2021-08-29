package tests;

import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;

public class HomeTests extends BaseTest {

    private HomePage homePage = new HomePage();

    @Test(description = "User can navigate to register page by clicking on create an account hyperlink")
    public void tc001_NavigateToRegisterPage() {
        LogHelper.info("Click on create an account link");
        homePage.clickCreateAnAccountLink();

        String expectedTitle = "Safe Railway - Register an Account";
        String actualTitle = DriverHelper.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Title of the page display incorrectly");

    }
}
