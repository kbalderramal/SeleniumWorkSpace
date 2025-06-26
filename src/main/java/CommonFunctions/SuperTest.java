package CommonFunctions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;

public class SuperTest {
    public static WebDriver driver; //Create instance of WebDriver

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();//Initialize instance of driver with ChromeDriver
        driver.manage().window().maximize();//Maximize window to full size
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));//Add some waiting during execution
        driver.get("https://automationexercise.com/");//Open link
    }

    public void validatePageTitle(String expectedPageTitle){
        try {
            String actualPageTitle = driver.getTitle();
            if (actualPageTitle.equals(expectedPageTitle)) {
                System.out.println("Page title validation passed. Expected: " +
                        expectedPageTitle + ", Actual: " + actualPageTitle);
            } else {
                System.err.println("Page title validation failed. Expected: " +
                        expectedPageTitle + ", Actual: " + actualPageTitle);
            }
        } catch (Exception e) {
            System.err.println("Exception while validating title: " + e.getMessage());
        }
    }

    public static void takeScreenshot() {
        SecureRandom random = new SecureRandom();
        int randomNum = 1000 + random.nextInt(9000);

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshots" + randomNum + ".png");

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {// Checks if the WebDriver instance exists
            driver.quit();// Safely closes the browser and terminates the WebDriver session
        }
    }
}
