package com.adverity.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        plugin = {"pretty",
                "json:target/cucumber/report.json",
                "html:target/cucumber/report.html",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        glue = {"com.adverity"}
)
public class Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
