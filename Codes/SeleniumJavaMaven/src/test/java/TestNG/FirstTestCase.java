package TestNG;

/*
* TEST CASE
* 1) Open App
* 2) Login
* 3) Logout
*/

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestCase {

    @BeforeTest
    void bt(){
        System.out.println("FirstTestCase");
    }

    @AfterTest
    void at(){
        System.out.println("FirstTestCase");
    }

    @Test(priority = 1)
    void openApp(){
        System.out.println("Opening App....");
    }
    @Test(priority = 2)
    void test(){
        System.out.println("testing....");
    }
    @Test(priority = 3)
    void test2(){
        System.out.println("testing again....");
    }

}
