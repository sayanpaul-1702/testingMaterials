package TestNG;

import org.testng.annotations.*;

/*
    1) Login
    2)Search
    3)Logout
    4)Login
    5) Adv. Search
    6) Logout
 */
public class AnnotationsDemo1 {


    @BeforeSuite
    void bs(){
        System.out.println("Before suite....");
    }

    @AfterSuite
    void as(){
        System.out.println("After suite....");
    }

    @BeforeTest
    void login(){
        System.out.println("Login....");
    }

    @AfterTest
    void logout(){
        System.out.println("Logout....");
    }

    @Test(priority = 4)
    void search(){
        System.out.println("Search....");
    }
    @Test(priority = 5)
    void advSearch(){
        System.out.println("Advanced Search....");
    }


}
