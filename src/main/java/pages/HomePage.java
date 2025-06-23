package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    //Buttons
    private By signUpLoginButtonLocator = By.xpath("//a[contains(text(),' Signup / Login')]");//Signup/Login
    private By deleteButtonLocator = By.xpath("//a[@href='/delete_account' and contains(text(), 'Delete Account')]");//Delete account
    private By logOutButtonLocator = By.xpath("//a[@href='/logout' and contains(text(), ' Logout')]");//Logout
    private By productsButtonLocator = By.xpath("//a[@href='/products' and contains(text(), ' Products')]");//Products
    private By testCasesButtonLocator = By.xpath("//a[@href='/test_cases' and contains(text(),' Test Cases')]");//Testcase
    private By cartButtonLocator = By.xpath("//a[@href='/view_cart' and contains(text(),' Cart')]");
    //Text
    private By errorMessageTextLocator = By.xpath("//*[contains(text(),'Your email or password is incorrect!')]");
    private By proceedCheckoutTextLocator = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private By reviewOrderTextLocator = By.xpath("//*[contains(text(),'Review Your Order')]");


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to click Signup/Login button
    public void clickSignUpLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signUpLoginButton = wait.until(ExpectedConditions.elementToBeClickable(signUpLoginButtonLocator));
        signUpLoginButton.click();
    }

    // Method to click Delete Account button
    public void clickDeleteAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(deleteButtonLocator));
        deleteButton.click();
    }

    // Method to click Logout button
    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logOutButtonLocator));
        logoutButton.click();
    }

    // Method to click Products button
    public void clickProductsButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productsButton = wait.until(ExpectedConditions.elementToBeClickable(productsButtonLocator));
        productsButton.click();
    }

    // Method to click Test Cases button
    public void clickTestCasesButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement testCasesButton = wait.until(ExpectedConditions.elementToBeClickable(testCasesButtonLocator));
        testCasesButton.click();
    }

    // Method to click Cart button
    public void clickCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(cartButtonLocator));
        cartButton.click();
    }

    // Method to get error message text
    public String getErrorMessageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageTextLocator));
        return errorMessage.getText();
    }

    // Method to check if error message is displayed
    public boolean isErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageTextLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to click Proceed to Checkout button
    public void clickProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement proceedCheckout = wait.until(ExpectedConditions.elementToBeClickable(proceedCheckoutTextLocator));
        proceedCheckout.click();
    }

    // Method to get review order text
    public String getReviewOrderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement reviewOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewOrderTextLocator));
        return reviewOrder.getText();
    }

    // Method to check if user is logged in (by checking presence of logout button)
    public boolean isUserLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logOutButtonLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}