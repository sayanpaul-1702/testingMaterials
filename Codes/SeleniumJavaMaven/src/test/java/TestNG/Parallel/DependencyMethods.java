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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class DependencyMethods {

    private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> tlwait = new ThreadLocal<>();

    public static ThreadLocal<WebDriver> getTldriver() {
        return tldriver;
    }

    public static void setTldriver(ThreadLocal<WebDriver> tldriver) {
        DependencyMethods.tldriver = tldriver;
    }

    @BeforeClass
    @Parameters({"browser"})
    public void setup(String br){
        WebDriver driver;
        WebDriverWait wait;
        switch(br){
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();

                driver = new EdgeDriver(edgeOptions);
                break;
            case "chrome":
                ChromeOptions options = new ChromeOptions();

                driver = new ChromeDriver(options);
                break;
            default: return;
        }
        driver.manage().window().maximize();
        tldriver.set(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        tlwait.set(wait);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @Test(priority = 1)
    public void login(){
        System.out.println("Locating username field....");
        WebDriverWait wait = tlwait.get();
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
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))
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
        WebDriverWait wait = tlwait.get();
        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']"))
        );
        search.sendKeys("HELLO");

        Assert.assertEquals(search.getAttribute("value"),"HELLO");
    }

    @Test(priority = 3, dependsOnMethods = {"login"})       //wont run if login() fails
    public void logout(){
        WebDriverWait wait = tlwait.get();
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

    @AfterClass
    public void tearDown(){
        WebDriver driver = tldriver.get();
        if(driver != null)
            driver.quit();
        tldriver.remove();
        tlwait.remove();
    }
}
