package wrappers;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Reporting;

public class GenericWrappers extends Reporting implements Wrappers{

	public RemoteWebDriver driver;
	public static Properties prop;
	
	public void loadObjects(){
		
		try {
			 prop= new Properties();
			
			prop.load(new FileInputStream("./src/test/java/object.properties"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void unloadObjects(){
		prop=null;
	}
	
	
	
	
	
	
	
	
	
	public void invokeApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}else if (browser.equalsIgnoreCase("firefox")){

				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			}else if (browser.equalsIgnoreCase("InternetExplorer")){
				System.setProperty("webdriver.IE.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}
			driver.manage().window().maximize();
			driver.get(url);

			//	System.out.println("The browser " + browser +" is launched successfully with " + url );

			reportStep("The browser " + browser +" is launched successfully with " + url , "Pass");

		} catch (SessionNotCreatedException e) {

			//	System.err.println("The browser "+ browser + " is not launched due to session not created error");

			reportStep("The browser "+ browser + " is not launched due to session not created error", "Fail");

		}catch (WebDriverException e) {
			System.err.println("The browser "+ browser + " is not launched due to unknown error");
			reportStep("The browser "+ browser + " is not launched due to unknown error", "Fail");
		}

	}
	public void enterById(String idValue, String data) {

		try {
			driver.findElementById(idValue).sendKeys(data);
			//System.out.println("The element with id " + idValue + " is entered with data " + data);

			reportStep("The element with id " + idValue + " is entered with data " + data, "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+idValue + " is not found in DOM");
			reportStep("The element with id "+idValue + " is not found in DOM", "Fail");

		}catch(ElementNotVisibleException e){
			//System.err.println("The element with id " + idValue + " is not visible in the application");
			reportStep("The element with id " + idValue + " is not visible in the application", "Fail");

		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with id " + idValue + " is not intractable");
			reportStep("The element with id " + idValue + " is not intractable", "Fail");

		}catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+idValue + " is not stable");
			reportStep("The element with id "+idValue + " is not stable", "Fail");

		}catch (WebDriverException e) {
			//System.err.println("The element with id "+ idValue + " is not entered due to unknown error");
			reportStep("The element with id "+ idValue + " is not entered due to unknown error", "Fail");

		}


	}

	public void enterByName(String nameValue, String data) {

		try {
			driver.findElementByName(nameValue).sendKeys(data);
			//System.out.println("The element with name "+nameValue+" is entered with data"+data);
			reportStep("The element with name "+nameValue+" is entered with data"+data, "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with the name "+nameValue+ " is not found in DOM");
			reportStep("The element with the name "+nameValue+ " is not found in DOM", "Fail");


		}catch (ElementNotVisibleException e) {
			//System.err.println("The element with the name "+nameValue+" is not visible in the application");
			reportStep("The element with the name "+nameValue+" is not visible in the application", "Fail");

		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with the name "+nameValue+ " is not intractable");
			reportStep("The element with the name "+nameValue+ " is not intractable", "Fail");


		}catch (StaleElementReferenceException e) {
			//System.err.println("The element with the name "+nameValue+ " is not stable");
			reportStep("The element with the name "+nameValue+ " is not stable", "Fail");

		}catch (WebDriverException e) {
			//System.err.println("The element with the name "+nameValue+" is not entered due to unknown error");
			reportStep("The element with the name "+nameValue+" is not entered due to unknown error", "Fail");

		}


	}

	public void enterByXpath(String xpathValue, String data) {

		try {
			driver.findElementByXPath(xpathValue).sendKeys(data, Keys.ARROW_DOWN, Keys.TAB);
			//System.out.println("The element with the xpath "+xpath+ " is entered sucessfully data "+value+ " and arrow down and tab is performed ");
			reportStep("The element with the xpath "+xpathValue+ " is entered sucessfully data " +data , "Pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with the xpath "+ xpath+ " is not found in the DOM");
			reportStep("The element with the xpath "+ xpathValue+ " is not found in the DOM", "Fail");

		}catch (ElementNotVisibleException e) {
			//System.err.println("The element with the xpath "+xpath+" is not vissible in the application");
			reportStep("The element with the xpath "+xpathValue+" is not vissible in the application", "Fail");

		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with the xpath "+xpath+ " is not interactable");
			reportStep("The element with the xpath "+xpathValue+ " is not interactable", "Fail");
		}catch (StaleElementReferenceException e) {
			//System.err.println("The element with the path "+xpath+ " is not stable");
			reportStep("The element with the path "+xpathValue+ " is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with the xpath "+xpath+" is not entered due to unkown error");
			reportStep("The element with the xpath "+xpathValue+" is not entered due to unkown error", "Fail");
		}
	}

	public void verifyTitle(String title) {
		try {
			String actual = driver.getTitle();
			if (actual.equals(title)){
				//System.out.println(actual+ " is matching with "+ title);
				reportStep(actual+ " is matching with "+ title, "Pass");

			}else {
				//System.err.println(actual+" is not matching to "+ title);
				reportStep(actual+" is not matching to "+ title, "Fail");
			}

		} catch (WebDriverException e) {
			//System.err.println("The element with title "+ title + " did not appear due to unknown error");
			reportStep("The element with title "+ title + " did not appear due to unknown error", "Fail");

		}

	}

	public void verifyTextById(String id, String text) {

		String actual;
		try {
			actual = driver.findElementById(id).getText();

			if (actual.equals(text)){
				//System.out.println("The text by id "+id + " is matching with "+text);
				reportStep("The text by id "+id + " is matching with "+text, "Pass");

			}
			else if (!actual.equals(text)){
				//System.err.println("The text by id "+id+" is not matching with "+text);
				reportStep("The text by id "+id+" is not matching with "+text, "Fail");
			}

		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+id +" is not found in the DOM ");
			reportStep("The element with id "+id +" is not found in the DOM ", "Fail");

		}catch (ElementNotVisibleException e) {
			//System.err.println("The elemnet with id "+id+" is not vissible in the application");
			reportStep("The element with id "+id+" is not visible in the application", "Fail");

		}catch(ElementNotInteractableException e){
			//System.err.println("The element with id "+id +" is not intractable");
			reportStep("The element with id "+id +" is not intractable", "Fail");


		}catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+id+" is not stable");
			reportStep("The element with id "+id+" is not stable", "Fail");

		}catch (WebDriverException e) {
			//System.err.println("The element with id "+id+" did not appear due to unknown error");
			reportStep("The element with id "+id+" did not appear due to unknown error", "Fail");
		}





	}

	public void verifyTextByXpath(String xpath, String text) {

		try {
			String actual = driver.findElementByXPath(xpath).getText();
			if(actual.equals(text)){
				//System.out.println("The text "+actual+" is matching with the text  "+text);
				reportStep("The text "+actual+" is matching with the text  "+text, "Pass");

			}else if (!actual.equals(text)){
				//System.err.println("The text "+actual+" is not matching with text "+text);
				reportStep("The text "+actual+" is not matching with text "+text, "Fail");

			}} catch (NoSuchElementException e) {
				//System.err.println("The element with xpath "+xpath+ " is not found in the DOM");
				reportStep("The element with xpath "+xpath+ " is not found in the DOM", "Fail");

			}catch(ElementNotVisibleException e){
				//System.err.println("The element with xpath "+xpath+" is not visible in the application");
				reportStep("The element with xpath "+xpath+" is not visible in the application", "Fail");			

			}catch(ElementNotInteractableException e){
				//System.err.println("The element with xpath "+xpath+" is not intractable");
				reportStep("The element with xpath "+xpath+" is not intractable", "Fail");

			}catch(StaleElementReferenceException e){
				//System.err.println("The element with xpath "+xpath+" is not stable");
				reportStep("The element with xpath "+xpath+" is not stable", "Fail");

			}catch(WebDriverException e){
				//System.err.println("The element with xpath "+xpath+" did not appear due to unknown error");
				reportStep("The element with xpath "+xpath+" did not appear due to unknown error", "Fail");
			}

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String actual = driver.findElementByXPath(xpath).getText();

			if(actual.contains(text)){
				//System.out.println("The text "+actual+" matches with the text "+text);
				reportStep("The text "+actual+" matches with the text "+text, "Pass");

			}else if (!actual.contains(text)){
				//System.err.println("The text "+actual+" did not match with the text "+text);
				reportStep("The text "+actual+" did not match with the text "+text, "Fail");

			}
		} catch (NoSuchElementException e) {
			//System.err.println("The element with xpath "+xpath+" is not found in the DOM");
			reportStep("The element with xpath "+xpath+" is not found in the DOM", "Fail");
		}catch (ElementNotVisibleException e) {
			//System.err.println("The element with xpath "+xpath+ " is not visible in the application");
			reportStep("The element with xpath "+xpath+ " is not visible in the application", "Fail");



		}catch(ElementNotInteractableException e){
			//System.err.println("The element with xpath "+xpath+" is not intractable");
			reportStep("The element with xpath "+xpath+" is not intractable", "Fail");
		}catch (StaleElementReferenceException e) {
			//System.err.println("The element with xpath "+xpath+" is not stable");
			reportStep("The element with xpath "+xpath+" is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with xpath "+xpath+ " did not appear due to unknown error");
			reportStep("The element with xpath "+xpath+ " did not appear due to unknown error", "Fail");
		}

	}

	public void clickById(String id) {

		try {
			driver.findElementById(id).click();
			//System.out.println("The element with id "+id+" is clicked successfully");
			reportStep("The element with id "+id+" is clicked successfully", "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+id+" in not found in the DOM");
			reportStep("The element with id "+id+" in not found in the DOM", "Fail");

		}catch (ElementNotVisibleException e) {
			//System.err.println("The element with id "+id+" in not visible in the application");
			reportStep("The element with id "+id+" in not visible in the application", "Fail");
		}catch (ElementClickInterceptedException e) {
			//System.err.println("The element with id "+id+ " is not clickable");
			reportStep("The element with id "+id+ " is not clickable", "Fail");

		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+id+" is not intractable");
			reportStep("The element with id "+id+" is not intractable", "Fail");
		}catch (StaleElementReferenceException e) {
			//System.err.println("The element with id "+id+" is not stable");
			reportStep("The element with id "+id+" is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with id "+id+ " did not appear due to unknown error");
			reportStep("The element with id "+id+ " did not appear due to unknown error", "Fail");
		}

	}

	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
			//System.out.println("The element with classname "+classVal+" was clicked successfully");
			reportStep("The element with classname "+classVal+" was clicked successfully", "Pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with classname "+classVal+" is not found in the DOM");
			reportStep("The element with classname "+classVal+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with classname "+classVal+" is not visible in the application");
			reportStep("The element with classname "+classVal+" is not visible in the application", "Fail");
		}catch (ElementClickInterceptedException e) {
			//System.err.println("The element with classname "+classVal+" is clickable");
			reportStep("The element with classname "+classVal+" is clickable", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with classname "+classVal+" is not intractable");
			reportStep("The element with classname "+classVal+" is not intractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with classname "+classVal+" is not stable");
			reportStep("The element with classname "+classVal+" is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with classname "+classVal+" is not found due unknown error");
			reportStep("The element with classname "+classVal+" is not found due unknown error", "Fail");
		}

	}

	public void clickByName(String name) {
		try {
			driver.findElementByName(name).click();
			//System.out.println("The element with name "+name+" was clicked successfully");
			reportStep("The element with name "+name+" was clicked successfully", "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with name "+name+" is not found in the DOM");
			reportStep("The element with name "+name+" is not found in the DOM", "Fail");

		}catch(ElementNotVisibleException e){
			//System.err.println("The element with name "+name+" is not vissible in the application");
			reportStep("The element with name "+name+" is not vissible in the application", "Fail");

		}catch (ElementClickInterceptedException e) {
			//System.err.println("The element with name "+name+" is not clickable");
			reportStep("The element with name "+name+" is not clickable", "Fail");

		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with name "+name+" is not intractable");
			reportStep("The element with name "+name+" is not intractable", "Fail");

		}catch (StaleElementReferenceException e){
			//System.err.println("The element with name "+name+" is not stable");
			reportStep("The element with name "+name+" is not stable", "Fail");

		}catch (WebDriverException e) {
			//System.err.println("The element with name "+name+" is not found due unkown error");
			reportStep("The element with name "+name+" is not found due unkown error", "Fail");
		}
	}

	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("The element with link "+name+" was clicked successfully");
			reportStep("The element with link "+name+" was clicked successfully", "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with link "+name+" is not found in the DOM");
			reportStep("The element with link "+name+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with link "+name+" is not visible in the application");
			reportStep("The element with link "+name+" is not visible in the application", "Fail");
		}catch (ElementClickInterceptedException e) {
			//System.err.println("The element with link "+name+" is not clickable");
			reportStep("The element with link "+name+" is not clickable", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with link "+name+" is not intractable");
			reportStep("The element with link "+name+" is not intractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with link "+name+" is not stable");
			reportStep("The element with link "+name+" is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with link "+name+" is not found due unkown error");
			reportStep("The element with link "+name+" is not found due unkown error", "Fail");
		}

	}

	public void clickByLinkNoSnap(String name) {
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("The element with link "+name+" was clicked successfully");
			reportStep("The element with link "+name+" was clicked successfully", "Pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with link "+name+" is not found in the DOM");
			reportStep("The element with link "+name+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with link "+name+" is not vissible in the application");
			reportStep("The element with link "+name+" is not vissible in the application", "Fail");
		}catch (ElementClickInterceptedException e) {
			//System.err.println("The element with link "+name+" is not clickable");
			reportStep("The element with link "+name+" is not clickable", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with link "+name+" is not interractable");
			reportStep("The element with link "+name+" is not interractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with link "+name+" is not stable");
			reportStep("The element with link "+name+" is not stable", "Fail");

		}catch (WebDriverException e) {
			//System.err.println("The element with link "+name+" is not found due unkown error");
			reportStep("The element with link "+name+" is not found due unkown error", "Fail");
		}

	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("The element with xpath "+xpathVal+" was clicked successfully");
			reportStep("The element with xpath "+xpathVal+" was clicked successfully", "Pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with xpath "+xpathVal+" is not found in the DOM");
			reportStep("The element with xpath "+xpathVal+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with xpath "+xpathVal+" is not vissible in the application");
			reportStep("The element with xpath "+xpathVal+" is not vissible in the application", "Fail");
		}catch (ElementClickInterceptedException e) {
			//System.err.println("The element with xpath "+xpathVal+" is not clickable");
			reportStep("The element with xpath "+xpathVal+" is not clickable", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with xpath "+xpathVal+" is not interractable");
			reportStep("The element with xpath "+xpathVal+" is not interractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with xpath "+xpathVal+" is not stable");
			reportStep("The element with xpath "+xpathVal+" is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with xpath "+xpathVal+" is not found due unkown error");
			reportStep("The element with xpath "+xpathVal+" is not found due unkown error", "Fail");
		}

	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("The element with xpath "+xpathVal+" was clicked successfully");
			reportStep("The element with xpath "+xpathVal+" was clicked successfully", "Pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with xpath "+xpathVal+" is not found in the DOM");
			reportStep("The element with xpath "+xpathVal+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with xpath "+xpathVal+" is not vissible in the application");
			reportStep("The element with xpath "+xpathVal+" is not vissible in the application", "Fail");
		}catch (ElementClickInterceptedException e) {
			//System.err.println("The element with xpath "+xpathVal+" is not clickable");
			reportStep("The element with xpath "+xpathVal+" is not clickable", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with xpath "+xpathVal+" is not interractable");
			reportStep("The element with xpath "+xpathVal+" is not interractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with xpath "+xpathVal+" is not stable");
			reportStep("The element with xpath "+xpathVal+" is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with xpath "+xpathVal+" is not found due unkown error");
			reportStep("The element with xpath "+xpathVal+" is not found due unkown error", "Fail");
		}

	}

	public String getTextById(String idVal) {
		String actualtext= null;

		try {
			actualtext=	driver.findElementById(idVal).getText();
			//System.out.println("The element with id "+idVal+" is found with text "+actualtext);
			reportStep("The element with id "+idVal+" is found with text "+actualtext, "Pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+idVal+" is not found in the DOM");
			reportStep("The element with id "+idVal+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with id "+idVal+" is not vissible in the application");
			reportStep("The element with id "+idVal+" is not vissible in the application", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+idVal+" is not interractable");
			reportStep("The element with id "+idVal+" is not interractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with id "+idVal+" is not stable");
			reportStep("The element with id "+idVal+" is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with id "+idVal+" is not found due unkown error");
			reportStep("The element with id "+idVal+" is not found due unkown error", "Fail");
		}

		return actualtext;
	}

	public String getTextByXpath(String xpathVal) {
		String actualtext=null;
		try {
			actualtext=driver.findElementByXPath(xpathVal).getText();
			//System.out.println("The element with xpath "+xpathVal+" is found with the text "+actualtext);
			reportStep("The element with xpath "+xpathVal+" is found with the text "+actualtext, "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with xpath "+xpathVal+" is not found in the DOM");
			reportStep("The element with xpath "+xpathVal+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with xpath "+xpathVal+" is not vissible in the application");
			reportStep("The element with xpath "+xpathVal+" is not vissible in the application", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with xpath "+xpathVal+" is not interractable");
			reportStep("The element with xpath "+xpathVal+" is not interractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with xpath "+xpathVal+" is not stable");
			reportStep("The element with xpath "+xpathVal+" is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with xpath "+xpathVal+" is not found due unkown error");
			reportStep("The element with xpath "+xpathVal+" is not found due unkown error", "Fail");
		}

		return actualtext;
	}

	public void selectVisibileTextById(String id, String value) {
		try {
			WebElement vistxt = driver.findElementById(id);
			Select visible = new Select(vistxt);
			visible.selectByVisibleText(value);
			//System.out.println("The value of the element "+value+" was selected successfully using the xpath"+id);
			reportStep("The value of the element "+value+" was selected successfully using the xpath"+id, "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+id+" is not found in the DOM");
			reportStep("The element with id "+id+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with id "+id+" is not vissible in the application");
			reportStep("The element with id "+id+" is not vissible in the application", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+id+" is not interractable");
			reportStep("The element with id "+id+" is not interractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with id "+id+" is not stable");
			reportStep("The element with id "+id+" is not stable", "Fail");
		}catch (ElementNotSelectableException e) {
			//System.err.println("The option in dropdown with  "+value+ " is not selectable");
			reportStep("The option in dropdown with  "+value+ " is not selectable", "Fail");
		}
		catch (WebDriverException e) {
			//System.err.println("The element with id "+id+" is not found due unkown error");
			reportStep("The element with id "+id+" is not found due unkown error", "Fail");
		}
	}

	public void selectIndexById(String id, int value) {
		try {
			WebElement Index = driver.findElementById(id);
			Select ind = new Select(Index);
			ind.selectByIndex(value);
			//System.out.println("The value of the element "+value+" was selected successfully using the xpath"+id);
			reportStep("The value of the element "+value+" was selected successfully using the xpath"+id, "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with id "+id+" is not found in the DOM");
			reportStep("The element with id "+id+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with id "+id+" is not vissible in the application");
			reportStep("The element with id "+id+" is not vissible in the application", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with id "+id+" is not interractable");
			reportStep("The element with id "+id+" is not interractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with id "+id+" is not stable");
			reportStep("The element with id "+id+" is not stable", "Fail");
		}catch (ElementNotSelectableException e) {
			//System.err.println("The option in dropdown with  "+value+ " is not selectable");
			reportStep("The option in dropdown with  "+value+ " is not selectable", "Fail");
		}
		catch (WebDriverException e) {
			//System.err.println("The element with id "+id+" is not found due unkown error");
			reportStep("The element with id "+id+" is not found due unkown error", "Fail");
		}
	}

	public void switchToParentWindow() {
		try {
			Set <String> allwin =driver.getWindowHandles();
			for(String eachwin:allwin){
				driver.switchTo().window(eachwin);
				break;
			}

			//System.out.println("Switched to the parent window successfully");
			reportStep("Switched to the parent window successfully", "Pass");
		} catch (NoSuchWindowException e) {
			//System.err.println("The window is not available to be switched");
			reportStep("The window is not available to be switched", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The control to the parent window is not switched due to unkown error");
			reportStep("The control to the parent window is not switched due to unkown error", "Fail");
		}
	}

	public void switchToLastWindow() {
		try {
			Set <String> allwin =driver.getWindowHandles();
			for(String eachwin:allwin){
				driver.switchTo().window(eachwin);

			}

			//System.out.println("Switched to the last window successfully");
			reportStep("Switched to the last window successfully", "Pass");
		} catch (NoSuchWindowException e) {
			//System.err.println("The window is not available to be switched");
			reportStep("The window is not available to be switched", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The control to the last window is not switched due to unkown error");
			reportStep("The control to the last window is not switched due to unkown error", "Fail");
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();

			//System.out.println("The alert opened was accepted successfully");
			reportStep("The alert opened was accepted successfully", "Pass");
		} catch (NoAlertPresentException e) {
			//System.err.println("There is no alert opened to be accepted");
			reportStep("There is no alert opened to be accepted", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The alert was not accepted due to unkown error");
			reportStep("The alert was not accepted due to unkown error", "Fail");
		}
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();

			//System.out.println("The alert opened was dismissed successfully");
			reportStep("The alert opened was dismissed successfully", "Pass");
		} catch (NoAlertPresentException e) {
			//System.err.println("There is no alert opened to be dismissed");
			reportStep("There is no alert opened to be dismissed", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The alert was not dismissed due to unkown error");
			reportStep("The alert was not dismissed due to unkown error", "Fail");
		}
	}

	public String getAlertText() {

		String text=null;

		try {
			text = driver.switchTo().alert().getText();

			//System.out.println("The alert message "+text+" is text inside the alert popup");
			reportStep("The alert message "+text+" is text inside the alert popup", "Pass");
		} catch (NoAlertPresentException e) {
			//System.err.println("There is no alert to get the text from");
			reportStep("There is no alert to get the text from", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The alert message was not found due to unkown error");
			reportStep("The alert message was not found due to unkown error", "Fail");
		}
		return text;
	}

	public long takeSnap() {
		// TODO Auto-generated method stub

		long number=0;// declration to be accesed on return statement hence declaring outside the try block
		try {


			number=	(long) (Math.floor(Math.random()*100000000)+100000);//to give unique name to the screenshot

			File tmp=driver.getScreenshotAs(OutputType.FILE); // saves the screenshot is some unkown path

			File dest = new File("./reports/screenshots/"+number+".png");//  create a path to save the screenshot

			FileUtils.copyFile(tmp, dest);// copy the screen sht from unkown to new path

		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}

	public void closeBrowser() {
		try {
			driver.close();
			//System.out.println("window closed successfully");
			reportStep("window closed successfully", "Pass");
		} catch (NoSuchWindowException e) {
			//System.err.println("The window is not available to be closed");
			reportStep("The window is not available to be closed", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The window is not closed due to unkown error");
			reportStep("The window is not closed due to unkown error", "Fail");
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			//System.out.println("All the windows closed successfully");
			reportStep("All the windows closed successfully", "Pass", false);
		} catch (NoSuchWindowException e) {
			//System.err.println("There are no windows available to be closed");
			reportStep("There are no windows available to be closed", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The windows are not closed due to unkown error");
			reportStep("The windows are not closed due to unkown error", "Fail");
		}
	}
	public void waitProperty(long time) {
		try {
			Thread.sleep(time);

		} catch (InterruptedException e) {
			//System.err.println("The sleep time got intrrupted while waiting");
			reportStep("The sleep time got intrrupted while waiting", "Fail");

		}

	}
	public void selectValueByXpath(String xpath, String value) {
		try {
			WebElement wb = driver.findElementByXPath(xpath);
			Select byxpath = new Select(wb);
			byxpath.selectByValue(value);
			//System.out.println("The value of the element "+value+" was selected successfully using the xpath"+xpath);
			reportStep("The value of the element "+value+" was selected successfully using the xpath"+xpath, "Pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with xpath "+xpath+" is not found in the DOM");
			reportStep("The element with xpath "+xpath+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with xpath "+xpath+" is not vissible in the application");
			reportStep("The element with xpath "+xpath+" is not vissible in the application", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with xpath "+xpath+" is not interractable");
			reportStep("The element with xpath "+xpath+" is not interractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with xpath "+xpath+" is not stable");
			reportStep("The element with xpath "+xpath+" is not stable", "Fail");
		}catch (ElementNotSelectableException e) {
			//System.err.println("The option in dropdown with  "+value+ " is not selectable");
			reportStep("The option in dropdown with  "+value+ " is not selectable", "Fail");
		}
		catch (WebDriverException e) {
			//System.err.println("The element with xpath "+xpath+" is not found due unkown error");
			reportStep("The element with xpath "+xpath+" is not found due unkown error", "Fail");
		}
	}
	public void SelectVissibletextByxpath(String xpath, String value) {
		try {
			WebElement wb = driver.findElementByXPath(xpath);
			Select byxpath = new Select(wb);
			byxpath.selectByVisibleText(value);
			//System.out.println("The value of the element "+value+" was selected successfully using the xpath"+xpath);
			reportStep("The value of the element "+value+" was selected successfully using the xpath"+xpath, "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with xpath "+xpath+" is not found in the DOM");
			reportStep("The element with xpath "+xpath+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with xpath "+xpath+" is not vissible in the application");
			reportStep("The element with xpath "+xpath+" is not visible in the application", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with xpath "+xpath+" is not interractable");
			reportStep("The element with xpath "+xpath+" is not interractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with xpath "+xpath+" is not stable");
			reportStep("The element with xpath "+xpath+" is not stable", "Fail");
		}catch (ElementNotSelectableException e) {
			//System.err.println("The option in dropdown with  "+value+ " is not selectable");
			reportStep("The option in dropdown with  "+value+ " is not selectable", "Fail");
		}
		catch (WebDriverException e) {
			//System.err.println("The element with xpath "+xpath+" is not found due unkown error");
			reportStep("The element with xpath "+xpath+" is not found due unkown error", "Fail");
		}

	}
	public void selectIndexByXpath(String xpath, int value) {
		try {
			WebElement wb = driver.findElementByXPath(xpath);
			Select byxpath = new Select(wb);
			byxpath.selectByIndex(value);
			//System.out.println("The value of the element "+value+" was selected successfully using the xpath"+xpath);
			reportStep("The value of the element "+value+" was selected successfully using the xpath"+xpath, "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with xpath "+xpath+" is not found in the DOM");
			reportStep("The element with xpath "+xpath+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with xpath "+xpath+" is not vissible in the application");
			reportStep("The element with xpath "+xpath+" is not vissible in the application", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with xpath "+xpath+" is not interractable");
			reportStep("The element with xpath "+xpath+" is not interractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with xpath "+xpath+" is not stable");
			reportStep("The element with xpath "+xpath+" is not stable", "Fail");
		}catch (ElementNotSelectableException e) {
			//System.err.println("The option in dropdown with  "+value+ " is not selectable");
			reportStep("The option in dropdown with  "+value+ " is not selectable", "Fail");
		}
		catch (WebDriverException e) {
			//System.err.println("The element with xpath "+xpath+" is not found due unkown error");
			reportStep("The element with xpath "+xpath+" is not found due unkown error", "Fail");
		}

	}
	public String getAttributeValue(String xpath, String attribute) {
		String attributevalue = null ;
		try {
			attributevalue = driver.findElementByXPath(xpath).getAttribute(attribute);
			//System.out.println("The element with the xpath "+xpath+" is found with the value " +attributevalue);			
			reportStep("The element with the xpath "+xpath+" is found with the value " +attributevalue, "Pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with xpath "+xpath+" is not found in the DOM");
			reportStep("The element with xpath "+xpath+" is not found in the DOM", "Fail");
		}catch(ElementNotVisibleException e){
			//System.err.println("The element with xpath "+xpath+" is not vissible in the application");
			reportStep("The element with xpath "+xpath+" is not vissible in the application", "Fail");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with xpath "+xpath+" is not interractable");
			reportStep("The element with xpath "+xpath+" is not interractable", "Fail");
		}catch (StaleElementReferenceException e){
			//System.err.println("The element with xpath "+xpath+" is not stable");
			reportStep("The element with xpath "+xpath+" is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with xpath "+xpath+" is not found due unkown error");
			reportStep("The element with xpath "+xpath+" is not found due unkown error", "Fail");
		}

		return attributevalue;
	}
	public void enterByxpathKeysTab(String xpath, String value) {
		try {
			driver.findElementByXPath(xpath).sendKeys(value, Keys.TAB);
			//System.out.println("The element with the xpath "+xpath+ " is entered sucessfully data "+value+ " with the pageAction ");
			reportStep("The element with the xpath "+xpath+ " is entered sucessfully data "+value+ " with the pageAction ", "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with the xpath "+ xpath+ " is not found in the DOM");
			reportStep("The element with the xpath "+ xpath+ " is not found in the DOM", "Fail");

		}catch (ElementNotVisibleException e) {
			//System.err.println("The element with the xpath "+xpath+" is not vissible in the application");
			reportStep("The element with the xpath "+xpath+" is not vissible in the application", "Fail");

		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with the xpath "+xpath+ " is not interactable");
			reportStep("The element with the xpath "+xpath+ " is not interactable", "Fail");

		}catch (StaleElementReferenceException e) {
			//System.err.println("The element with the path "+xpath+ " is not stable");
			reportStep("The element with the path "+xpath+ " is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with the xpath "+xpath+" is not entered due to unkown error");
			reportStep("The element with the xpath "+xpath+" is not entered due to unkown error", "Fail");
		}


	}
	public void pageDown(String xpath) {
		try {
			driver.findElementByXPath(xpath).sendKeys(Keys.PAGE_DOWN);
			//System.out.println("Page drilled down successfully");
			reportStep("Page drilled down successfully", "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with the xpath "+ xpath+ " is not found in the DOM");
			reportStep("The element with the xpath "+ xpath+ " is not found in the DOM", "Fail");
		}catch (ElementNotVisibleException e) {
			//System.err.println("The element with the xpath "+xpath+" is not vissible in the application");
			reportStep("The element with the xpath "+xpath+" is not vissible in the application", "Fail");

		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with the xpath "+xpath+ " is not interactable");
			reportStep("The element with the xpath "+xpath+ " is not interactable", "Fail");

		}catch (StaleElementReferenceException e) {
			//System.err.println("The element with the path "+xpath+ " is not stable");
			reportStep("The element with the path "+xpath+ " is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with the xpath "+xpath+" is not identified due to unkown error");
			reportStep("The element with the xpath "+xpath+" is not identified due to unkown error", "Fail");
		}

	}
	public void enterByxpathArrowDownKeys(String xpath, String value) {
		try {
			driver.findElementByXPath(xpath).sendKeys(value, Keys.ARROW_DOWN, Keys.TAB);
			//System.out.println("The element with the xpath "+xpath+ " is entered sucessfully data "+value+ " and arrow down and tab is performed ");
			reportStep("The element with the xpath "+xpath+ " is entered sucessfully data "+value+ " and arrow down and tab is performed ", "Pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with the xpath "+ xpath+ " is not found in the DOM");
			reportStep("The element with the xpath "+ xpath+ " is not found in the DOM", "Fail");

		}catch (ElementNotVisibleException e) {
			//System.err.println("The element with the xpath "+xpath+" is not vissible in the application");
			reportStep("The element with the xpath "+xpath+" is not vissible in the application", "Fail");

		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with the xpath "+xpath+ " is not interactable");
			reportStep("The element with the xpath "+xpath+ " is not interactable", "Fail");
		}catch (StaleElementReferenceException e) {
			//System.err.println("The element with the path "+xpath+ " is not stable");
			reportStep("The element with the path "+xpath+ " is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with the xpath "+xpath+" is not entered due to unkown error");
			reportStep("The element with the xpath "+xpath+" is not entered due to unkown error", "Fail");
		}

	}
	public String verifyGetAttributeByXpath(String xpath, String attribute) {
		String attributeValue = null;

		try {
			attributeValue = driver.findElementByXPath(xpath).getAttribute(attribute);

			if(attributeValue!=null){
				//System.out.println(attributeValue+" is the value on the attribute"+attribute);
				reportStep(attributeValue+" is the value on the attribute named "+attribute, "Pass");
			}
			else if (!attributeValue.equals(attribute)){
				//System.out.println(attributeValue+" is not found");
				reportStep(attributeValue+" is not found", "Info");
			}}catch (NoSuchElementException e) {
				//System.err.println("The element with the xpath "+ xpath+ " is not found in the DOM");
				reportStep("The element with the xpath "+ xpath+ " is not found in the DOM", "Fail");

			}catch (ElementNotVisibleException e) {
				//System.err.println("The element with the xpath "+xpath+" is not vissible in the application");
				reportStep("The element with the xpath "+xpath+" is not vissible in the application", "Fail");

			}catch (ElementNotInteractableException e) {
				//System.err.println("The element with the xpath "+xpath+ " is not interactable");
				reportStep("The element with the xpath "+xpath+ " is not interactable", "Fail");

			}catch (StaleElementReferenceException e) {
				//System.err.println("The element with the path "+xpath+ " is not stable");
				reportStep("The element with the path "+xpath+ " is not stable", "Fail");
			}catch (WebDriverException e) {
				//System.err.println("The element with the xpath "+xpath+" is not entered due to unkown error");
				reportStep("The element with the xpath "+xpath+" is not entered due to unkown error", "Fail");
			}

		return attributeValue;
	}


	public void compareText(String actual, String expected) {
		try {
			if (actual.equals(expected)){
				//System.out.println("The text actual "+actual+" matchs the text expected "+expected);
				reportStep("The actual text "+actual+" matchs with the expected text  "+expected, "Pass");

			}
			else if (!actual.equalsIgnoreCase(expected)){
				//System.out.println("The text actual "+actual+" does not matchs the text expected "+expected);
				reportStep("The text actual "+actual+" does not matchs the text expected "+expected, "fail");
			}
		} catch (WebDriverException e) {

			e.printStackTrace();
		}

	}
	public void mouseHoverByLink(String LinkText) {

		try {
			Actions mouse = new Actions(driver);

			WebElement obj = driver.findElementByLinkText(LinkText);

			mouse.moveToElement(obj).perform();

			//System.out.println("The element with link "+LinkText+ " is hovered successfully");
			reportStep("The element with link "+LinkText+ " is hovered successfully", "Pass");

		} catch (NoSuchElementException e) {
			//System.err.println("The element with the LinkText "+ LinkText+ " is not found in the DOM");
			reportStep("The element with the LinkText "+ LinkText+ " is not found in the DOM", "Fail");
		}catch (ElementNotVisibleException e) {
			//System.err.println("The element with the LinkText "+LinkText+" is not vissible in the application");
			reportStep("The element with the LinkText "+LinkText+" is not vissible in the application", "Fail");

		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with the LinkText "+LinkText+ " is not interactable");
			reportStep("The element with the LinkText "+LinkText+ " is not interactable", "Fail");

		}catch (StaleElementReferenceException e) {
			//System.err.println("The element with the LinkText "+LinkText+ " is not stable");
			reportStep("The element with the LinkText "+LinkText+ " is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with the LinkText "+LinkText+" is not entered due to unkown error");
			reportStep("The element with the LinkText "+LinkText+" is not entered due to unkown error", "Fail");
		}


	}
	public void mouseHoverByXpath(String xpath) {

		try {
			Actions mouse = new Actions(driver);

			WebElement obj = driver.findElementByXPath(xpath);

			mouse.moveToElement(obj).perform();

			reportStep("The element with xpath "+xpath+ " is hovered successfully", "Pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with the LinkText "+ LinkText+ " is not found in the DOM");
			reportStep("The element with the xpath "+ xpath+ " is not found in the DOM", "Fail");
		}catch (ElementNotVisibleException e) {
			//System.err.println("The element with the LinkText "+LinkText+" is not vissible in the application");
			reportStep("The element with the xpath "+xpath+" is not vissible in the application", "Fail");

		}catch (ElementNotInteractableException e) {
			//System.err.println("The element with the LinkText "+LinkText+ " is not interactable");
			reportStep("The element with the xpath "+xpath+ " is not interactable", "Fail");

		}catch (StaleElementReferenceException e) {
			//System.err.println("The element with the LinkText "+LinkText+ " is not stable");
			reportStep("The element with the xpath "+xpath+ " is not stable", "Fail");
		}catch (WebDriverException e) {
			//System.err.println("The element with the LinkText "+LinkText+" is not entered due to unkown error");
			reportStep("The element with the xpath "+xpath+" is not entered due to unkown error", "Fail");
		}
	}
	public void refreshPage() {

		driver.navigate().refresh();

	}
	public void pageDown() {

		driver.findElementByXPath("//html/body").sendKeys(Keys.PAGE_DOWN);

	}
	public void waitTillSelectable(String xpath) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(xpath), true));
			
			//System.out.println("The driver was made to explicitly wait until the element with xpath "+xpath+" to become selectable");
			reportStep("The driver was made to explicitly wait until the element with xpath "+xpath+" to become selectable", "pass");
			
		} catch (ElementNotSelectableException e) {
			
			//System.err.println("The element "+xpathval+" is not selectable ");
			reportStep("The element "+xpath+" is not selectable " , "fail");
		}catch (NoSuchElementException e) {
			
			//System.err.println("The element "+xpathval+" is not found in DOM" );
			reportStep("The element "+xpath+" is not found in DOM" , "fail");
			
		} catch (ElementNotVisibleException e) {
			
			//System.err.println("The element "+xpathval+" is not visible in DOM" );
			reportStep("The element "+xpath+" is not visible in DOM" , "fail");
		} catch (ElementNotInteractableException e) {
			
			//System.err.println("The element "+xpathval+" is not interactable ");
			reportStep("The element "+xpath+" is not interactable " , "fail");
		}catch (StaleElementReferenceException e) {
			
			//System.err.println("The element "+xpathval+ "is not stable in the application");
			reportStep("The element "+xpath+ "is not stable in the application" , "fail");
		}catch (WebDriverException e) {
			
			//System.err.println("Unable to get element "+xpathval+ " due to unknown reasons ");
			reportStep("Unable to get element "+xpath+ " due to unknown reasons " , "fail");
		}


		
	}
	public void pickFromListXpath(String xpath, String data) {

		try {
			List<WebElement> menu = driver.findElementsByXPath(xpath);
			
			for (WebElement element : menu){
				
				String innerhtml= element.getAttribute("innerhtml");
				
				if(innerhtml.contains(data)){
					
					element.click();
				}
				
				System.out.println("The value "+data+ " is picked from the list using the xpath "+xpath);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with the xpath "+ xpath+ " is not found in the DOM");

		}catch (ElementNotVisibleException e) {
			System.err.println("The element with the xpath "+xpath+" is not vissible in the application");

		}catch (ElementNotInteractableException e) {
			System.err.println("The element with the xpath "+xpath+ " is not interactable");

		}catch (StaleElementReferenceException e) {
			System.err.println("The element with the path "+xpath+ " is not stable");
		}catch (WebDriverException e) {
			System.err.println("The element with the xpath "+xpath+" is not entered due to unkown error");
		}
		
	}

	public String generateXpath(String xpath, String value){
		String xpathgenerated=null;
		if(xpath.contains("$value$")){
			int index=xpath.indexOf('$');
			System.out.println("index "+index);
			String s=xpath.substring(0, index);
			String a=s.concat(value);
			 xpathgenerated=a.concat("']");
			System.out.println(xpathgenerated);
		}
		return xpathgenerated;
	}
	
	public String generateXpath1(String xpath, String value){
		String xpathgenerated=null;
		String old = "$value$";
		if (xpath.contains("$value$")){
			xpathgenerated= xpath.replace(old, value);
			
			System.out.println(xpathgenerated);
		}
		return xpathgenerated;
		

}


	public String clickRadioXpath(String xpath, String data) {

		List<WebElement> radio = driver.findElementsByXPath(xpath);
		
		for(WebElement ele : radio){
			
			String button = ele.getAttribute("value");
			
			if (data.equalsIgnoreCase(button)){
				
				
			}
		}

		return null;
	}


	public void clickWebTable(String xpath, String expected) {
		
		List<WebElement> stored = driver.findElementsByXPath(xpath);
		
		int contains = stored.size();
		
		for(int i = 0; i<contains; i++)
		{
			String actual = stored.get(i).getText();
			
			if(actual.equals(expected)){
				
				stored.get(i).click();
				break;
			}
		}
		
	}}
