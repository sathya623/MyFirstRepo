package utils;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SampleReport {
	
	@Test
	public void reporting(){
		
		ExtentReports report =new ExtentReports("./reports/result.html",false);
		
		ExtentTest test=report.startTest("TC001", "To Verify IRCTC Signup");
		
		test.assignAuthor("Sathya");
		
		test.assignCategory("Regression");
		
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");
		test.log(LogStatus.PASS, "Application launched successfully");

		report.endTest(test);
		
		report.flush();
		
	}
	
	
}
