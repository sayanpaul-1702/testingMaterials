import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleFrame {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.expandtesting.com/iframe");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement iframe = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("email-subscribe"))
        );

        Actions action = new Actions(driver);
        action.scrollToElement(iframe).perform();

        driver.switchTo().frame(iframe);

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("email"))
        );

        input.sendKeys("Hello World");

        driver.switchTo().parentFrame();

        WebElement footer = driver.findElement(By.xpath("//h4[text() = 'Practice Test Automation WebSite for Web UI and Rest API']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("""
                    arguments[0].style.border = '2px solid red'
                """, footer);


    }
}
