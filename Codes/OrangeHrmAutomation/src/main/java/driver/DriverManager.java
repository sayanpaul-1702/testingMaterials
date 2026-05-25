package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

    private static void initDriver() {
        driver.manage().window().maximize();
    }
}
