package CommonFunctions.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CategoryProducts1 {
    private WebDriver driver;

    @FindBy(xpath = "(//div[@class='productinfo text-center']/a[contains(text(),'Add to cart')])[1]")
    private WebElement firstProductAddToCartButton;

    @FindBy(xpath = "//*[contains(text(),'Your product has been added to cart.')]")
    private WebElement productAddedText;

    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    private WebElement continueShoppingButton;

    public CategoryProducts1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstProductAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstProductAddToCartButton)).click();
    }

    public String getProductAddedText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(productAddedText)).getText();
    }

    public boolean isProductAddedMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(productAddedText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickContinueShopping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
    }

    public boolean isContinueShoppingButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(continueShoppingButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}