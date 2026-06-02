package com.cts.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //tags = "@smoke and not @positive",
        features = {"src/test/resources/features"},
        glue = {"com.cts.cucumber.stepdefs"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html",
                "json:target/cucumber-reports/report.json",
        }
)
public class TestRun extends AbstractTestNGCucumberTests {
}
