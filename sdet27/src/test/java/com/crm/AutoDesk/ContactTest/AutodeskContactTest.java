
 
package com.crm.AutoDesk.ContactTest;

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
import org.openqa.selenium.interactions.ClickAction;



class AutodeskContactTest {
	 
	public static void main(String[] args) throws Throwable {
		 //Step1: get the java Representation Object of the physical File
		 FileInputStream fis_1 = new FileInputStream("./Data/CommonData.properties");
		 
		 //Step 2: create an Object to property
                     Properties pobj= new Properties();
                     pobj.load(fis_1);
                     String URL = pobj.getProperty("url");
                     String USERNAME = pobj.getProperty("username");
                     String PASSWORD = pobj.getProperty("password");
                     String BROWSER = pobj.getProperty("browser");                     
                     FileInputStream fis_2 = new FileInputStream("./Data/Exceldata.xlsx"); 
                     Workbook wb =WorkbookFactory.create(fis_2);
                     Sheet sheet = wb.getSheet("Sheet1");
                     Row row =sheet.getRow(0);
                     String lastName = row.getCell(1).getStringCellValue();
                      
                     WebDriver driver;
                     if(BROWSER.equals("firefox")) { 
                    	 driver = new FirefoxDriver();
                     }else if (BROWSER.equals("chorme")) {
                    	   driver = new ChromeDriver();
                     }else if (BROWSER.equals("ie")) {
                    	    driver = new InternetExplorerDriver();
                     }else {
                    	 driver =new ChromeDriver();
                     }
                     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                     driver.get(URL);
                     driver.findElement(By.name("user_name")).sendKeys(USERNAME);
                     driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
                     driver.findElement(By.id("submitButton")).click();
                     driver.findElement(By.linkText("Contacts")).click();
                     driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
                     driver.findElement(By.name("lastname")).sendKeys("Godbole");
                     driver.findElement(By.className("save")).click();
                     
                     
                    	   }
                     }


