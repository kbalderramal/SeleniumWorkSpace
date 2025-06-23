package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {
    private WebDriver driver;


    private By descriptionLocator = By.xpath("//td[@class='cart_description']/h4/a");
    private By priceLocator = By.xpath("//td[@class='cart_price']/p");
    private By quantityLocator = By.xpath("//td[@class='cart_quantity']/button");
    private By totalPriceLocator = By.xpath("//tbody/tr[last()]//p[@class='cart_total_price']");
    private By commentsTextAreaLocator = By.xpath("//textarea[@name='message']");
    private By placeorderButtonLocator = By.xpath("//a[contains(text(),'Place Order')]");
    private By submitOrderButtonLocator = By.id("submit");

}
