package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("****** Starting TC001_AccountRegistrationTest  ******");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info(" Clicked on MyAccount ");
		
		hp.clickRegister();
		logger.info(" Clicked on Register Link ");
		
		AccountRegistrationPage acp = new AccountRegistrationPage(driver);
		logger.info("Providing customer details ....");
		acp.setFirstName(randomString().toUpperCase());
		acp.setLastName(randomString().toUpperCase());
		acp.setEmail(randomString()+"@gmail.com");
		acp.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		
		acp.setPassword(password);
		acp.setConfPassword(password);
		acp.setPrivacyPolicy();
		acp.clickContinue();
		
		logger.info("Validating expected Message...");
		String confmsg = acp.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		
		logger.info("***** Finished TC001_AccountRegistrationTest  *****");
	}
	
	
	
}
