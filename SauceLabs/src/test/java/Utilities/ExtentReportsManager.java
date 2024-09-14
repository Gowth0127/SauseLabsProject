package Utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportsManager {
	 private static ExtentReports extent;

	    public static ExtentReports getReporter() {
	        if (extent == null) {
	            // Set the path for the report file
	        	 ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReports/extentReport.html");

	             // Optional: Configure SparkReporter
	             sparkReporter.config().setDocumentTitle("Extent Report");
	             sparkReporter.config().setReportName("Test Report");

	             // Initialize ExtentReports
	             extent = new ExtentReports();
	             
	             // Attach the SparkReporter to ExtentReports
	             extent.attachReporter(sparkReporter);
	    }
	
	    return extent;
}
}