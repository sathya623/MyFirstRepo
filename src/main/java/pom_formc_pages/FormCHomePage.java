package pom_formc_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class FormCHomePage extends GenericWrappers{
	
	public FormCHomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver= driver;
		this.test= test;
	}
	
	public FormCSignUpPage clickOnSignUp(){
		
		clickByXpath(prop.getProperty("FormCHomePage.SignUp.XPath"));
		
		return new FormCSignUpPage(driver, test);
	}

}
