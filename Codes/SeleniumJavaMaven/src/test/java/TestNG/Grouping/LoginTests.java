package TestNG.Grouping;

import org.testng.annotations.Test;

public class LoginTests {

    @Test(groups = {"sanity"})
    void loginByEmail(){
        System.out.println("login by email....");
    }

    @Test(groups = {"sanity"})
    void loginByFacebook(){
        System.out.println("login by facebook....");
    }

    @Test(groups = {"sanity"})
    void loginByTwitter(){
        System.out.println("login by twitter....");
    }
}
