package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.expandtesting.com/login");
        driver.manage().window().maximize();

        WebElement labelForUsername = driver.findElement(By.xpath("//input[@id='username']/preceding-sibling::label[@for='username']"));

        System.out.println(labelForUsername.getText());
    }
}
