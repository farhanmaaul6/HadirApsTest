package com.juaracoding.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/juaracoding/stepdefinitions",
        tags = "@auth and @negative",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/positive.html",
                "json:target/cucumber-reports/positive.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)

public class NegativeTestRunner extends AbstractTestNGCucumberTests {
}
