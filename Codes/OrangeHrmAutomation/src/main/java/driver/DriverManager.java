package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser){
        if(driver == null){
            switch (browser.toLowerCase()){
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default: throw new IllegalArgumentException("Provided Browser not found");
            }
        }
        return driver;
    }

    private static void initDriver() {
        driver.manage().window().maximize();
    }
}
