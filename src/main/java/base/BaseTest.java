package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {
    //public static void main(String[] args) throws InterruptedException {}
    WebDriver driver = new ChromeDriver();//Create instance of chromedriver
    @Test(priority = 1)
    public void launchUrl(){
        //Set Up
        System.setProperty("webdriver.chrome.driver","C:\\My Drivers\\chromedriver.exe");//Set path to chromedriver
        //driver.get("https://automationexercise.com/");//Get link
        driver.get("https://admin-demo.nopcommerce.com/login");

        driver.manage().window().maximize();//Maximize window to full size
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));//

        String title = driver.getTitle();
        System.out.println("Title: "+title);



        //driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");//wich is the same that the next two lines
        WebElement emailBox = driver.findElement(By.id("Email"));
        emailBox.clear();
        emailBox.sendKeys("admin@yourstore.com");

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.clear();
        passwordBox.sendKeys("admin");

        WebElement logButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button"));
        System.out.println("Text in button: "+logButton.getText());
        logButton.click();

        driver.close();
    }


    public void closeBrowser(){
        // Thread.sleep(3000);//Wait n seconds before execute next line
    }
}
