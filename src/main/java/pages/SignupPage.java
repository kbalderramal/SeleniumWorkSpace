package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private WebDriver driver;

    // Signup Form Mandatory Fields
    private By enterInfoTextLocator = By.xpath("//*[contains(text(),'Enter Account Information')]");
    private By passwordFieldLocator = By.xpath("//input[@data-qa='password']");
    private By firstNameFieldLocator = By.xpath("//input[@data-qa='first_name']");
    private By lastNameFieldLocator = By.xpath("//input[@data-qa='last_name']");
    private By addressFieldLocator = By.xpath("//input[@data-qa='address']");
    private By countryDropdownLocator = By.xpath("//select[@data-qa='country']");
    private By stateFieldLocator = By.xpath("//input[@data-qa='state']");
    private By cityFieldLocator = By.xpath("//input[@data-qa='city']");
    private By zipcodeFieldLocator = By.xpath("//input[@data-qa='zipcode']");
    private By mobileNumberFieldLocator = By.xpath("//input[@data-qa='mobile_number']");

    //create account button
    private By createAccountButtonLocator = By.xpath("//button[@data-qa='create-account']");


}
