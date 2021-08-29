package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    // Locator
    private final By lnkCreateAnAccount = By.cssSelector("li > a[href='/Account/Register.cshtml']");

    // Element
    private WebElement getLnkCreateAnAccount() {
        return DriverHelper.getDriver().findElement(lnkCreateAnAccount);
    }

    // Method
    public void clickCreateAnAccountLink() {
        this.getLnkCreateAnAccount().click();
    }
}
