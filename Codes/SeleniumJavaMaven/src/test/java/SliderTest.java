import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/horizontal-slider");

        Actions action = new Actions(driver);

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        int x = slider.getLocation().getX();
        int y = slider.getLocation().getY();

        System.out.println("Before sliding: " + slider.getAttribute("value"));

        action.dragAndDropBy(slider,20,0).perform();
        System.out.println("After sliding: " + slider.getAttribute("value"));


    }
}
