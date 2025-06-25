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

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();//Initialize instance of driver with ChromeDriver
        driver.manage().window().maximize();//Maximize window to full size
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));//Add some waiting during execution
        driver.get("https://automationexercise.com/");//Open link
    }

    @Test (priority = 1)
    public void test1(){
        validatePageTitle("Automation Exercise");//Title validation
        System.out.println("Running Test Case 1");
    }

    @Test (priority = 2)
    public void test2(){
        validatePageTitle("Automation Exercise");//Title validation
        System.out.println("Running Test Case 2");
    }

    @Test (priority = 3)
    public void test3(){
        validatePageTitle("Automation Exercise");//Title validation
        System.out.println("Running Test Case 3");
    }

    @Test (priority = 4)
    public void test4(){
        validatePageTitle("Automation Exercise");//Title validation
        System.out.println("Running Test Case 4");
    }

    @Test (priority = 5)
    public void test5(){
        validatePageTitle("Automation Exercise");//Title validation
        System.out.println("Running Test Case 5");
    }

    @Test (priority = 6)
    public void test6(){
        validatePageTitle("Automation Exercise");//Title validation
        System.out.println("Running Test Case 6");
    }

    @Test (priority = 7)
    public void test7(){
        validatePageTitle("Automation Exercise");//Title validation
        System.out.println("Running Test Case 7");
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

    @AfterMethod
    public void tearDown() {
        if (driver != null) {// Checks if the WebDriver instance exists
            driver.quit();// Safely closes the browser and terminates the WebDriver session
        }
    }
}
