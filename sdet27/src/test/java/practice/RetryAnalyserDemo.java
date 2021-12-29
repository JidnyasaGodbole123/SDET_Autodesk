package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserDemo {
	@Test(retryAnalyzer = com.crm.Autodesk.genericutility.RetryAnalyserImpl.class)
	public void retryAnalyserDemoTest()
	{
		System.out.println("RetryAnalyser");
		Assert.fail();
	}

}
