package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountCreated {
    private WebDriver driver;

    private By accountTextLocator = By.xpath("//*[contains(text(),'Account Created!')]");
    private By continueButtonLocator = By.xpath("//*[contains(text(),'Continue') and @data-qa='continue-button']");

    // Constructor
    public AccountCreated(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get the account created success text
    public String getAccountCreatedText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountTextLocator));
        return accountTextElement.getText();
    }

    // Method to check if account created message is displayed
    public boolean isAccountCreatedMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(accountTextLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to click continue button
    public void clickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
        continueButton.click();
    }

    // Method to check if continue button is displayed
    public boolean isContinueButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(continueButtonLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
