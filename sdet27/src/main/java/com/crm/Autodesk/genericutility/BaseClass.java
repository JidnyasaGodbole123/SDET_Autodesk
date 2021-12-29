package com.crm.Autodesk.genericutility;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.NewClassRefForm;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.LoginPage;
import com.mysql.cj.jdbc.Driver;

public class BaseClass {
	public DataBaseUtility dLib= new DataBaseUtility();
	public FileUtility fLib= new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public javaUtility jLib= new javaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriver driver;
	public static WebDriver sDriver;
	
	@BeforeSuite
	public void dbConnection() 
	{
		dLib.connectToDB();
		System.out.println("==========DataBase connection successFul=====");
	}
	@BeforeClass 
	public void launchBrowser() throws Throwable
	{
		//read the data
		String BROWSER= fLib.getPropertyKeyValue("browser");
		String URL =fLib.getPropertyKeyValue("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver =new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver=new FirefoxDriver();
		}
	
		else
		{
			System.out.println("invalid browser");
		}
		sDriver = driver ;
	wLib.waitForPageToLoad(driver);
	wLib.windowMaximize(driver);
	driver.get(URL);
	
	System.out.println("======Browser launched=====");
	}
	
	@BeforeMethod 
	public void loginToApp() throws Throwable {
	//read the data
	String USERNAME = fLib.getPropertyKeyValue("username");
	String PASSWORD =fLib.getPropertyKeyValue("password");
     
	LoginPage lp= new LoginPage(driver);
	lp.login(USERNAME,PASSWORD);
	System.out.println("=======Login Succesfull======");
			}
	@AfterMethod
	public void logoutOfApp()
	{
		HomePage hp =new HomePage(driver);
		hp.logout(driver);
		System.out.println("=======Logout Succesfull======");
	}
		@AfterClass
		public void closeBrowser()
		{
			driver.quit();
			System.out.println("=====browser closed=====");
		}
		@AfterSuite
		public void dbConnection_close(){
			{
				dLib.closeDB();
				System.out.println("=====Database connection close====");
			}
		}
		
	}
	
	
