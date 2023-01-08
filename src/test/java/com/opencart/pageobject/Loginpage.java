package com.opencart.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadJavascriptExecutor;

public class Loginpage {

	WebDriver ldriver;

	public Loginpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continbttn;

	@FindBy(id = "input-email")
	private WebElement loginemail;

	@FindBy(id = "input-password")
	private WebElement loginpassword;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement loginbttn;

	@FindBy(xpath = "//div[contains(text(),' Warning: No match for E-Mail Address')]")
	private WebElement warnmsglogin;

	@FindBy(linkText = "Forgotten Password")
	private WebElement forgotpassword;

	@FindBy(xpath = "//*[@id='account-login']/ul")
	private WebElement bedcrum;

	@FindBy(xpath = "//div[text()=' Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.']")
	private WebElement unsucesfulmsg;

	@FindBy(xpath = "//div[@class='list-group']/a")
	private List<WebElement> listgroup;

	@FindBy(xpath = "//ul[@class='breadcrumb']/li")
	private List<WebElement> bedcrumoptions;

	@FindBy(xpath = "//div[text()=' An email with a confirmation link has been sent your email address.']")
	private WebElement forgotpasssuccesmsg;

	//////////////////////////////////////////////////////

	public void clickOnRandomBedcrumOption(int randopt) {

		WebElement option = ldriver.findElement(By.xpath("//ul[@class='breadcrumb']/li[" + (randopt + 1) + "]"));
		option.click();
	}

	public int getSizeOfBedcrumOption() {

		return (bedcrumoptions.size());
	}

	public void refreshPage() {

		ldriver.navigate().refresh();
	}

	public void navigateBack() {

		ldriver.navigate().back();
	}

	public void clickOnRandomListGroupOption(int randopt) {

		WebElement option = ldriver.findElement(By.xpath("//div[@class='list-group']/a[" + (randopt + 1) + "]"));
		option.click();
	}

	public int getSizeOfListGroupsOption() {

		return (listgroup.size());
	}

	public String getUnsuccessfulAttemptMsgForLogin() {

		return (unsucesfulmsg.getText());
	}

	public boolean isDisplayedUnsuccessfulAttemptMsgForLogin() {

		return (unsucesfulmsg.isDisplayed());
	}

	public String getAttributeOfPasswordField(String att) {

		return (loginpassword.getAttribute(att));
	}

	public String getAttributeOfEmailField(String att) {

		return (loginemail.getAttribute(att));
	}

	public Accountpage loginByKeyboardActions(String email, String passwrd) {

		Actions action = new Actions(ldriver);
		action.click(bedcrum).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
				.sendKeys(Keys.TAB).sendKeys(email, Keys.TAB).sendKeys(passwrd, Keys.TAB).sendKeys(Keys.TAB)
				.sendKeys(Keys.ENTER).build().perform();
		return (new Accountpage(ldriver));
	}

	public Forgotyourpasswordpage clickOnForgotPasswordLink() {

		forgotpassword.click();
		return (new Forgotyourpasswordpage(ldriver));
	}

	public String getWarnInvalidLoginCredential() {

		return (warnmsglogin.getText());
	}

	public boolean isDisplayedWarnInvalidLoginCredential() {

		return (warnmsglogin.isDisplayed());
	}

	public Accountpage clickLoginButton() {

		loginbttn.click();
		return (new Accountpage(ldriver));
	}
	
	public void drawBorderEmailSentMsgForFP() {

		ReadJavascriptExecutor.drawBorder(forgotpasssuccesmsg, ldriver);
	}

	public String getEmailSentMsgForFP() {

		return (forgotpasssuccesmsg.getText());
	}

	public boolean isDisplayedEmailSentMsgForFP() {

		return (forgotpasssuccesmsg.isDisplayed());
	}

	public void enterRegisteredPassword(String regpass) {

		loginpassword.clear();
		loginpassword.sendKeys(regpass);
	}

	public void enterRegisteredEmail(String regemail) {

		loginemail.clear();
		loginemail.sendKeys(regemail);
	}

	public Registerationpage clickOnNewCustomerContinueButton() {

		continbttn.click();
		return (new Registerationpage(ldriver));
	}

	public String getLoginPageTitle() {

		return (ldriver.getTitle());
	}

}
