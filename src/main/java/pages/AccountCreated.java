package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreated {
    private WebDriver driver;

    private By accountTextLocator = By.xpath("//*[contains(text(),'Account Created!')]");
    private By continueButtonLocator = By.xpath("//*[contains(text(),'Continue') and @data-qa='continue-button']");
}
