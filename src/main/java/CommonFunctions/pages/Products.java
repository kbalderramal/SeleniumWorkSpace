package CommonFunctions.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Products {
    private WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(),'All Products')]")
    private WebElement allProductsText;

    @FindBy(xpath = "//div[@id='accordian']//a[normalize-space()='Women']")
    private WebElement womenCategory;

    @FindBy(xpath = "//div[@id='Women']//a[normalize-space()='Dress']")
    private WebElement dressSubCategory;

    public Products(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAllProductsText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(allProductsText)).getText();
    }

    public boolean isAllProductsTextDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(allProductsText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickWomenCategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(womenCategory)).click();
    }

    public boolean isWomenCategoryDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(womenCategory)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickDressSubCategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dressSubCategory)).click();
    }

    public boolean isDressSubCategoryDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(dressSubCategory)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void navigateToWomenDressCategory() {
        clickWomenCategory();
        clickDressSubCategory();
    }
}