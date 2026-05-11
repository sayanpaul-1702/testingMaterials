import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.expandtesting.com/hovers");
        driver.manage().window().maximize();

        //MOUSE ACTIONS

        //hover & click
        WebElement img1Hover = driver.findElement(By.xpath("//img[@data-testid='img-user-1']"));
        WebElement img2Hover = driver.findElement(By.xpath("//img[@data-testid='img-user-2']"));

        Actions action = new Actions(driver);

        action.moveToElement(img1Hover).perform();
        Thread.sleep(2000);
        action.moveToElement(img2Hover)
                .contextClick(img2Hover)
                .click()
                .perform();

        Thread.sleep(2000);

        //KEYBOARD ACTIONS

        driver.get("https://practice.expandtesting.com/");

        WebElement search = driver.findElement(By.id("search-input"));

        action.moveToElement(search)
                .click()
                .sendKeys("abcdef")         //write
                .keyDown(Keys.CONTROL)      //CTRL pressed
                .sendKeys("a")              // A clicked -> CTRL + A
                .keyUp(Keys.CONTROL)        //CTRL released
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.BACK_SPACE)   //BACKSPACE pressed
                .keyUp(Keys.BACK_SPACE)     //BACKSPACE released
                .perform();

        //DRAG & DROP

        Thread.sleep(2000);

        driver.get("https://practice.expandtesting.com/drag-and-drop");

        WebElement divA = driver.findElement(By.id("column-a"));
        WebElement divB = driver.findElement(By.id("column-b"));

        action.dragAndDrop(divA,divB).perform();





    }
}
