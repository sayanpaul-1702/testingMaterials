package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchElmt;

    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li[1]/child::a")
    WebElement pimElmt;

    @FindBy(xpath = "//*[@class='oxd-topbar-header-breadcrumb']/h6")
    WebElement pageTitle;

    public HomePage setSearchElmt(String searchParam){
        waitForVisibility(searchElmt);
        searchElmt.sendKeys(searchParam);
        return this;
    }

    public HomePage clickPim(){
        waitForClickability(pimElmt);
        pimElmt.click();
        return this;
    }

    public String getSearchValue(){
        return searchElmt.getAttribute("value");
    }

    public String getPageTitle(){
        waitForVisibility(pageTitle);
        return pageTitle.getText();
    }
}
