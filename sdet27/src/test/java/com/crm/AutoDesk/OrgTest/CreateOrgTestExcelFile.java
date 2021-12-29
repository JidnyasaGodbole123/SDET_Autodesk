package com.crm.AutoDesk.OrgTest;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTestExcelFile {
	public static void main(String[] args) throws Throwable {
		//read common data from properties File
				FileInputStream fis =new FileInputStream("./Data/CommonData.properties");
			         Properties pObj=new Properties();
				     pObj.load(fis);	     
				 String URL = pObj.getProperty("url");
				 String USERNAME = pObj.getProperty("username");
				 String PASSWORD = pObj.getProperty("password");
				 String BROWSER = pObj.getProperty("browser");
				 
				 //read test data from Excel File
				 FileInputStream fis_e = new FileInputStream("./Data/Exceldata.xlsx");
				 Workbook wb = WorkbookFactory.create(fis_e);
				 Sheet sh = wb.getSheet("Sheet1");
				 Row row = sh.getRow(0);
				 String orgNAme = row.getCell(0).getStringCellValue();
				 
				 WebDriver driver;
	if(BROWSER.equals("firefox")) {
		         driver = new FirefoxDriver();
	}else if (BROWSER.equals("chrome")) {
		         driver = new ChromeDriver();
	}else if(BROWSER.equals("ie")) {
		         driver = new InternetExplorerDriver();
	}else {
		        driver = new ChromeDriver();
	}
	//step 1 : login
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(URL);
	
	 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 driver.findElement(By.id("submitButton")).click();
	//step 2 :navigate to Organization module
	  driver.findElement(By.linkText("Organizations")).click();
	// step 3: click on "create Organization" Button
	  driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	 // step 4: enter all the details & create new Organization
	  driver.findElement(By.name("accountname")).sendKeys(orgNAme);
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	  // step 5: display that msg
	  String msg= driver.findElement(By.className("dvHeaderText")).getText();
	  if(msg.contains(orgNAme)) {
		  System.out.println("pass.........");
	  }else {
		  System.out.println("Fail......");
	  }
	  //step 6 :logout
	  Actions act = new Actions(driver);
	  act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	  driver.findElement(By.linkText("Sign Out")).click();
	  driver.quit();
	  }
	}

