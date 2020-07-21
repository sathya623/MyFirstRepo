package testcases;



import org.testng.annotations.BeforeClass;


import org.testng.annotations.Test;

import pom_formc_pages.FormCHomePage;
import wrappers.ProjectWrappers;

public class TC010 extends ProjectWrappers{
	
	@BeforeClass
	public void beforeClass(){
		testCaseName="TC010";
		testCaseDescription="To fill FormC";
		category="Regression";
		author="Sathya";
		app="frro";
		browser="chrome";
		
	}
	
	@Test
	public void FillFormC(){
		
		new FormCHomePage(driver, test)
		.clickOnSignUp()
		.enterUserID("VigneshV06")
		.enterPassword("asdfg@hjkl")
		.enterConfirmPassword("asdfg@hjkl")
		.selectSecurityQuestion("5")
		.enterSecurityAnswer("Wipro")
		.enterName("Vinodh")
		.selectGender("M")
		.enterDate("02/10/1989")
		.enterDesignation("Business")
		.enterEmail("Vinuv@gmail.com")
		.enterMobile("955003399")
		.enterPhone("0442536942")
		.selectNationality("INDIA")
		.enterHotelName("IBIS")
		.enterCapacity("5")
		.enterHotelAddress("testing")
		.selectState("15")
		.selectCity("5C")
		.selectAccomodationType("5")
		.selectRating("Five Star")
		.enterHotelEmail("Ibis@redifmail.com")
		.enterHotelMobile("1558693248")
		.enterHotelPhone("0827625642")
		.enterOwnerName("Sezhiyan")
		.enterOwnerAddress("Madambakkam")
		.selectOwnerState("28")
		.selectOwnerCity("4C")
		.enterOwnerEmail("Sezhiyan@gmail.com")
		.enterOwnerPhone("044926682666")
		.enterOwnerMobile("9003293081")
		.clickAdd()
		.enterOwnerName("Sezhiyan")
		.enterOwnerAddress("Madambakkam")
		.waitaWhile()
		.selectOwnerState("28")
		.waitaWhile()
		.selectOwnerCity("4C")
		.enterOwnerEmail("Sezhiyan@gmail.com")
		.enterOwnerPhone("044926682666")
		.enterOwnerMobile("9003293081")
		.clickAdd()
		.enterOwnerName("Sezhiyan")
		.enterOwnerAddress("Madambakkam")
		.waitaWhile()
		.selectOwnerState("28")
		.waitaWhile()
		.selectOwnerCity("4C")
		.enterOwnerEmail("Sezhiyan@gmail.com")
		.enterOwnerPhone("044926682666")
		.enterOwnerMobile("9003293081");
		
	}

}
