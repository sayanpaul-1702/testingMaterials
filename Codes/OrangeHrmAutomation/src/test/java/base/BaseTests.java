package base;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTests {
    protected static WebDriver driver;

    @BeforeSuite
    public void setUp(){
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        if(driver != null)
            driver.quit();
    }
}
