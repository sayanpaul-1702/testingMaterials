package POM.pageObjClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators

    By inputUsername = By.name("username");
    By inputPassword = By.name("password");
    By btnLogin = By.className("orangehrm-login-button");

    //action methods
    public void setInputUsername(String username){
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void setInputPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }

}
