package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Products {
    private WebDriver driver;

    //Text
    private By allProductsTextLocator = By.xpath("//h2[contains(text(),'All Products')]");
    private By womenCategoryTextLocator = By.xpath("//div[@id='accordian']//a[normalize-space()='Women']");
    private By dressSubCategoryTextLocator = By.xpath("//div[@id='Women']//a[normalize-space()='Dress']");


    // Constructor
    public Products(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get "All Products" header text
    public String getAllProductsText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement allProductsText = wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsTextLocator));
        return allProductsText.getText();
    }

    // Method to check if "All Products" text is displayed
    public boolean isAllProductsTextDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsTextLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to click Women category
    public void clickWomenCategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement womenCategory = wait.until(ExpectedConditions.elementToBeClickable(womenCategoryTextLocator));
        womenCategory.click();
    }

    // Method to check if Women category is displayed
    public boolean isWomenCategoryDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(womenCategoryTextLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to click Dress subcategory
    public void clickDressSubCategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dressSubCategory = wait.until(ExpectedConditions.elementToBeClickable(dressSubCategoryTextLocator));
        dressSubCategory.click();
    }

    // Method to check if Dress subcategory is displayed
    public boolean isDressSubCategoryDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(dressSubCategoryTextLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to navigate to Women > Dress category
    public void navigateToWomenDressCategory() {
        clickWomenCategory();
        clickDressSubCategory();
    }

}
