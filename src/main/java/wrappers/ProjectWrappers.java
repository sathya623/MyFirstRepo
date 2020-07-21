package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class ProjectWrappers extends GenericWrappers{

	
	public String browser;
	
	public String app;
	
	@BeforeSuite
	public void beforeSuite(){
		startReport();
	}

	@BeforeTest
	public void beforeTest(){
		loadObjects();
	}




	@BeforeMethod
	public void launchIrctc(){
		startTest(testCaseName, testCaseDescription);
		
		switch (app) {
		case "frro":
			invokeApp(browser, "https://indianfrro.gov.in/frro/FormC/menuuserreg.jsp");

			break;
		case "flipkart":
			invokeApp(browser, "https://www.flipkart.com/");
		default:
			invokeApp(browser, "https://www.irctc.co.in/nget/train-search");
			break;
		}
		
	}

	@AfterMethod
	public void closeBrowser(){
		closeAllBrowsers();
	}


	@AfterClass
	public void afterClass(){
		endTest();
	}

	@AfterTest
	public void afterTest(){
		unloadObjects();
	}

	@AfterSuite
	public void afterSuite(){
		endReport();
	}

}
