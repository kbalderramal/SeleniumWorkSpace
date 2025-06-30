package CommonFunctions.tests;

import CommonFunctions.SuperTest;
import CommonFunctions.pages.HomePage;
import CommonFunctions.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class ValidateLogIn extends SuperTest {

    @Test
    public void testValidLogIn() {
        // Initialize Page Objects
        HomePage homePage = new HomePage(driver);
        LogInPage loginPage = new LogInPage(driver);

        // 2. Validate title of the page as "Automation Exercise"
        validatePageTitle("Automation Exercise");

        takeScreenshot(1);

        // 3. Click on Signup/Login button
        homePage.clickSignUpLoginButton();

        // 4. Validate text "Login to your account" is present
        String loginText = loginPage.getLoginText();
        Assert.assertTrue(loginText.contains("Login to your account"),
                "'Login to your account' text is not present");

        // 5. Enter username
        loginPage.enterLoginEmail("fakemail.25@gmail.com");

        // 6. Enter password
        loginPage.enterLoginPassword("password");

        takeScreenshot(1);

        // 7. Click on Login button
        loginPage.clickLoginButton();

        takeScreenshot(1);

        // 8. Validate Delete Account button is present
        Assert.assertTrue(homePage.isDeleteButtonPresent(),
                "Delete Account button is not present after login");

        // 9. Click on logout button
        homePage.clickLogoutButton();

        // 10. Validate delete account button is not present
        try {
            boolean isDisplayed = homePage.isDeleteButtonPresent();
            Assert.assertFalse(isDisplayed,
                    "Delete Account button is still present after logout");
        } catch (NoSuchElementException e) {
            // Expected behavior - element should not be present
            Assert.assertTrue(true);
        }

        takeScreenshot(1);

        // Browser will be closed in @AfterMethod
    }

    @Test
    public void testInvalidLogIn(){

    }
}
