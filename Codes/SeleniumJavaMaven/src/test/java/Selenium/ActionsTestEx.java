package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsTestEx {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement emailInput = driver.findElement(By.id("email"));

        nameInput.sendKeys("hello");

        Actions act = new Actions(driver);
        Thread.sleep(2000);
        //cut
        act.moveToElement(nameInput)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("x")
                .keyUp(Keys.CONTROL)
                .perform();
        Thread.sleep(2000);
        //paste
        act.moveToElement(emailInput)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();
    }
}
