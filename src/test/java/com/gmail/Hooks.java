package com.gmail;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import utils.ExtentManager;
public class Hooks {
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> feature = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> scenario = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest extentTest = extent.createTest(scenario.getName());
        this.scenario.set(extentTest);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            this.scenario.get().log(Status.FAIL,"Scenario Failed");
        }
        else {
            this.scenario.get().log(Status.PASS,"Scenario Passed");
        }
        extent.flush();
    }

}
