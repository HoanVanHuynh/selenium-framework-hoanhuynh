package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {

    // Locators
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.cssSelector("input[value='Change Password']");
    private final By lblChangePasswordMessage = By.cssSelector("p[class='message success']");

    // Elements
    private WebElement getTxtCurrentPassword() {
        return DriverHelper.getDriver().findElement(txtCurrentPassword);
    }

    private WebElement getTxtNewPassword() {
        return DriverHelper.getDriver().findElement(txtNewPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword() {
        return DriverHelper.getDriver().findElement(btnChangePassword);
    }

    private WebElement getLblChangePasswordMessage() {
        return DriverHelper.getDriver().findElement(lblChangePasswordMessage);
    }

    // Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        ElementHelper.scrollTo(this.getTxtCurrentPassword());
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
    }

    public String getChangePasswordMessage() {
        return getLblChangePasswordMessage().getText();
    }
}

