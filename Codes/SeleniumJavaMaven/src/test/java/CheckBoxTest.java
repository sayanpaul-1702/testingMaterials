import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class CheckBoxTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter checkbox to select(1/2): ");
        String input = sc.nextLine();


        WebDriver driver = new EdgeDriver();

        driver.get("https://practice.expandtesting.com/checkboxes");

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> checkboxes = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@class='form-check-input' and @type='checkbox']"))
        );



        for(WebElement checkbox: checkboxes){

            if(checkbox.getAttribute("id").contains(input)){
                checkbox.click();
            }
        }
    }
}
