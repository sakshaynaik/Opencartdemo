package com.opencart.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadJavascriptExecutor;

public class Registerationpage {

	WebDriver ldriver;

	public Registerationpage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstname;

	@FindBy(id = "input-lastname")
	private WebElement lastname;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(name = "telephone")
	private WebElement telephone;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement confirmpassword;

	@FindBy(name = "newsletter")
	private WebElement newsleter;

	@FindBy(name = "agree")
	private WebElement privercypolicy;

	@FindBy(xpath = "//*[@id='content']/form/div/div/input[2]")
	private WebElement continebutton;

	@FindBy(xpath = "//*[@id='account']/div[2]/div/div")
	private WebElement warningfirstname;

	@FindBy(xpath = "//*[@id='account']/div[3]/div/div")
	private WebElement warninglastname;

	@FindBy(xpath = "//*[@id='account']/div[4]/div/div")
	private WebElement warningemailmsg;

	@FindBy(xpath = "//*[@id='account']/div[5]/div/div")
	private WebElement warningtelephonemsg;

	@FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement warningpasswordmsg;

	@FindBy(xpath = "//div[contains(text(),'Warning: You must agree to the Privacy Policy!')]")
	private WebElement warningpriverymsg;

	@FindBy(xpath = "//*[@id='column-right']/div/a[2]")
	private WebElement regiterfromcolum;

	@FindBy(xpath = "//div[text()='Password confirmation does not match password!']")
	private WebElement passmismatch;

	@FindBy(xpath = "//*[@id='account-register']/div[1]")
	private WebElement emailwarnmsg;

	@FindBy(xpath = "//*[@id='account']/div[4]/div/div")
	private WebElement invalidemailmsg;

	@FindBy(xpath = "//div[@class='list-group']/a")
	private List<WebElement> listgroup;

	/////////////////////////////////////////////

	public void highletTelephonTextField() {

		ReadJavascriptExecutor.drawBorder(telephone, ldriver);
		ReadJavascriptExecutor.scrollIntoView(telephone, ldriver);
	}

	public void refreshPage() {

		ldriver.navigate().refresh();
	}

	public void navigateBack() {

		ldriver.navigate().back();
	}

	public Loginpage clickOnRandomListGroup(int random) {

		WebElement randomlink = ldriver.findElement(By.xpath("//div[@class='list-group']/a[" + (random + 1) + "]"));
		randomlink.click();
		return (new Loginpage(ldriver));
	}

	public int getSizeListGroup() {

		return (listgroup.size());
	}

	public int getYCordinateOfPasswordField() {

		Point ycor = password.getLocation();
		return (ycor.y);
	}

	public int getXCordinateOfPasswordField() {

		Point xcor = password.getLocation();
		return (xcor.x);
	}

	public int getWidthOfEmailField() {

		Dimension hght = email.getSize();
		return (hght.width);
	}

	public int getHeigthOfEmailField() {

		Dimension hght = email.getSize();
		return (hght.height);
	}

	public boolean isSelectedForPrivercyPolicy() {

		return (privercypolicy.isSelected());
	}

	public String getAttributeForFirstNamePlaceholder(String att) {

		return (firstname.getAttribute(att));
	}

	public String getWarnForInvalidEmail() {

		return (invalidemailmsg.getText());
	}

	public boolean isDisplayedWarnForInvalidEmail() {

		return (invalidemailmsg.isDisplayed());
	}

	public String getWarnForAlredyRegisteredEmail() {

		return (emailwarnmsg.getText());
	}

	public boolean isDisplayedWarnForAlredyRegisteredEmail() {

		return (emailwarnmsg.isDisplayed());
	}

	public String getWarnForPasswordDiffer() {

		return (passmismatch.getText());
	}

	public boolean isDisplayedWarnForPasswordDiffer() {

		return (passmismatch.isDisplayed());
	}

	public void clickOnRightColumnRegisterOption() {

		regiterfromcolum.click();
	}

	public String getWarnPriveryMsg() {

		return (warningpriverymsg.getText());
	}

	public boolean isDisplayedWarnPriveryMsg() {

		return (warningpriverymsg.isDisplayed());
	}

	public String getWarnPasswordMsg() {

		return (warningpasswordmsg.getText());
	}

	public boolean isDisplayedWarnPasswordMsg() {

		return (warningpasswordmsg.isDisplayed());
	}

	public String getWarnTelephonemsg() {

		return (warningtelephonemsg.getText());
	}

	public boolean isDisplayedWarnTelephonemsg() {

		return (warningtelephonemsg.isDisplayed());
	}

	public String getWarnEmailMsg() {

		return (warningemailmsg.getText());
	}

	public boolean isDisplayedWarnEmailMsg() {

		return (warningemailmsg.isDisplayed());
	}

	public String getWarnLastNameMsg() {

		return (warninglastname.getText());
	}

	public boolean isDisplayedWarnLastNameMsg() {

		return (warninglastname.isDisplayed());
	}

	public String getWarnFirstNameMsg() {

		return (warningfirstname.getText());
	}

	public boolean isDisplayedWarnFirstNameMsg() {

		return (warningfirstname.isDisplayed());
	}

	public void enterFirstNameTextField(String fname) {

		firstname.sendKeys(fname);
	}

	public void enterLastNameTextField(String lname) {

		lastname.sendKeys(lname);
	}

	public void enterEmialTextField(String emil) {

		email.sendKeys(emil);
	}

	public void enterTelephoneTextField(String tphone) {

		telephone.sendKeys(tphone);
	}

	public void enterPasswordTextField(String pass) {

		password.sendKeys(pass);
	}

	public void enterConfirmPasswordTextField(String conpass) {

		confirmpassword.sendKeys(conpass);
	}

	public void clickOnNewsLetterRadioButton() {

		newsleter.click();

	}

	public void clickOnPriveryPolicyField() {

		privercypolicy.click();

	}

	public Successpage clickOnContinueButton() {

		continebutton.click();
		return (new Successpage(ldriver));

	}

	public String getRegPageTitle() {

		return (ldriver.getTitle());
	}

	public Successpage registrationWithKeyboardActions(String fname, String lname, String eml, String phno,
			String passwrd, String confpasswd) {

		Actions action = new Actions(ldriver);
		action.click(firstname).sendKeys(fname, Keys.TAB).sendKeys(lname, Keys.TAB).sendKeys(eml, Keys.TAB)
				.sendKeys(phno, Keys.TAB).sendKeys(passwrd, Keys.TAB).sendKeys(confpasswd, Keys.TAB).click(newsleter)
				.sendKeys(Keys.TAB, Keys.TAB).sendKeys(Keys.SPACE, Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		return (new Successpage(ldriver));

	}

}
