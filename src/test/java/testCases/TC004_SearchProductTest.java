package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass {

	@Test(groups= {"Master"})
	public void verify_productSearch()
	{
	
	try
	{
		HomePage hp =new HomePage(driver);
		hp.enterProductName("mac");
		
		hp.clickSearch();
		
		SearchPage sp=new SearchPage(driver);
		sp.isProductExist("MacBook");
		
		Assert.assertEquals(sp.isProductExist("MacBook"), true);
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("****** Finished TC_004_SearchProductTest ********");
}
	
}
