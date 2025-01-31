package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
	public void verify_loginDataProvider(String email, String pwd, String exp) {
		logger.info("**** Started TC003_LoginDataDrivenTest ****");
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccountLink();
			hp.clickLoginLink();

			logger.info("Entered the credentials");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			MyAccountPage myacc = new MyAccountPage(driver);
			boolean targetpage = myacc.checkMyAccount();
			logger.info("Verifying the credentials list");

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetpage == true) {
					myacc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetpage == true) {
					myacc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		} finally {
			logger.info("**** Finished TC003_LoginDataDrivenTest ****");
		}
	}

}
