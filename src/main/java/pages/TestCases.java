package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCases {
    private WebDriver driver;


    private By testCasesTextLocator = By.xpath("//*[contains(text(),'Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:')]");//Testcase
    private By allProductsTextLocator = By.xpath("//a[starts-with(., 'Test Case')]");

}
