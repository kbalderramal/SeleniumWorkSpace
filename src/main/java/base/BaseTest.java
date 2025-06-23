package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;//Create instance of WebDriver
    private String actualPageTitle = driver.getTitle();//Page title

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();//Initialize instance of driver with ChromeDriver
        driver.manage().window().maximize();//Maximize window to full size
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));//Add some waiting during execution
        driver.get("https://automationexercise.com/");//Open link
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();//Close all active windows
    }
}
