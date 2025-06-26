package CommonFunctions.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class TestCases {
    private WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:')]")
    private WebElement testCasesIntroText;

    @FindBy(xpath = "//a[starts-with(., 'Test Case')]")
    private List<WebElement> testCaseLinks;

    public TestCases(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTestCasesIntroText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(testCasesIntroText)).getText();
    }

    public boolean isTestCasesPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(testCasesIntroText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public List<WebElement> getAllTestCaseLinks() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfAllElements(testCaseLinks));
    }

    public int getTestCaseCount() {
        return getAllTestCaseLinks().size();
    }

    public void clickTestCaseByIndex(int index) {
        List<WebElement> testCases = getAllTestCaseLinks();
        if (index >= 0 && index < testCases.size()) {
            testCases.get(index).click();
        }
    }

    public void clickTestCaseByName(String testCaseName) {
        List<WebElement> testCases = getAllTestCaseLinks();
        for (WebElement testCase : testCases) {
            if (testCase.getText().equalsIgnoreCase(testCaseName)) {
                testCase.click();
                break;
            }
        }
    }

    public boolean isTestCasePresent(String testCaseName) {
        List<WebElement> testCases = getAllTestCaseLinks();
        for (WebElement testCase : testCases) {
            if (testCase.getText().equalsIgnoreCase(testCaseName)) {
                return true;
            }
        }
        return false;
    }
}