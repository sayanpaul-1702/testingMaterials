import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHrmTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //wait until element is visible
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("orangehrm-login-form"))
        );

        WebElement username = driver.findElement(By.name("username"));

        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));

        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();

    }
}
