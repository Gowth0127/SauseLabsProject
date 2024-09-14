package Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotUtil {
	
	public static String takesScreenshot(WebDriver driver,String filename ) throws IOException
	{
		String filepath = "C:\\Users\\Gowtham\\Desktop\\NewProject\\SauceLabs\\AutomationReports\\";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile =  ts.getScreenshotAs(OutputType.FILE);
		String destFile = filepath + filename + ".png";
		FileHandler.copy(srcFile, new File(destFile));
		return destFile;
		
		
		
	}

}
