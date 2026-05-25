package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTests extends BaseTests {

    public static HomePage page;

    @BeforeClass
    public void pageSetup(){
        page = new HomePage(driver);
    }

    @Test(priority = 3, dependsOnMethods = {"tests.LoginTests.loginWithValidCredentials"})
    public void sendDataToSearch(){
        page.setSearchElmt("PIM");
        Assert.assertEquals(page.getSearchValue(),"PIM");
    }

    @Test(priority = 4, dependsOnMethods = {"sendDataToSearch"})
    public void navigateToPim(){
        page.clickPim();
        Assert.assertEquals(page.getPageTitle(),"PIM");
    }
}
