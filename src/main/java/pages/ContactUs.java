package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactUs {
    private WebDriver driver;

    //Text
    private By allProductsTextLocator = By.xpath("//h2[contains(text(), 'Contact ')]");
    //Contact form
    private By nameFieldLocator = By.name("name");
    private By emailFieldLocator = By.name("email");
    private By subjectFieldLocator = By.name("email");
    private By messageFieldLocator = By.name("message");
    private By submitButtonLocator = By.name("submit");
    private By successTextLocator = By.xpath("//div[@class='contact-form']//div[contains(text(),'Success! Your details have been submitted successfully.')]") ;


    // Constructor
    public ContactUs(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get contact page header text
    public String getContactPageHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsTextLocator));
        return header.getText();
    }

    // Method to enter name in contact form
    public void enterName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        nameField.clear();
        nameField.sendKeys(name);
    }

    // Method to enter email in contact form
    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        emailField.clear();
        emailField.sendKeys(email);
    }

    // Method to enter subject in contact form
    public void enterSubject(String subject) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement subjectField = wait.until(ExpectedConditions.visibilityOfElementLocated(subjectFieldLocator));
        subjectField.clear();
        subjectField.sendKeys(subject);
    }

    // Method to enter message in contact form
    public void enterMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(messageFieldLocator));
        messageField.clear();
        messageField.sendKeys(message);
    }

    // Method to click submit button
    public void clickSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButton.click();
    }

    // Method to get success message text
    public String getSuccessMessageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successTextLocator));
        return successMessage.getText();
    }

    // Method to check if success message is displayed
    public boolean isSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successTextLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to submit complete contact form
    public void submitContactForm(String name, String email, String subject, String message) {
        enterName(name);
        enterEmail(email);
        enterSubject(subject);
        enterMessage(message);
        clickSubmitButton();
    }
}
