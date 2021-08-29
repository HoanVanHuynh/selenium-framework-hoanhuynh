package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    // Locators
    private final By tabLogin = By.cssSelector("a[href$='Login.cshtml']");
    private final By tabLogout = By.cssSelector("a[href$='Logout']");
    private final By tabRegister = By.cssSelector("li > a[href$='Register.cshtml']");
    private final By tabTimeTable = By.cssSelector("a[href='TrainTimeListPage.cshtml']");
    private final By tabTicketPrice = By.cssSelector("a[href$='TrainPriceListPage.cshtml']");
    private final By tabBookTicket = By.cssSelector("a[href$='BookTicketPage.cshtml']");
    private final By tabChangePassword = By.cssSelector("li[class='selected'] > a");
    private final By tabFAQ = By.cssSelector("a[href*='FAQ']");
    private final By tabHome = By.cssSelector("a[href='../']");
    private final By tabContact = By.cssSelector("a[href*='Contact']");
    private final By tabMyTicket = By.cssSelector("a[href*='ManageTicket']");
    private final By lblGreetingMessage = By.cssSelector("div.account");

    // Elements
    private WebElement getTabChangePassword() {
        return DriverHelper.getDriver().findElement(tabChangePassword);
    }

    private WebElement getTabTimeTable() {
        return DriverHelper.getDriver().findElement(tabTimeTable);
    }

    private WebElement getTabLogin() {
        return DriverHelper.getDriver().findElement(tabLogin);
    }

    private WebElement getTabTicketPrice() {
        return DriverHelper.getDriver().findElement(tabTicketPrice);
    }

    private WebElement getTabBookTicket() {
        return DriverHelper.getDriver().findElement(tabBookTicket);
    }

    private WebElement getTabLogout() {
        return DriverHelper.getDriver().findElement(tabLogout);
    }

    private WebElement getTabRegister() {
        return DriverHelper.getDriver().findElement(tabRegister);
    }

    private WebElement getTabFAQ() {
        return DriverHelper.getDriver().findElement(tabFAQ);
    }

    private WebElement getTabHome() {
        return DriverHelper.getDriver().findElement(tabHome);
    }

    private WebElement getTabContact() {
        return DriverHelper.getDriver().findElement(tabContact);
    }

    private WebElement getTabMyTicket() {
        return DriverHelper.getDriver().findElement(tabMyTicket);
    }

    private WebElement getLblGreetingMessage() {
        return DriverHelper.getDriver().findElement(lblGreetingMessage);
    }

    // Methods

    public void clickLoginTab() {
        this.getTabLogin().click();
    }

    public void clickLogoutTab() {
        this.getTabLogout().click();
    }

    public void clickRegisterTab() {
        this.getTabRegister().click();
    }

    public void clickTimeTableTab() {
        this.getTabTimeTable().click();
    }

    public void clickTicketPriceTab() {
        this.getTabTicketPrice().click();
    }

    public void clickChangePasswordTab() {
        this.getTabChangePassword().click();
    }

    public void clickBookTicketTab() {
        this.getTabBookTicket().click();
    }

    public void clickMyTicketTab() {
        this.getTabMyTicket().click();
    }

    public void clickContactTab() {
        this.getTabContact().click();
    }

    public void clickFAQTab() {
        this.getTabFAQ().click();
    }

    public void clickHomeTab() {
        this.getTabHome().click();
    }

    public String getGreetingMessage() {
        return this.getLblGreetingMessage().getText();
    }

    public Boolean isLogoutTabDisplayed() {
        return getTabLogout().isDisplayed();
    }
}

