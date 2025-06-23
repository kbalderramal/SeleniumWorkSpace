package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    private WebDriver driver;

    //Text
    private By logInTextLocator = By.xpath("//*[contains(text(),'Login to your account')]");
    private By newUserTextLocator = By.xpath("//*[contains(text(),'New User Signup!')]");
    //Login form
    private By emailAddressFieldLoginLocator = By.xpath("//*[contains(text(), 'Login to your account')]/following-sibling::form[1]//input[@type='email']");
    private By passwordFieldLocator = By.xpath("//*[contains(text(), 'Login to your account')]/following-sibling::form[1]//input[@type='password']");
    private By logInButtonLocator = By.xpath("//button[contains(text(),'Login')]");
    //Signup form
    private By nameFieldLocator = By.xpath("//*[contains(text(),'New User Signup!')]/following-sibling::form[1]//input[@data-qa='signup-name']");
    private By emailAddressFieldSignupLocator = By.xpath("//*[contains(text(),'New User Signup!')]/following-sibling::form[1]//input[@data-qa='signup-email']");
    private By signupButtonLocator = By.xpath("//button[contains(text(),'Signup')]");

}
