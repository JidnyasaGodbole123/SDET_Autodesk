package com.crm.AutoDesk.OrgTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrgTest {
	public static void main(String[] args) throws Throwable {
		
	//step 1:get the java representation object of the Physical file
		FileInputStream fis =new FileInputStream("./Data/CommonData.properties");
	//step 2: Create an object to property class to load all the Keys	
		     Properties pObj=new Properties();
		     pObj.load(fis);
	//step 3:read the value using getProperty("keys")	     
		 String URL = pObj.getProperty("url");
		 String USERNAME = pObj.getProperty("username");
		 String PASSWORD = pObj.getProperty("password");
		 String BROWSER = pObj.getProperty("browser");
		 WebDriver driver=new ChromeDriver();
		 driver.get(URL);
		 
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
	}

}
