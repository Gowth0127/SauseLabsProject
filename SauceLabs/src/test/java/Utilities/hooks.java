package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import Utilities.screenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class hooks {
	private static ExtentReports extent = ExtentReportsManager.getReporter();
    private static ExtentTest test;
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        test = extent.createTest("TestName"); // Optionally set the test name here
    }

    @After
    public void tearDown(io.cucumber.java.Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            try {
                // Capture screenshot and add to report
                String screenshotPath = screenshotUtil.takesScreenshot(driver, scenario.getName());
                test.addScreenCaptureFromPath(screenshotPath);
                test.log(Status.FAIL, "Scenario failed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            test.log(Status.PASS, "Scenario passed");
        }
        driver.quit();
        extent.flush();
        
    }
}
