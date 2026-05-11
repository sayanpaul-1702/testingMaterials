import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesTest {
    public static void main(String[] args) {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setAcceptInsecureCerts(true);

        //options
        ChromeOptions options  = new ChromeOptions();
        options.merge(caps);    //merge capabilities to options
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://google.com");



    }
}
