package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryProducts1 {
    private WebDriver driver;

    private By firstProductLocator = By.xpath("(//div[@class='productinfo text-center']/a[contains(text(),'Add to cart')])[1]");
    private By productAddedTextLocator = By.xpath("//*[contains(text(),'Your product has been added to cart.')]");
    private By contniueButtonLocator = By.xpath("//button[contains(text(),'Continue Shopping')]");
}
