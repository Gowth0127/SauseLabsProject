package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPF {
	
	WebDriver driver;
	
	public loginPF(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (id="user-name") 	WebElement uname;
	@FindBy (id="password")		WebElement pswd;
	@FindBy (id = "login-button") WebElement btnLogin;
	@FindBy (xpath = "//div[@class='app_logo']") WebElement logo;
	
	
	public void enteruname (String uname1)
	{
		uname.sendKeys(uname1);
	}
	
	public void enterpaswd(String pwd)
	{
		pswd.sendKeys(pwd);
	}
	
	public void clickLogon() {
		btnLogin.click();
	}
	
	public void verifyHomePage()
	{
		logo.isDisplayed();
	}
	

}
