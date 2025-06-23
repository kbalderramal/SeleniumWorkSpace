package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs {
    private WebDriver driver;

    //Text
    private By allProductsTextLocator = By.xpath("//h2[contains(text(), 'Contact ')]");
    //Contact form
    private By nameFieldLocator = By.name("name");
    private By emailFieldLocator = By.name("email");
    private By subjectFieldLocator = By.name("email");
    private By messageButtonLocator = By.name("submit");
    private By successTextLocator = By.xpath("//div[@class='contact-form']//div[contains(text(),'Success! Your details have been submitted successfully.')]") ;

}
