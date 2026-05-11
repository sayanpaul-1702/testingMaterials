
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class OrangeHrmTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee to search in OrangeHRM");
        String empUserName = sc.nextLine();


        WebDriver driver = new EdgeDriver();
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

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("oxd-sidepanel-body"))
        );

        WebElement admin = driver.findElements(By.className("oxd-main-menu-item"))
                .stream()
                .map(item -> item.findElement(By.tagName("span")))
                .filter(spanItem -> spanItem.getText().equalsIgnoreCase("admin"))
                .findFirst().get();

        admin.click();

        WebElement filterContainer = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("oxd-table-filter"))
        );


        WebElement filterInput = filterContainer.findElement(By.className("oxd-input"));
        filterInput.sendKeys(empUserName);

        WebElement submit = filterContainer.findElement(By.xpath("//button[@type='submit' and contains(@class,'oxd-button')]"));

        wait.until(
                ExpectedConditions.elementToBeClickable(submit)
        );
        submit.click();




    }
}
