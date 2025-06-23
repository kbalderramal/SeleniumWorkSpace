package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CategoryProducts1 {
    private WebDriver driver;

    private By firstProductLocator = By.xpath("(//div[@class='productinfo text-center']/a[contains(text(),'Add to cart')])[1]");
    private By productAddedTextLocator = By.xpath("//*[contains(text(),'Your product has been added to cart.')]");
    private By contniueButtonLocator = By.xpath("//button[contains(text(),'Continue Shopping')]");

    // Constructor
    public CategoryProducts1(WebDriver driver) {
        this.driver = driver;
    }

    // Method to click on first product's "Add to cart" button
    public void clickFirstProductAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(firstProductLocator));
        firstProduct.click();
    }

    // Method to get the product added confirmation text
    public String getProductAddedText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addedTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedTextLocator));
        return addedTextElement.getText();
    }

    // Method to check if product added message is displayed
    public boolean isProductAddedMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedTextLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to click continue shopping button
    public void clickContinueShopping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(contniueButtonLocator));
        continueButton.click();
    }

    // Method to check if continue shopping button is displayed
    public boolean isContinueShoppingButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(contniueButtonLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
