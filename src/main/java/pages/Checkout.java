package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Checkout {
    private WebDriver driver;


    private By descriptionLocator = By.xpath("//td[@class='cart_description']/h4/a");
    private By priceLocator = By.xpath("//td[@class='cart_price']/p");
    private By quantityLocator = By.xpath("//td[@class='cart_quantity']/button");
    private By totalPriceLocator = By.xpath("//tbody/tr[last()]//p[@class='cart_total_price']");
    private By commentsTextAreaLocator = By.xpath("//textarea[@name='message']");
    private By placeorderButtonLocator = By.xpath("//a[contains(text(),'Place Order')]");
    private By submitOrderButtonLocator = By.id("submit");

    // Constructor
    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get product description
    public String getProductDescription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionLocator));
        return description.getText();
    }

    // Method to get product price
    public String getProductPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(priceLocator));
        return price.getText();
    }

    // Method to get product quantity
    public String getProductQuantity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityLocator));
        return quantity.getText();
    }

    // Method to get total price
    public String getTotalPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement totalPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceLocator));
        return totalPrice.getText();
    }

    // Method to enter comments
    public void enterComments(String comments) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(commentsTextAreaLocator));
        commentsField.clear();
        commentsField.sendKeys(comments);
    }

    // Method to click Place Order button
    public void clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(placeorderButtonLocator));
        placeOrderButton.click();
    }

    // Method to click Submit Order button
    public void clickSubmitOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitOrderButton = wait.until(ExpectedConditions.elementToBeClickable(submitOrderButtonLocator));
        submitOrderButton.click();
    }

    // Method to check if Place Order button is displayed
    public boolean isPlaceOrderButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(placeorderButtonLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to check if Submit Order button is displayed
    public boolean isSubmitOrderButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(submitOrderButtonLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
