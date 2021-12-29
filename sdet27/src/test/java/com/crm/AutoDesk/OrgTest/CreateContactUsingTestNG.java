package com.crm.AutoDesk.OrgTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.crm.Autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.Autodesk.ObjectRepository.OrganizationsPage;
import com.crm.Autodesk.genericutility.BaseClass;
import com.sun.corba.se.pept.transport.ContactInfo;

public class CreateContactUsingTestNG extends BaseClass{
	@Test (groups = {"RegressionSuite","SmokeSuite"})
	public void createOrgTest() throws Throwable
	{
		//getRanDom Num
	
		int ranDomNum = jLib.getRanDomNumber();
		
		//read test data from Excel File
		String ConNAme = eLib.getDataFromExcel("org", 1, 2)+ranDomNum;
		String lastn =eLib.getDataFromExcel("Org",1,3);
		
		//step2: navigate to Organization module
		
		HomePage hp= new HomePage(driver);
		hp.clickonOrganizationsLink();
		
		//step3: click on create Contact button
		ContactInfo cp =new ContactInfo(driver);
		cp.clcikOnContactInfo();
		
		//step4 : enter all the details & create new Contact
		ContactInfoPage(driver);
		ccp.Contact(lastn);
		
		//step 5 :verify Organization name in header of the msg
		ContactInfoPage cip =new ContactInfoPage(driver);
		String ActMsg= cip.getContactInfo();
		
		if(ActMsg.contains(lastn))
		{
			System.out.println(ActMsg);
			System.out.println("ontact created successfully");
		}
		else
		{
			System.err.println("Failed");
		}
			
	}

	/**
	 * @param driver
	 */
	private void ContactInfoPage(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
		

}



