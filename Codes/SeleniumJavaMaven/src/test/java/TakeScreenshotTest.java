import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class TakeScreenshotTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.expandtesting.com/");
        driver.manage().window().maximize();

        TakesScreenshot ts = (TakesScreenshot) driver;

        //1) Full Page
        File targetDir = new File(System.getProperty("user.dir") + "\\screenshots");
        targetDir.mkdirs();
        File targetFile = new File(targetDir,"fullpage.png");
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        sourceFile.renameTo(targetFile);

        //2) Specific part of page
        File specificPartFile = new File(targetDir, "home-header.png");
        WebElement homeHeader = driver.findElement(By.id("home-header"));
        sourceFile = homeHeader.getScreenshotAs(OutputType.FILE);   //take screenshot using the element
        sourceFile.renameTo(specificPartFile);

        //3) capture web element
        File webElementFile = new File(targetDir, "logo.png");
        WebElement logo = driver.findElement(By.xpath("//img[contains(@alt, 'Best Website for Practice Automation Testing')]"));
        sourceFile = logo.getScreenshotAs(OutputType.FILE);
        sourceFile.renameTo(webElementFile);

    }
}
