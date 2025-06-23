package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignupPage {
    private WebDriver driver;

    // Signup Form Mandatory Fields
    private By enterInfoTextLocator = By.xpath("//*[contains(text(),'Enter Account Information')]");
    private By passwordFieldLocator = By.xpath("//input[@data-qa='password']");
    private By firstNameFieldLocator = By.xpath("//input[@data-qa='first_name']");
    private By lastNameFieldLocator = By.xpath("//input[@data-qa='last_name']");
    private By addressFieldLocator = By.xpath("//input[@data-qa='address']");
    private By countryDropdownLocator = By.xpath("//select[@data-qa='country']");
    private By stateFieldLocator = By.xpath("//input[@data-qa='state']");
    private By cityFieldLocator = By.xpath("//input[@data-qa='city']");
    private By zipcodeFieldLocator = By.xpath("//input[@data-qa='zipcode']");
    private By mobileNumberFieldLocator = By.xpath("//input[@data-qa='mobile_number']");

    //create account button
    private By createAccountButtonLocator = By.xpath("//button[@data-qa='create-account']");

    // Constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get "Enter Account Information" text
    public String getEnterAccountInfoText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement infoText = wait.until(ExpectedConditions.visibilityOfElementLocated(enterInfoTextLocator));
        return infoText.getText();
    }

    // Method to enter password
    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    // Method to enter first name
    public void enterFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFieldLocator));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    // Method to enter last name
    public void enterLastName(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFieldLocator));
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    // Method to enter address
    public void enterAddress(String address) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(addressFieldLocator));
        addressField.clear();
        addressField.sendKeys(address);
    }

    // Method to select country from dropdown
    public void selectCountry(String country) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdownLocator));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(country);
    }

    // Method to enter state
    public void enterState(String state) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement stateField = wait.until(ExpectedConditions.visibilityOfElementLocated(stateFieldLocator));
        stateField.clear();
        stateField.sendKeys(state);
    }

    // Method to enter city
    public void enterCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(cityFieldLocator));
        cityField.clear();
        cityField.sendKeys(city);
    }

    // Method to enter zipcode
    public void enterZipcode(String zipcode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement zipcodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(zipcodeFieldLocator));
        zipcodeField.clear();
        zipcodeField.sendKeys(zipcode);
    }

    // Method to enter mobile number
    public void enterMobileNumber(String mobileNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mobileNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberFieldLocator));
        mobileNumberField.clear();
        mobileNumberField.sendKeys(mobileNumber);
    }

    // Method to click create account button
    public void clickCreateAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(createAccountButtonLocator));
        createAccountButton.click();
    }

    // Method to fill complete signup form
    public void completeSignupForm(String password, String firstName, String lastName,
                                   String address, String country, String state,
                                   String city, String zipcode, String mobileNumber) {
        enterPassword(password);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        selectCountry(country);
        enterState(state);
        enterCity(city);
        enterZipcode(zipcode);
        enterMobileNumber(mobileNumber);
        clickCreateAccountButton();
    }

    // Method to check if signup form is displayed
    public boolean isSignupFormDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(enterInfoTextLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
