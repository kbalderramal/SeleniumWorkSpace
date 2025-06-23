package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products {
    private WebDriver driver;

    //Text
    private By allProductsTextLocator = By.xpath("//h2[contains(text(),'All Products')]");
    private By womenCategoryTextLocator = By.xpath("//div[@id='accordian']//a[normalize-space()='Women']");
    private By dressSubCategoryTextLocator = By.xpath("//div[@id='Women']//a[normalize-space()='Dress']");

}
