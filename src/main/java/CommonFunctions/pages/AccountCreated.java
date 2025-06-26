package CommonFunctions.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountCreated {
    private WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Account Created!')]")
    private WebElement accountCreatedText;

    @FindBy(xpath = "//*[contains(text(),'Continue') and @data-qa='continue-button']")
    private WebElement continueButton;

    // Constructor
    public AccountCreated(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to get the account created success text
    public String getAccountCreatedText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(accountCreatedText)).getText();
    }

    // Method to check if account created message is displayed
    public boolean isAccountCreatedMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(accountCreatedText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to click continue button
    public void clickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    // Method to check if continue button is displayed
    public boolean isContinueButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(continueButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}