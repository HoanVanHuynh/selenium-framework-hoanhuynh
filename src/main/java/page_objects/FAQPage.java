package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FAQPage extends BasePage {
    // Locators
    private final By lnkCreateAnAccount = By.cssSelector("li[id='1'] a[href*='Account']");
    private final By lnkBookTicketPage = By.cssSelector("li[id='1'] a[href*='BookTicketPage']");

    // Elements
    private WebElement getLnkCreateAnAccount() {
        return DriverHelper.getDriver().findElement(lnkCreateAnAccount);
    }

    private WebElement getLnkBookTicketPage() {
        return DriverHelper.getDriver().findElement(lnkBookTicketPage);
    }

    // Methods
    public void clickCreateAnAccountLink() {
        this.getLnkCreateAnAccount().click();
    }

    public void clickBookTicketPageLink() {
        this.getLnkBookTicketPage().click();
    }

}
