package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import utils.ScreenshotUtil;

public class LogInTest extends BaseTest {
    private final String USERNAME = "balderramak73@gmail.com";
    private final String PASSWORD = "aptapt";
    private final String LOGIN_TEXT = "Login to your account";
    private static final String INVALID_USERNAME = "invalid@user.com";
    private static final String INVALID_PASSWORD = "wrongpassword";
    private static final String EXPECTED_LOGIN_TEXT = "Login to your account";
    private static final String EXPECTED_ERROR_MESSAGE = "Your email or password is incorrect!";
    private static final String SCREENSHOT_DIR = "test-output/screenshots/";

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


    @Test
    public void testInvalidLogin() {
        // Step 2: Validate title is handled in BaseTest's setUp() method

        HomePage homePage = new HomePage(driver);

        // Step 3: Click on Signup/Login button
        homePage.clickSignUpLoginButton();

        LogInPage logInPage = new LogInPage(driver);

        // Step 4: Validate text "Login to your account" is present
        String actualLoginText = logInPage.getLoginText();
        Assert.assertEquals(actualLoginText, EXPECTED_LOGIN_TEXT,
                "Login section header text validation failed. Expected: " + EXPECTED_LOGIN_TEXT +
                        " but got: " + actualLoginText);

        // Step 5: Enter invalid username
        // Step 6: Enter invalid password
        // Step 7: Click on Login button
        logInPage.login(INVALID_USERNAME, INVALID_PASSWORD);

        // Step 8: Validate error message
        Assert.assertTrue(homePage.isErrorMessageDisplayed(),
                "Error message is not displayed after invalid login attempt");

        String actualErrorMessage = homePage.getErrorMessageText();
        Assert.assertEquals(actualErrorMessage, EXPECTED_ERROR_MESSAGE,
                "Error message validation failed. Expected: " + EXPECTED_ERROR_MESSAGE +
                        " but got: " + actualErrorMessage);
    }

}