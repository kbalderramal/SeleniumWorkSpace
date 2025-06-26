package CommonFunctions.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    //Buttons
    @FindBy(xpath = "//a[contains(text(),' Signup / Login')]")
    private WebElement signUpLoginButton;

    @FindBy(xpath = "//a[@href='/delete_account' and contains(text(), 'Delete Account')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//a[@href='/logout' and contains(text(), ' Logout')]")
    private WebElement logOutButton;

    @FindBy(xpath = "//a[@href='/products' and contains(text(), ' Products')]")
    private WebElement productsButton;

    @FindBy(xpath = "//a[@href='/test_cases' and contains(text(),' Test Cases')]")
    private WebElement testCasesButton;

    @FindBy(xpath = "//a[@href='/view_cart' and contains(text(),' Cart')]")
    private WebElement cartButton;

    //Text
    @FindBy(xpath = "//*[contains(text(),'Your email or password is incorrect!')]")
    private WebElement errorMessageText;

    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    private WebElement proceedCheckoutText;

    @FindBy(xpath = "//*[contains(text(),'Review Your Order')]")
    private WebElement reviewOrderText;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click Signup/Login button
    public void clickSignUpLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signUpLoginButton)).click();
    }

    // Method to click Delete Account button
    public void clickDeleteAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }

    // Method to click Logout button
    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logOutButton)).click();
    }

    // Method to click Products button
    public void clickProductsButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(productsButton)).click();
    }

    // Method to click Test Cases button
    public void clickTestCasesButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(testCasesButton)).click();
    }

    // Method to click Cart button
    public void clickCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }

    // Method to get error message text
    public String getErrorMessageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(errorMessageText)).getText();
    }

    // Method to check if error message is displayed
    public boolean isErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessageText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to click Proceed to Checkout button
    public void clickProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(proceedCheckoutText)).click();
    }

    // Method to get review order text
    public String getReviewOrderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(reviewOrderText)).getText();
    }

    // Method to check if user is logged in (by checking presence of logout button)
    public boolean isUserLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(logOutButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}