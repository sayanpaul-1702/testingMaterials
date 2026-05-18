package TestNG;

import org.testng.annotations.*;

public class AnnotationHierarchy {

    @BeforeSuite
    void bs(){
        System.out.println("Before suite....");
    }

    @AfterSuite
    void as(){
        System.out.println("After suite....");
    }

    @BeforeTest
    void bt(){
        System.out.println("Before test....");
    }

    @AfterTest
    void at(){
        System.out.println("After test....");
    }

    @BeforeClass
    void bc(){
        System.out.println("Before class....");
    }

    @AfterClass
    void ac(){
        System.out.println("After class....");
    }

    @BeforeMethod
    void bm(){
        System.out.println("Before Method....");
    }

    @AfterMethod
    void am(){
        System.out.println("After Method....");
    }

    @Test(priority = 1)
    void test1(){
        System.out.println("This is test 1");
    }

    @Test(priority = 2)
    void test2(){
        System.out.println("This is test 2");
    }

}
