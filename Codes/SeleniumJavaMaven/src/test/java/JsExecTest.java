import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JsExecTest {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://practice.expandtesting.com/");
        WebElement notifMsg = driver.findElement(By.xpath("//a[@class='my-link' and text() = 'Autocomplete']"));

        //scroll to the element & apply border
        js.executeScript(
                """
                        arguments[0].scrollIntoView(true);
                        arguments[0].style.border='2px solid red'
                      """
                , notifMsg);




    }
}
