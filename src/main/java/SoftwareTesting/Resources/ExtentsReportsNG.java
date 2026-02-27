package SoftwareTesting.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReportsNG {
	
	
	public static ExtentReports  getReporterObject() {
		
		
		String path = System.getProperty("User.div")+"//report//index.html";
		
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Test Results");
		report.config().setReportName("Here The Extent Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Bob");
		
		return extent;
		
		
	}

}
