package CommonFunctions.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogInPage {
    private WebDriver driver;

    // Text elements
    @FindBy(xpath = "//*[contains(text(),'Login to your account')]")
    private WebElement loginText;

    @FindBy(xpath = "//*[contains(text(),'New User Signup!')]")
    private WebElement newUserText;

    @FindBy(xpath = "//*[contains(text(),'Your email or password is incorrect!')]")
    private WebElement incorrectCredentialsText;

    // Login form elements
    @FindBy(xpath = "//*[contains(text(), 'Login to your account')]/following-sibling::form[1]//input[@type='email']")
    private WebElement emailAddressFieldLogin;

    @FindBy(xpath = "//*[contains(text(), 'Login to your account')]/following-sibling::form[1]//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;

    // Signup form elements
    @FindBy(xpath = "//*[contains(text(),'New User Signup!')]/following-sibling::form[1]//input[@data-qa='signup-name']")
    private WebElement nameField;

    @FindBy(xpath = "//*[contains(text(),'New User Signup!')]/following-sibling::form[1]//input[@data-qa='signup-email']")
    private WebElement emailAddressFieldSignup;

    @FindBy(xpath = "//button[contains(text(),'Signup')]")
    private WebElement signupButton;

    // Constructor
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to get login section header text
    public String getLoginText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(loginText)).getText();
    }

    // Method to get signup section header text
    public String getNewUserText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(newUserText)).getText();
    }

    // Method to enter login email
    public void enterLoginEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement field = wait.until(ExpectedConditions.visibilityOf(emailAddressFieldLogin));
        field.clear();
        field.sendKeys(email);
    }

    // Method to enter login password
    public void enterLoginPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement field = wait.until(ExpectedConditions.visibilityOf(passwordField));
        field.clear();
        field.sendKeys(password);
    }

    // Method to click login button
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    // Method to perform login
    public void login(String email, String password) {
        enterLoginEmail(email);
        enterLoginPassword(password);
        clickLoginButton();
    }

    // Method to enter signup name
    public void enterSignupName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement field = wait.until(ExpectedConditions.visibilityOf(nameField));
        field.clear();
        field.sendKeys(name);
    }

    // Method to enter signup email
    public void enterSignupEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement field = wait.until(ExpectedConditions.visibilityOf(emailAddressFieldSignup));
        field.clear();
        field.sendKeys(email);
    }

    // Method to click signup button
    public void clickSignupButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }

    // Method to perform signup
    public void signUp(String name, String email) {
        enterSignupName(name);
        enterSignupEmail(email);
        clickSignupButton();
    }

    // Method to check if login form is displayed
    public boolean isLoginFormDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(loginText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to check if signup form is displayed
    public boolean isSignupFormDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(newUserText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Validate Your email or password is incorrect! text present
    public boolean isIncorrectCredentialsMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(incorrectCredentialsText)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}