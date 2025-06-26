package CommonFunctions.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Checkout {
    private WebDriver driver;

    @FindBy(xpath = "//td[@class='cart_description']/h4/a")
    private WebElement productDescription;

    @FindBy(xpath = "//td[@class='cart_price']/p")
    private WebElement productPrice;

    @FindBy(xpath = "//td[@class='cart_quantity']/button")
    private WebElement productQuantity;

    @FindBy(xpath = "//tbody/tr[last()]//p[@class='cart_total_price']")
    private WebElement totalPrice;

    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement commentsTextArea;

    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    private WebElement placeOrderButton;

    @FindBy(id = "submit")
    private WebElement submitOrderButton;

    public Checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductDescription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(productDescription)).getText();
    }

    public String getProductPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(productPrice)).getText();
    }

    public String getProductQuantity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(productQuantity)).getText();
    }

    public String getTotalPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(totalPrice)).getText();
    }

    public void enterComments(String comments) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(commentsTextArea)).clear();
        commentsTextArea.sendKeys(comments);
    }

    public void clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public void clickSubmitOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitOrderButton)).click();
    }

    public boolean isPlaceOrderButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(placeOrderButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSubmitOrderButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(submitOrderButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}