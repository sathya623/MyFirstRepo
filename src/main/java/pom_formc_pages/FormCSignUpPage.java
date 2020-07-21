package pom_formc_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import wrappers.GenericWrappers;

public class FormCSignUpPage extends GenericWrappers{

	public FormCSignUpPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public FormCSignUpPage enterUserID(String UserID){

		enterByXpath(prop.getProperty("FormCSignUpPage.UserId.XPath"), UserID);

		return this;
	}

	public FormCSignUpPage enterPassword(String Password){

		enterByXpath(prop.getProperty("FormCSignUpPage.Password.XPath"), Password);

		return this;
	}

	public FormCSignUpPage enterConfirmPassword(String ConfirmPassword){

		enterByXpath(prop.getProperty("FormCSignUpPage.ConfirmPassword.XPath"), ConfirmPassword);

		return this;

	}

	public FormCSignUpPage selectSecurityQuestion(String value){

		selectValueByXpath(prop.getProperty("FormCSignUpPage.SecurityQuestion.XPath"), value);

		return this;
	}

	public FormCSignUpPage enterSecurityAnswer(String SecurityAnswer){

		enterByXpath(prop.getProperty("FormCSignUpPage.SecurityAnswer.XPath"), SecurityAnswer);

		return this;
	}

	public FormCSignUpPage enterName(String Name){

		enterByXpath(prop.getProperty("FormCSignUpPage.Name.XPath"), Name);

		return this;
	}

	public FormCSignUpPage selectGender(String Gendervalue){

		selectValueByXpath(prop.getProperty("FormCSignUpPage.Gender.XPath"), Gendervalue);

		return this;
	}

	public FormCSignUpPage enterDate(String Date){

		enterByXpath(prop.getProperty("FormCSignUpPage.Date.XPath"), Date);

		return this;
	}

	public FormCSignUpPage enterDesignation(String Designation){

		enterByXpath(prop.getProperty("FormCSignUpPage.Designation.XPath"), Designation);

		return this;
	}

	public FormCSignUpPage enterEmail(String Email){

		enterByXpath(prop.getProperty("FormCSignUpPage.Email.XPath"), Email);

		return this;
	}

	public FormCSignUpPage enterMobile(String Mobile){

		enterByXpath(prop.getProperty("FormCSignUpPage.Mobile.XPath"), Mobile);

		return this;
	}

	public FormCSignUpPage enterPhone(String Phone){

		enterByXpath(prop.getProperty("FormCSignUpPage.Phone.XPath"), Phone);

		return this;
	}

	public FormCSignUpPage selectNationality(String Nationtext){

		SelectVissibletextByxpath(prop.getProperty("FormCSignUpPage.Nationality.XPath"), Nationtext);

		return this;
	}

	public FormCSignUpPage enterHotelName(String HotelName){

		enterByXpath(prop.getProperty("FormCSignUpPage.HotelName.XPath"), HotelName);

		return this;
	}

	public FormCSignUpPage enterCapacity(String Capacity){

		enterByXpath(prop.getProperty("FormCSignUpPage.Capacity.XPath"), Capacity);

		return this;
	}

	public FormCSignUpPage enterHotelAddress(String Address){

		enterByXpath(prop.getProperty("FormCSignUpPage.Address.XPath"), Address);

		return this;
	}

	public FormCSignUpPage selectState(String StateValue){

		selectValueByXpath(prop.getProperty("FormCSignUpPage.State.XPath"), StateValue);

		return this;
	}

	public FormCSignUpPage selectCity(String CityValue){

		selectValueByXpath(prop.getProperty("FormCSignUpPage.City.XPath"), CityValue);

		return this;
	}

	public FormCSignUpPage selectAccomodationType(String AccoIndex){

		int AccomodationIndex = Integer.parseInt(AccoIndex);

		selectIndexByXpath(prop.getProperty("FormCSignUpPage.AccomodationType.XPath"), AccomodationIndex);

		return this;
	}

	public FormCSignUpPage selectRating(String rating){

		//waitTillSelectable("//div[@id='accom_grade_id']//select");
		
		SelectVissibletextByxpath(prop.getProperty("FormCSignUpPage.Rating.XPath"), rating);

		return this;
	}

	public FormCSignUpPage enterHotelEmail(String HotelEmail){

		enterByXpath(prop.getProperty("FormCSignUpPage.HotelEmail.XPath"), HotelEmail);

		return this;
	}

	public FormCSignUpPage enterHotelMobile(String HotelMobile){

		enterByXpath(prop.getProperty("FormCSignUpPage.HotelMobile.XPath"), HotelMobile);

		return this;
	}

	public FormCSignUpPage enterHotelPhone(String HotelPhone){

		enterByXpath(prop.getProperty("FormCSignUpPage.HotelPhone.XPath"), HotelPhone);

		return this;
	}

	public FormCSignUpPage enterOwnerName(String OwnerName){

		enterByXpath(prop.getProperty("FormCSignUpPage.OwnerName.XPath"), OwnerName);

		return this;
	}

	public FormCSignUpPage enterOwnerAddress(String OwnerAddress){

		enterByXpath(prop.getProperty("FormCSignUpPage.OwnerAddress.XPath"), OwnerAddress);

		return this;
	}

	public FormCSignUpPage waitaWhile(){

		waitProperty(5000);

		return this;
	}

	public FormCSignUpPage selectOwnerState(String OwnerStatevalue){

		selectValueByXpath(prop.getProperty("FormCSignUpPage.OwnerState.XPath"), OwnerStatevalue);

		return this;
	}

	public FormCSignUpPage selectOwnerCity(String OwnerCityvalue){

		selectValueByXpath(prop.getProperty("FormCSignUpPage.OwnerCity.XPath"), OwnerCityvalue );

		return this;
	}

	public FormCSignUpPage enterOwnerEmail(String OwnerEmail){

		enterByXpath(prop.getProperty("FormCSignUpPage.OwnerEmail.XPath"), OwnerEmail);

		return this;
	}

	public FormCSignUpPage enterOwnerPhone(String OwnerPhone){

		enterByXpath(prop.getProperty("FormCSignUpPage.OwnerPhone.XPath"), OwnerPhone);

		return this;

	}

	public FormCSignUpPage enterOwnerMobile(String OwnerMobile){

		enterByXpath(prop.getProperty("FormCSignUpPage.OwnerMobile.XPath"), OwnerMobile);

		return this;
	}

	public FormCSignUpPage clickAdd(){

		clickByXpath(prop.getProperty("FormCSignUpPage.Add.XPath"));

		return this;
	}
}
