package CommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Validations {

    // Basic element presence validation
    public static void elementExists(By locator, boolean shouldExist) {
        List<WebElement> elements = SuperTest.driver.findElements(locator);
        boolean exists = !elements.isEmpty();
        Assert.assertEquals(exists, shouldExist,
                "Element existence validation failed for: " + locator);
    }

    // Text validation for elements
    public static void elementHasText(By locator, String expectedText) {
        WebElement element = SuperTest.driver.findElement(locator);
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText,
                "Text validation failed for: " + locator);
    }

    // Page title validation
    public static void pageTitleIs(String expectedTitle) {
        String actualTitle = SuperTest.driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle,
                "Page title validation failed");
    }

    // Element visibility check (simple version)
    public static void elementIsVisible(By locator, boolean shouldBeVisible) {
        try {
            boolean isVisible = SuperTest.driver.findElement(locator).isDisplayed();
            Assert.assertEquals(isVisible, shouldBeVisible,
                    "Visibility validation failed for: " + locator);
        } catch (Exception e) {
            if (shouldBeVisible) {
                Assert.fail("Element should be visible but wasn't found: " + locator);
            }
        }
    }

    // Simple URL contains check
    public static void urlContains(String expectedText) {
        String currentUrl = SuperTest.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedText),
                "URL should contain: " + expectedText);
    }
}