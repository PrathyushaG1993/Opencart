package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement MyAccountLink;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement RegisterLink;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement LoginLink;

	public void clickMyAccountLink() {
		MyAccountLink.click();
	}

	public void clickRegisterLink() {
		RegisterLink.click();
	}

	public void clickLoginLink() {
		LoginLink.click();
	}
}
