package CommonFunctions.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignupPage {
    private WebDriver driver;

    // Signup Form Elements
    @FindBy(xpath = "//*[contains(text(),'Enter Account Information')]")
    private WebElement enterInfoText;

    @FindBy(xpath = "//input[@data-qa='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@data-qa='first_name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@data-qa='last_name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@data-qa='address']")
    private WebElement addressField;

    @FindBy(xpath = "//select[@data-qa='country']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//input[@data-qa='state']")
    private WebElement stateField;

    @FindBy(xpath = "//input[@data-qa='city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@data-qa='zipcode']")
    private WebElement zipcodeField;

    @FindBy(xpath = "//input[@data-qa='mobile_number']")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getEnterAccountInfoText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(enterInfoText)).getText();
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(password);
    }

    public void enterFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(lastNameField)).clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addressField)).clear();
        addressField.sendKeys(address);
    }

    public void selectCountry(String country) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        new Select(countryDropdown).selectByVisibleText(country);
    }

    public void enterState(String state) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(stateField)).clear();
        stateField.sendKeys(state);
    }

    public void enterCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cityField)).clear();
        cityField.sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(zipcodeField)).clear();
        zipcodeField.sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mobileNumberField)).clear();
        mobileNumberField.sendKeys(mobileNumber);
    }

    public void clickCreateAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
    }

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

    public boolean isSignupFormDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.visibilityOf(enterInfoText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}