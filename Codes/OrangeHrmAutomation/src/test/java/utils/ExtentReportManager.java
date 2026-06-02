package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentReport;
    public ExtentTest testLogger;

    @Override
    public void onStart(ITestContext context) {
        String fileName = "myExtentReport_"+ DateTimeFormatter.ofPattern("YYYYMMdd_HHmm").format(LocalDateTime.now()) + ".html";
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/reports/"+ fileName);


        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReport = new ExtentReports();
        extentReport.attachReporter(sparkReporter);

        extentReport.setSystemInfo("Computer Name", ConfigReader.get("machine.name"));
        extentReport.setSystemInfo("Environment",ConfigReader.get("environment"));
        extentReport.setSystemInfo("Tester Name",ConfigReader.get("tester.name"));
        extentReport.setSystemInfo("OS",ConfigReader.get("machine.os"));
        extentReport.setSystemInfo("Browser Name",ConfigReader.get("browser.name"));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testLogger = extentReport.createTest(result.getName()); //create a new entry in the report
        testLogger.log(Status.PASS,"Test case PASSED is: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testLogger = extentReport.createTest(result.getName()); //create a new entry in the report
        testLogger.log(Status.FAIL,"Test case FAILED is: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testLogger = extentReport.createTest(result.getName()); //create a new entry in the report
        testLogger.log(Status.SKIP,"Test case SKIPPED is: " + result.getName());
    }


    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();   //writes the test information in the report
    }
}
