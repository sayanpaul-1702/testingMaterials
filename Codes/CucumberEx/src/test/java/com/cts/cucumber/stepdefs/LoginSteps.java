package com.cts.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("the browser is opened")
    public void the_browser_is_opened() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Assert.assertFalse(driver.getWindowHandles().isEmpty());
    }
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement loginTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']"))
        );
        Assert.assertEquals(loginTitle.getText(),"Login");
    }
    @When("the user enters valid credentials\\(username: {string}, password: {string})")
    public void the_user_enters_valid_credentials_username_password(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }
    @When("the user clicks on login button")
    public void the_user_clicks_on_login_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        boolean status = driver.getCurrentUrl().contains("/dashboard/index");
        Assert.assertTrue(status);
    }
    @Then("the user should see the title of the dashboard\\(title: {string})")
    public void the_user_should_see_the_title_of_the_dashboard_title(String title) {
        WebElement dashboardTitleElmt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"))
        );
        Assert.assertEquals(dashboardTitleElmt.getText(),title);
    }
}
