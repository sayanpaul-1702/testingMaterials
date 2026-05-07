import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwitchingWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();

        List<String> urls = Arrays.asList("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login","https://www.google.com/","https://www.bing.com/");

        //open new tabs
        for(String url: urls){
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get(url);
        }

        //get handles
        List<String> handles = new ArrayList<>(driver.getWindowHandles());




        for(int i = 1; i< handles.size();i++){
            driver.switchTo().window(handles.get(i));
            Thread.sleep(2000);
            driver.close();
        }

        driver.quit();

    }
}
