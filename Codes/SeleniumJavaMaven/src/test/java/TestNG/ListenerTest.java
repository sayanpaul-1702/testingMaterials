package TestNG;

import TestNG.Listeners.MyListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;


public class ListenerTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String baseUrl = "https://practice.expandtesting.com/";

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
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
