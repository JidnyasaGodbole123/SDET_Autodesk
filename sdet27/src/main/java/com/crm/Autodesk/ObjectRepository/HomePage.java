package com.crm.Autodesk.ObjectRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Autodesk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility { // step 1: create a separate class for home page
        
	//step 2 : Declaration 
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText ="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products" )
	private WebElement productsLnk;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLnk;
	
	@FindBy(linkText = "Email")
	private WebElement emailLnk;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement trobleTicketsLnk;
	
	@FindBy(xpath = "//img[@src ='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out" )
	private WebElement signOutLnk;
	
		//step 3 Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//step 4 Utilization
		public WebElement getOrganizationsLnk() {
			return organizationsLnk;
		}

		
		public WebElement getContactsLnk() {
			return contactsLnk;
		}

		
		public WebElement getOpportunitiesLnk() {
			return opportunitiesLnk;
		}

		
		public WebElement getProductsLnk() {
			return productsLnk;
		}

		
		public WebElement getDocumentsLnk() {
			return documentsLnk;
		}

		
		public WebElement getEmailLnk() {
			return emailLnk;
		}

		
		public WebElement getTrobleTicketsLnk() {
			return trobleTicketsLnk;
		}

				public WebElement getAdministratorImg() {
			return administratorImg;
		}

		
		public WebElement getSignOutLnk() {
			return signOutLnk;
		}
		
		
	//Business Library to click on organizations
		public void clickonOrganizationsLink()
		
		{
			organizationsLnk.click();
		}
		
	//Business Library to click on contacts
		public void clickOnContactsLinks()
		{
			contactsLnk.click();
		}
	//Business Library for logout
		public void logout(WebDriver driver)
		{
			mouseOverOnElement(driver, administratorImg);
			signOutLnk.click();
		}
	}
