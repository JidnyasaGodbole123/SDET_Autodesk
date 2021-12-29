package com.crm.AutoDesk.OrgTest;

import org.testng.annotations.Test;

import com.crm.Autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.Autodesk.ObjectRepository.OrganizationsPage;
import com.crm.Autodesk.genericutility.BaseClass;

public  class CreateOrgTestUsingTestNG extends BaseClass {
	@Test (groups = {"RegressionSuite","SmokeSuite"})
	public void createOrgTest() throws Throwable
	{
		//getRanDom Num
	
		int ranDomNum = jLib.getRanDomNumber();
		
		//read test data from Excel File
		String orgNAme = eLib.getDataFromExcel("org", 1, 2)+ranDomNum;
		
		//step2: navigate to Organization module
		HomePage hp= new HomePage(driver);
		hp.clickonOrganizationsLink();
		
		//step3: click on "create Organization" Button
		OrganizationsPage op =new OrganizationsPage(driver);
		op.clcikOnCreateOrg();
		
		//step4 : enter all the details & create new Organization
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.createOrg(orgNAme);
		
		//step 5 :verify Organization name in header of the msg
		OrganizationInfoPage oip =new OrganizationInfoPage(driver);
		String ActMsg= oip.getOrgInfo();
		if(ActMsg.contains(orgNAme))
		{
			System.out.println(ActMsg);
			System.out.println("Organization create successfully");
		}
		else
		{
			System.err.println("Failed");
		}
			
	}
	@Test(groups= {"RegressionSuite","SmokeSuite"})
	public void demo()
	{
		System.out.println("demo");
	}

}
