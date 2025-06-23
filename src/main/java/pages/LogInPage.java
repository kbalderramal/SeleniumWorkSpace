package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogInPage {
    private WebDriver driver;

    //Text
    private By logInTextLocator = By.xpath("//*[contains(text(),'Login to your account')]");
    private By newUserTextLocator = By.xpath("//*[contains(text(),'New User Signup!')]");
    //Login form
    private By emailAddressFieldLoginLocator = By.xpath("//*[contains(text(), 'Login to your account')]/following-sibling::form[1]//input[@type='email']");
    private By passwordFieldLocator = By.xpath("//*[contains(text(), 'Login to your account')]/following-sibling::form[1]//input[@type='password']");
    private By logInButtonLocator = By.xpath("//button[contains(text(),'Login')]");
    //Signup form
    private By nameFieldLocator = By.xpath("//*[contains(text(),'New User Signup!')]/following-sibling::form[1]//input[@data-qa='signup-name']");
    private By emailAddressFieldSignupLocator = By.xpath("//*[contains(text(),'New User Signup!')]/following-sibling::form[1]//input[@data-qa='signup-email']");
    private By signupButtonLocator = By.xpath("//button[contains(text(),'Signup')]");


    // Constructor
    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get login section header text
    public String getLoginText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginText = wait.until(ExpectedConditions.visibilityOfElementLocated(logInTextLocator));
        return loginText.getText();
    }

    // Method to get signup section header text
    public String getNewUserText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement newUserText = wait.until(ExpectedConditions.visibilityOfElementLocated(newUserTextLocator));
        return newUserText.getText();
    }

    // Method to enter login email
    public void enterLoginEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressFieldLoginLocator));
        emailField.clear();
        emailField.sendKeys(email);
    }

    // Method to enter login password
    public void enterLoginPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    // Method to click login button
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(logInButtonLocator));
        loginButton.click();
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
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        nameField.clear();
        nameField.sendKeys(name);
    }

    // Method to enter signup email
    public void enterSignupEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressFieldSignupLocator));
        emailField.clear();
        emailField.sendKeys(email);
    }

    // Method to click signup button
    public void clickSignupButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(signupButtonLocator));
        signupButton.click();
    }

    // Method to perform signup
    public void signup(String name, String email) {
        enterSignupName(name);
        enterSignupEmail(email);
        clickSignupButton();
    }

    // Method to check if login form is displayed
    public boolean isLoginFormDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logInTextLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to check if signup form is displayed
    public boolean isSignupFormDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(newUserTextLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
