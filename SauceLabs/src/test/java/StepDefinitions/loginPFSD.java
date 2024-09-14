package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.screenshotUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.loginPF;


public class loginPFSD {
	
	WebDriver driver;
	loginPF l1 ;
	
	@Given("user on login page")
	public void user_on_login_page() throws Exception {
			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		l1 = new loginPF(driver);
		screenshotUtil.takesScreenshot(driver, "loginpage");
		
	}

	@When("enter {string} and {string}")
	public void enter_and(String username, String password) throws Exception {
	    l1.enteruname(username);
	    screenshotUtil.takesScreenshot(driver, "username");
	    l1.enterpaswd(password);
	    screenshotUtil.takesScreenshot(driver, "password");
		
	}

	@And("clicked on login button")
	public void clicked_on_login_button() throws Exception {
	   l1.clickLogon();
	   screenshotUtil.takesScreenshot(driver, "loginbutton clicked");
	}

	@Then("user navigated to home page")
	public void user_navigated_to_home_page() throws Exception {
	    l1.verifyHomePage();
	    screenshotUtil.takesScreenshot(driver, "Homepage");
		
	}

	@And("close browser")
	public void close_browser() {
	   driver.quit();
		
		
	}


}
