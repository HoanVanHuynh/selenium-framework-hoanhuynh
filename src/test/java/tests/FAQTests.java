package tests;

import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.FAQPage;

public class FAQTests extends BaseTest {

    private BasePage basePage = new BasePage();
    private FAQPage faqPage = new FAQPage();

    @BeforeMethod
    public void precondition() {
        LogHelper.info("Click on FAQ tab");
        basePage.clickFAQTab();
    }

    @Test(description = "User can navigate to register page by clicking on create an account link")
    public void tc001_CheckCreateAnAccountLink() {
        LogHelper.info("Click on create an account link");
        faqPage.clickCreateAnAccountLink();

        String actualTitle = DriverHelper.getTitle();
        String expectedTitle = "Safe Railway - Register an Account";

        Assert.assertEquals(actualTitle, expectedTitle, "Title of register page displays incorrectly");
    }

    @Test(description = "User can navigate to login page by clicking on book ticket page link")
    public void tc002_CheckBookTicketPageLink() {
        LogHelper.info("Click on book ticket page link");
        faqPage.clickBookTicketPageLink();

        String actualTitle = DriverHelper.getTitle();
        String expectedTitle = "Safe Railway - Login";

        Assert.assertEquals(actualTitle, expectedTitle, "Title of login page displays incorrectly");
    }
}
