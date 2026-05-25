package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    WebDriver driver;

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

    @FindBy(xpath = "//div[@role='alert']")
    WebElement invalidCredentialError;

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
        return invalidCredentialError.getText();
    }

    public boolean isErrorVisible(){
        return invalidCredentialError.isDisplayed();
    }
}
