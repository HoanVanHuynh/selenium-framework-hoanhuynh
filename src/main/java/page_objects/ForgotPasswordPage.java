package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    // Locators
    private final By txtEmail = By.id("email");
    private final By btnSendInstructions = By.cssSelector("input[type='text']");
    private final By lblErrorMessage = By.cssSelector("p[class='message error']");

    // Elements
    private WebElement getTxtEmail() {
        return DriverHelper.getDriver().findElement(txtEmail);
    }

    private WebElement getBtnSendInstructions() {
        return DriverHelper.getDriver().findElement(btnSendInstructions);
    }

    private WebElement getLblErrorMessage() {
        return DriverHelper.getDriver().findElement(lblErrorMessage);
    }

    // Methods
    public void enterEmailAddress(String email) {
        this.getTxtEmail().sendKeys(email);
    }

    public void clickSendInstructionsButton() {
        this.getBtnSendInstructions().click();
    }

    public String getErrorMessage() {
        return this.getLblErrorMessage().getText();
    }
}
