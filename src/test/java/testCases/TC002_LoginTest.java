package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = { "sanity", "regression" })
	public void verify_login() {
		logger.info("**** Started TC002_LoginTest ****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccountLink();

			hp.clickLoginLink();

			logger.info("Entered the credential");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			logger.info("Verified the Account page");
			MyAccountPage myacc = new MyAccountPage(driver);
			boolean target = myacc.checkMyAccount();
			// Assert.assertEquals(target, true, "My account page exist");
			Assert.assertTrue(target);
		} catch (Exception e) {
			Assert.fail();

		}
		logger.info("*** Finished TC002_LoginTest ***");
	}
}
