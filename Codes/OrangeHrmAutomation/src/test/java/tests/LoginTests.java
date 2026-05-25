package tests;

import base.BaseTests;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTests {

    public static LoginPage page;

    @BeforeClass
    public void pageSetUp(){
        page = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void loginWithInvalidCredentials(){
        page.setInputUsername("abcd981y27938711")
                .setInputPassword("12341279631623")
                .clickLogin();

        Assert.assertTrue(page.isErrorVisible());
    }

    @Test(priority = 2)
    public void loginWithValidCredentials(){
        page.setInputUsername("Admin")
                .setInputPassword("admin123")
                .clickLogin();
        Assert.assertFalse(page.isErrorVisible());
    }
}
