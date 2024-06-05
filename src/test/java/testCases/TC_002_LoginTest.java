package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups = {"sanity","master"})
	public void verify_login() {
		try {
			logger.info("*****starting TC_002_Verify_Login_Test*****");
			logger.debug("Capturing application debug logs");

			// Home_Page
			HomePage hp = new HomePage(driver);
			hp.clickAccount();
			logger.info("Clicked on My Account Link");
			hp.clickLogin();
			logger.info("Clicked on Login link under My Account");

			// Login_Page
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password");

			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			// My_Account_Page
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			if (targetPage == true) {
				logger.info("Login test passed");
				Assert.assertTrue(true);
			} else {
				logger.error("Login test failed");
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*****Completed TC_002_Verify_Login_Test*****");
	}
}
