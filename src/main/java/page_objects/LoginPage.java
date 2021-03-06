package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Locators
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.cssSelector("input[value='Login']");
    private final By lnkRegistrationPage = By.cssSelector("a[href='Register.cshtml']");

    private final By lnkForgotPasswordPage = By.cssSelector("a[href='/Account/ForgotPassword.cshtml']");

    private final By lblWelcomeMessage = By.cssSelector("div[class='account'] > strong");

    //
    private final By lblTopicContentAtTop = By.cssSelector("div#content h1");

    private WebElement getLblTopicContentAtTop() {
        return DriverHelper.getDriver().findElement(lblTopicContentAtTop);
    }

    public String getTopicContentAtTop() {
        return this.getLblTopicContentAtTop().getText();
    }

    // Login Page
    //
    private WebElement getTxtUsername() {
        return DriverHelper.getDriver().findElement(txtUsername);
    }

    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return DriverHelper.getDriver().findElement(btnLogin);
    }

    private WebElement getLnkRegistrationPage() {
        return DriverHelper.getDriver().findElement(lnkRegistrationPage);
    }

    private WebElement getLnkForgotPasswordPage() {
        return DriverHelper.getDriver().findElement(lnkForgotPasswordPage);
    }

    private WebElement getLblWelcomeMessage() {
        return DriverHelper.getDriver().findElement(lblWelcomeMessage);
    }

    //private WebElement getLblErrorMessageAtTop() {
    // return DriverHelper.getDriver().findElement(lblErrorMessageAtTop);
    // }

    // Methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    // public String getErrorMessageAtTop() {
    // return this.

    //getLblErrorMessageAtTop().

    //getText();

//}

    public void login(String user, String password) {
        ElementHelper.scrollTo(this.getTxtUsername());
        this.getTxtUsername().sendKeys(user);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void clickRegistrationPageLink() {
        this.getLnkRegistrationPage().click();
    }

    public void clickForgotPasswordPageLink() {
        this.getLnkForgotPasswordPage().click();
    }
}

