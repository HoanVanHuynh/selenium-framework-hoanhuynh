package tests;

import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.TimeTablePage;

public class TimeTableTests extends BaseTest {

    private TimeTablePage timeTablePage = new TimeTablePage();

    @BeforeMethod
    public void precondition() {
        LogHelper.info("Click on time table tab");
        timeTablePage.clickTimeTableTab();
    }

    @Test(description = "User can navigate to ticket price page by clicking on check price button")
    public void tc001_ClickingCheckPriceButton() {
        String departStation = "Sài Gòn";
        String arriveStation = "Phan Thiết";
        timeTablePage.clickCheckPriceButton(departStation, arriveStation);

        String expectedTitle = "Safe Railway - Ticket Price";
        String actualTitle = DriverHelper.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Title of the page display incorrectly");
    }

    @Test(description = "User can navigate to ticket price page by clicking on check price button")
    public void tc002_ClickingCheckPriceButton() {
        String departStation = "Sài Gòn";
        String arriveStation = "Quảng Ngãi";
        timeTablePage.clickCheckPriceButton(departStation, arriveStation);

        String expectedTitle = "Safe Railway - Ticket Price";
        String actualTitle = DriverHelper.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Title of the page display incorrectly");
    }

    @Test(description = "User can navigate to login page by clicking on book ticket button")
    public void tc003_ClickingBookTicketButton() {
        String departStation = "Sài Gòn";
        String arriveStation = "Quảng Ngãi";
        timeTablePage.clickBookTicketButton(departStation, arriveStation);

        String actualTitle = DriverHelper.getDriver().getTitle();
        String expectedTitle = "Safe Railway - Login";

        Assert.assertEquals(actualTitle, expectedTitle, "Title of the page display incorrectly");
    }
}
