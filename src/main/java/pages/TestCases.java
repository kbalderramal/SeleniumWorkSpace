package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class TestCases {
    private WebDriver driver;


    private By testCasesTextLocator = By.xpath("//*[contains(text(),'Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:')]");//Testcase
    private By allProductsTextLocator = By.xpath("//a[starts-with(., 'Test Case')]");

    // Constructor
    public TestCases(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get test cases introduction text
    public String getTestCasesIntroText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement introText = wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesTextLocator));
        return introText.getText();
    }

    // Method to check if test cases page is displayed
    public boolean isTestCasesPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesTextLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to get all test case links
    public List<WebElement> getAllTestCaseLinks() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allProductsTextLocator));
    }

    // Method to get count of test cases
    public int getTestCaseCount() {
        return getAllTestCaseLinks().size();
    }

    // Method to click on a specific test case by index
    public void clickTestCaseByIndex(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> testCases = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allProductsTextLocator));
        if (index >= 0 && index < testCases.size()) {
            testCases.get(index).click();
        }
    }

    // Method to click on a specific test case by name
    public void clickTestCaseByName(String testCaseName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> testCases = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allProductsTextLocator));
        for (WebElement testCase : testCases) {
            if (testCase.getText().equalsIgnoreCase(testCaseName)) {
                testCase.click();
                break;
            }
        }
    }

    // Method to verify if a specific test case exists
    public boolean isTestCasePresent(String testCaseName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> testCases = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allProductsTextLocator));
        for (WebElement testCase : testCases) {
            if (testCase.getText().equalsIgnoreCase(testCaseName)) {
                return true;
            }
        }
        return false;
    }
}
