import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SelectOptionTest {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();

        driver.get("https://webapps.tekstac.com/RentaCar/");

        driver.manage().window().maximize();

        WebElement option = driver.findElement(By.id("cartype"))
                                  .findElement(By.xpath("//option[@value='SUV']"));

        option.click();


    }
}
