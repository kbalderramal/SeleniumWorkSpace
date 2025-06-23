package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePage {
    private WebDriver driver;

    //Buttons
    private By signUpLoginButtonLocator = By.xpath("//a[contains(text(),' Signup / Login')]");//Signup/Login
    private By deleteButtonLocator = By.xpath("//a[@href='/delete_account' and contains(text(), 'Delete Account')]");//Delete account
    private By logOutButtonLocator = By.xpath("//a[@href='/logout' and contains(text(), ' Logout')]");//Logout
    private By productsButtonLocator = By.xpath("//a[@href='/products' and contains(text(), ' Products')]");//Products
    private By testCasesButtonLocator = By.xpath("//a[@href='/test_cases' and contains(text(),' Test Cases')]");//Testcase
    private By cartButtonLocator = By.xpath("//a[@href='/view_cart' and contains(text(),' Cart')]");
    //Text
    private By errorMessageTextLocator = By.xpath("//*[contains(text(),'Your email or password is incorrect!')]");
    private By proceedCheckoutTextLocator = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private By reviewOrderTextLocator = By.xpath("//*[contains(text(),'Review Your Order')]");

}