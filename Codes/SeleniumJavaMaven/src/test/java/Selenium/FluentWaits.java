package Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;

public class FluentWaits { // Do not change the class name

    // Use the below declared variables
    public static WebDriver driver;
    WebElement fileNametxt;
    static String Filename;
    String baseUrl = "https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_stud.html";

    public FluentWaits(WebDriver driver) {
        this.driver = driver;
    }

    public FluentWaits() {
    }

    private WebDriver getDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }

    public WebDriver setupDriver() { // Do not change the method signature

        // Invoke the getDriver() method from the DriverSetup File
        // Store it in static variable 'driver', navigate and return it
        driver = getDriver();

        // Please do NOT remove the below URL navigation code
        driver.get(baseUrl);
        // return driver
        return driver;
    }

    public String getPageTitle() {

        // get the page title and return the same

        return driver.getTitle();
    }

    public WebElement clickPhotoUploadBtn() {
        // Click the photo upload button
        driver.findElement(By.id("file1")).click();
        // Create a FluentWait instance with a timeout of 10 seconds, polling every 1 second
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1));

        // Wait for the filename element to become visible
        fileNametxt = wait.until(
                driver -> driver.findElement(By.id("filename"))
        );
        // Retrieve the text of the filename element
        Filename = fileNametxt.getText();
        // Return the WebElement of the filename element
        System.out.println(fileNametxt);
        return fileNametxt;

    }

    public static void main(String[] args) { // Do not change the method signature

        FluentWaits reg = new FluentWaits();
        reg.setupDriver();
        System.out.println(reg.getPageTitle());
        reg.clickPhotoUploadBtn();

    }

}
