package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div/h2[text()='My Account']")
	WebElement txt_MyAccount;

	@FindBy(xpath = "//div[@class='list-group']/a[text()='Logout']")
	WebElement lnk_Logout;

	public boolean checkMyAccount() {
		try {
			return (txt_MyAccount.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {
		lnk_Logout.click();
	}

}
