package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPrivacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//div/h1[text()='Your Account Has Been Created!']")
	WebElement CreatedMessage;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}

	public void setPrivacyPolicy() {
		chkPrivacyPolicy.click();
	}

	public void clickContinueBtn() {
		btnContinue.click();
	}

	public String getconfirmMessage() {
		try {
			return (CreatedMessage.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}

}
