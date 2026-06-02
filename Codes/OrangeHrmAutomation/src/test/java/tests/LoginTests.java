package tests;

import base.BaseTests;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTests {

    public static LoginPage loginPage;
    public static HomePage homePage;

    @BeforeClass
    public void pageSetUp(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void loginWithInvalidCredentials(){
        loginPage.setInputUsername("abcd981y27938711")
                .setInputPassword("12341279631623")
                .clickLogin();
        Assert.assertTrue(loginPage.isErrorVisible());
    }

    @Test(priority = 2)
    public void loginWithValidCredentials(){
        loginPage.setInputUsername("Admin")
                .setInputPassword("admin123")
                .clickLogin();
        Assert.assertEquals("Dashboard", homePage.getPageTitle());
    }
}
