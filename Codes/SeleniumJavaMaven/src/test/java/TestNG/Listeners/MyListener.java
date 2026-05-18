package TestNG.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("####Test Started#### : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("####Test Successful#### : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("####Test Failed#### : " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("####Test Skipped#### : " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("####Test Timeout#### : " + result.getName());
    }

    //before starting of test class
    @Override
    public void onStart(ITestContext context) {
        System.out.println("####Started#### : " + context.getName());
    }

    //after executing test class
    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
