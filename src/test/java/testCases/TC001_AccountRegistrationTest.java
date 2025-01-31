package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"sanity"})
	public void verify_Account_Registration() {

		try {
			logger.info("**** Started TC001_AccountRegistrationTest ****");
			HomePage hp = new HomePage(driver);

			logger.info("clicked on MyAccountlink ");
			hp.clickMyAccountLink();

			logger.info("clicked on Registration link");
			hp.clickRegisterLink();

			AccountRegistrationPage arp = new AccountRegistrationPage(driver);

			logger.info("Providing customer details");
			arp.setFirstName(randomAlphabetic());
			arp.setLastName(randomAlphabetic());
			arp.setEmail(randomAlphabetic() + "@gmail.com");
			arp.setTelephone(randomNumber());

			String password = alphaNumeric();
			arp.setPassword(password);
			arp.setConfirmPassword(password);
			arp.setPrivacyPolicy();
			arp.clickContinueBtn();

			logger.info("Validating expected message");
			String cnfmessage = arp.getconfirmMessage();
			if (cnfmessage.equals("Your Account Has Been Created!")) {

				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {

			Assert.fail();
		}
		logger.info("**** Finished the TC001_AccountRegistrationTest****");
	}

}
