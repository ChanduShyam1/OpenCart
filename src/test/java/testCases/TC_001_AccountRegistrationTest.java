package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups = {"regression","master"})
	public void Verify_Account_Registration() throws InterruptedException
	{
		logger.info("******starting Verify_Account_Registration******");
		
		logger.debug("Application logs.....");
		try
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickAccount();
		logger.info("Clicked on My Account Link");
		hp.clickRegister();
		logger.info("Cicked on Register Link");
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		logger.info("Entering Customer Info");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+ "@gmail.com");
		regPage.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric(); 
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		String cofmsg = regPage.getConfirmation();
		
		logger.info("validting confirmation message");
		if(cofmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("test passed.");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed.");
			Assert.fail();
		}
	
		}
		catch(Exception e)
		{
			logger.error("test failed....");
			logger.info("debug logs.....");
			Assert.fail();
		}
		logger.info("Application logs end.....");
		logger.info("******finished Verify_Account_Registration******");
	}
	
}
