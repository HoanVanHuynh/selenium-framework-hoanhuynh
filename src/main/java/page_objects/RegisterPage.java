package page_objects;

import common.Account;
import common.Constants;
import helpers.DriverHelper;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    // Locators
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.cssSelector("input[value='Register']");
    private final By lblRegisterSuccessMessage = By.cssSelector("div#content p");
    private final By lblRegisterErrorMessage = By.cssSelector("p[class='message error']");
    private final By lblEmailErrorMessage = By.cssSelector("input#email ~ label[class='validation-error']");
    private final By lblPasswordErrorMessage = By.cssSelector("input#password ~ label[class='validation-error']");
    private final By lblPidErrorMessage = By.cssSelector("input#pid ~ label[class='validation-error']");

    // Elements
    private WebElement getLblEmailErrorMessage() {
        return DriverHelper.getDriver().findElement(lblEmailErrorMessage);
    }

    private WebElement getLblPasswordErrorMessage() {
        return DriverHelper.getDriver().findElement(lblPasswordErrorMessage);
    }

    private WebElement getLblPidErrorMessage() {
        return DriverHelper.getDriver().findElement(lblPidErrorMessage);
    }

    private WebElement getTxtEmail() {
        return DriverHelper.getDriver().findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getTxtPid() {
        return DriverHelper.getDriver().findElement(txtPid);
    }

    private WebElement getBtnRegister() {
        return DriverHelper.getDriver().findElement(btnRegister);
    }

    private WebElement getLblRegisterSuccessMessage() {
        return DriverHelper.getDriver().findElement(lblRegisterSuccessMessage);
    }

    private WebElement getLblRegisterErrorMessage() {
        return DriverHelper.getDriver().findElement(lblRegisterErrorMessage);
    }

    // Methods
    public void register(Account account) {
        ElementHelper.scrollTo(this.getTxtEmail());
        this.getTxtEmail().clear();
        this.getTxtEmail().sendKeys(account.getEmail());
        this.getTxtPassword().clear();
        this.getTxtPassword().sendKeys(account.getPassword());
        this.getTxtConfirmPassword().clear();
        this.getTxtConfirmPassword().sendKeys(account.getConfirmPassword());
        this.getTxtPid().clear();
        this.getTxtPid().sendKeys(account.getPid());
        this.getBtnRegister().click();
    }

    public String getRegisterErrorMessage() {
        return this.getLblRegisterErrorMessage().getText();
    }

    public String getRegisterSuccessMessage() {
        Wait.untilElementIsVisible(lblRegisterSuccessMessage, Constants.TIME_WAIT);
        return this.getLblRegisterSuccessMessage().getText();
    }

    public String getEmailErrorMessage() {
        return this.getLblEmailErrorMessage().getText();
    }

    public String getPasswordErrorMessage() {
        return this.getLblPasswordErrorMessage().getText();
    }

    public String getPidErrorMessage() {
        return this.getLblPidErrorMessage().getText();
    }
}
