import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();

        WebElement textBoxAlertHref = wait.until(
                ExpectedConditions.elementToBeClickable(By.partialLinkText("Alert with Textbox"))
        );
        textBoxAlertHref.click();

        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'prompt box')]"))
        );

        btn.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("ADMIN");
        alert.accept();



    }
}
