package TestNG.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int failCount = 0;
    int limit = 5;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(failCount < limit){
            failCount++;
            return true;
        }
        return false;
    }
}
