package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ScreenshotUtil;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;//Create instance of WebDriver
    protected final String EXPECTED_TITLE = "Automation Exercise";//Page expected title

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();//Initialize instance of driver with ChromeDriver
        driver.manage().window().maximize();//Maximize window to full size
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));//Add some waiting during execution
        driver.get("https://automationexercise.com/");//Open link
        validatePageTitle();//Validate title
    }

    protected void validatePageTitle() {
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, EXPECTED_TITLE,
                "Page title validation failed. Expected: " + EXPECTED_TITLE +
                        " but got: " + actualPageTitle);
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtil.captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }
}
