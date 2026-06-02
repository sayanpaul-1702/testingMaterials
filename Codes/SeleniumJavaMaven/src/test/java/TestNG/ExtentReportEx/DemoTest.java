package TestNG.ExtentReportEx;

import TestNG.ExtentReportEx.Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String baseUrl = "https://practice.expandtesting.com/";

    @BeforeClass
    void setup(){
        String browserName = ConfigReader.get("browser.name");
        switch (browserName.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver= new EdgeDriver();
                break;
            default: throw new IllegalArgumentException("Provided browser not found");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void openPage(){
        driver.get(baseUrl);
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl);
    }

    @Test(priority = 2)
    void search(){
        WebElement searchElmt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("search-input"))
        );
        searchElmt.clear();
        searchElmt.sendKeys("Login");

        //fail test
        Assert.assertFalse(searchElmt.getAttribute("value").equalsIgnoreCase("Login"));
    }

    //skip test
    @Test(priority = 3, dependsOnMethods = {"search"})
    void openAfterSearch(){
        WebElement testLoginPageElmt = wait.until(
                ExpectedConditions.elementToBeClickable(By.partialLinkText("Test Login"))
        );

        testLoginPageElmt.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://practice.expandtesting.com/login");
    }
}
