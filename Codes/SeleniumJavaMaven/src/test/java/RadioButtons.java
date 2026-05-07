import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RadioButtons {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();

        driver.get("https://practice.expandtesting.com/radio-buttons");

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement color = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='color' and @id='black']"))
        );
        color.click();
        WebElement sports = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='sport' and @id='football']"))
        );
        sports.click();
    }
}
