package TestNG.Parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class DependencyMethods {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(String br){
        switch(br){
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            default: return;
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void login(){
        System.out.println("Locating username field....");
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username"))
        );
        username.sendKeys("Admin");
        System.out.println("Locating password field....");
        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("password"))
        );
        password.sendKeys("admin123");
        System.out.println("Locating login button....");
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.className("orangehrm-login-button"))
        );
        loginBtn.click();

        WebElement dashboardTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']"))
        );

        Assert.assertEquals(dashboardTitle.getText(),"Dashboard");
    }

    @Test(priority = 2,dependsOnMethods = {"login"})    //wont run if login() fails
    public void search(){
        System.out.println("Locating search bar....");
        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']"))
        );
        search.sendKeys("HELLO");

        Assert.assertEquals(search.getAttribute("value"),"HELLO");
    }

    @Test(priority = 3, dependsOnMethods = {"login"})       //wont run if login() fails
    public void logout(){
        WebElement logoutDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(By.className("oxd-userdropdown-tab"))
        );

        logoutDropdown.click();
        System.out.println("Logging out....");
        WebElement logout = wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Logout"))
        );

        logout.click();
    }
}
