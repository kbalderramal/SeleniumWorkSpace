package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import utils.ScreenshotUtil;

public class LogInTest extends BaseTest {
    private final String USERNAME = "your_username@example.com";
    private final String PASSWORD = "your_password";
    private final String LOGIN_TEXT = "Login to your account";

    @Test
    public void testLoginAndLogout() {
        try {
            // Initialize page objects
            HomePage homePage = new HomePage(driver);
            LogInPage logInPage = new LogInPage(driver);

            // Step 3: Click on Signup/Login button
            homePage.clickSignUpLoginButton();

            // Step 4: Validate text "Login to your account" is present
            String actualLoginText = logInPage.getLoginText();
            Assert.assertEquals(actualLoginText, LOGIN_TEXT,
                    "Login text validation failed. Expected: " + LOGIN_TEXT +
                            " but got: " + actualLoginText);

            // Step 5: Enter username
            // Step 6: Enter password
            // Step 7: Click on Login button
            logInPage.login(USERNAME, PASSWORD);

            // Step 8: Validate Delete Account button is present
            Assert.assertTrue(homePage.isUserLoggedIn(), "Delete Account button is not present after login");

            // Take screenshot after successful login
            ScreenshotUtil.captureScreenshot(driver, "AfterLogin");

            // Step 9: Click on logout button
            homePage.clickLogoutButton();

            // Step 10: Validate delete account button is not present
            Assert.assertFalse(homePage.isUserLoggedIn(), "Delete Account button is still present after logout");

            // Take screenshot after logout
            ScreenshotUtil.captureScreenshot(driver, "AfterLogout");

        } catch (Exception e) {
            ScreenshotUtil.captureScreenshot(driver, "TestFailure");
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}