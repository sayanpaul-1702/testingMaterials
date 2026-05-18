package TestNG.Grouping;

import org.testng.annotations.Test;

public class SignUpTests {

    @Test(groups = {"regression"})
    void signUpByEmail(){
        System.out.println("Sign up by email....");
    }

    @Test(groups = {"regression"})
    void signUpByFacebook(){
        System.out.println("Sign up by facebook....");
    }

    @Test(groups = {"regression"})
    void signUpByTwitter(){
        System.out.println("Sign up by twitter....");
    }
}
