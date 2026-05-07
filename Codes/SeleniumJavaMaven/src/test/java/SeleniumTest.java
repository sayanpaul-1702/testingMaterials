import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class SeleniumTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter type of shorts to play in youtube");
        String searchParam = sc.nextLine();
        System.out.println("Searching...");

        //1. Create a WebDriver
        //2. Open the browser
        WebDriver driver = new ChromeDriver();

        //3. Navigate to specific URL
        driver.navigate().to("https://www.youtube.com/");

        //maximize window
        driver.manage().window().maximize();

        //get page source
        String pageSource = driver.getPageSource();

        //click the settings link

        //1.Identify the element using ID
        By searchLocator = By.name("search_query");
        By submitLocator = By.className("ytSearchboxComponentSearchButton");


        //2.Pass locator to web driver to perform operations on it
        WebElement searchElement = driver.findElement(searchLocator);
        WebElement submitElement = driver.findElement(submitLocator);


        //3. Click operation
        searchElement.click();

        //4. send parameters
        searchElement.sendKeys(searchParam);

        //5. search
        submitElement.click();

        //6. Open video
//        List<WebElement> videoElement = driver.findElements(By.id("ytd-thumbnail"));
//        System.out.println(videoElement);
//        System.out.println("Search completed !!");

    }
}
