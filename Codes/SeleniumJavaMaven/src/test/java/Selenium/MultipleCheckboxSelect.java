package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultipleCheckboxSelect {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement checkboxGroup = driver.findElement(By.className("form-group"));
        Actions act = new Actions(driver);

        act.scrollToElement(checkboxGroup).perform();

        Set<String> set = new HashSet<>(List.of("sunday", "monday", "tuesday", "thursday"));

        List<WebElement> checkboxes = checkboxGroup.findElements(By.xpath("//input[@type='checkbox']"));

        checkboxes.forEach(c ->{
            if(set.contains(c.getAttribute("value").toLowerCase())){
                act.moveToElement(c).click().perform();
            }
        });

    }
}
