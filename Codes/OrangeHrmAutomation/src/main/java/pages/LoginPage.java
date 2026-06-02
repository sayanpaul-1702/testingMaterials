package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    //constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //locators

    @FindBy(name = "username")
    WebElement usernameElmt;

    @FindBy(name = "password")
    WebElement passwordElmt;

    @FindBy(className = "orangehrm-login-button")
    WebElement loginBtn;

    @FindBy(xpath = "//p[normalize-space()='Invalid credentials']")
    WebElement errorElmt;


    //action methods
    public LoginPage setInputUsername(String username){
        waitForVisibility(usernameElmt);
        usernameElmt.sendKeys(username);
        return this;
    }

    public LoginPage setInputPassword(String password){
        waitForVisibility(passwordElmt);
        passwordElmt.sendKeys(password);
        return this;
    }

    public LoginPage clickLogin(){
        waitForClickability(loginBtn);
        loginBtn.click();
        return this;
    }

    public String getErrorMessage(){
        waitForVisibility(errorElmt);
        return errorElmt.getText();
    }

    public boolean isErrorVisible(){
        waitForVisibility(errorElmt);
        return errorElmt.isDisplayed();
    }
}
