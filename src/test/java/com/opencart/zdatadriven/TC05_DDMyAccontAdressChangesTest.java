package com.opencart.zdatadriven;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Myaccountinfopage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC05_DDMyAccontAdressChangesTest extends Baseclassdatadriven {

	@Test(dataProvider = "existdata")
	public void myAccountInfoDetailsUpdating(HashMap<String, String> hMap) {

		log.info("***** TC05_DDMyAccontAdressChangesTest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "MyAccountInfoTest", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		setBrowser(hMap.get("Browser"));
		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(hMap.get("Email"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		Accountpage accntpg = loginpg.clickLoginButton();
		log.info("User Logged Into Accounts Page ");

		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		Assert.assertTrue(accntpg.isDisplayedEditInfoLink());
		log.info("Edit Info Link Displayed On Accounts Page");

		Assert.assertTrue(accntpg.isDisplayedAccountLinkOnBedcrum());
		log.info("Accont Link Displayed On BedCrum Of Accounts Page");

		Myaccountinfopage myacntinfopg = accntpg.clickOnEditYourInfoLink();
		Assert.assertEquals(myacntinfopg.getMyAccountInfoPageTitle(), config.getMyAccountInfoPageTitle());
		log.info("MyAccontInfo Page Title: " + myacntinfopg.getMyAccountInfoPageTitle());

		myacntinfopg.enterNewFirstName(hMap.get("FirstName"));
		myacntinfopg.enterNewLastName(hMap.get("LastName"));
		myacntinfopg.enterNewEmail(hMap.get("Newemail"));
		myacntinfopg.enterNewTelephoneNumber(hMap.get("Telephone"));
		myacntinfopg.clickOnContinueButton();
		log.info("User Updated His New Account Credentials In MyAccountInfo Page");

		String expctedresult = hMap.get("ExpectedResult");
		boolean convertedExpectedResult = false;

		if (expctedresult.equals("Success")) {
			convertedExpectedResult = true;
		} else if (expctedresult.equals("Failure")) {
			convertedExpectedResult = false;
		}

		boolean convertedActualResult;

		try {

			Assert.assertEquals(myacntinfopg.getMyAccountInfoPageTitle(), config.getMyAccountInfoPageTitle());
			log.info("MyAccontInfo Page Title: " + myacntinfopg.getMyAccountInfoPageTitle());
			convertedActualResult = false;

		} catch (Throwable e) {

			Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
			log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());
			
			accntpg.clickLogoutOption();
			log.info("User Logged Out From The Site");

			hmpg.clickOnMyAccountDropMenu();
			hmpg.clickOnLoginLink();
			Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
			log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

			loginpg.enterRegisteredEmail(hMap.get("Email"));
			loginpg.enterRegisteredPassword(hMap.get("Password"));
			loginpg.clickLoginButton();
			log.info("User Logged Into Accounts Page ");

			Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
			log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

			loginpg.enterRegisteredEmail(hMap.get("Newemail"));
			loginpg.enterRegisteredPassword(hMap.get("Password"));
			loginpg.clickLoginButton();
			log.info("User Logged Into Accounts Page ");

			accntpg.clickOnEditYourInfoLink();
			Assert.assertEquals(myacntinfopg.getMyAccountInfoPageTitle(), config.getMyAccountInfoPageTitle());
			log.info("MyAccontInfo Page Title: " + myacntinfopg.getMyAccountInfoPageTitle());

			myacntinfopg.enterNewFirstName(hMap.get("FirstName"));
			myacntinfopg.enterNewLastName(hMap.get("LastName"));
			myacntinfopg.enterNewEmail(hMap.get("Email"));
			myacntinfopg.enterNewTelephoneNumber(hMap.get("Telephone"));
			myacntinfopg.clickOnContinueButton();
			log.info("User Updated His New Account Credentials In MyAccountInfo Page");

			Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
			log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

			convertedActualResult = accntpg.isDisplayedUpdatedSuccessMsg();
			Assert.assertTrue(accntpg.isDisplayedUpdatedSuccessMsg());
			log.info("Account Updated Success Message: " + accntpg.getUpdatedSuccessMsg());

		}

		Assert.assertEquals(convertedActualResult, convertedExpectedResult);

		log.info("***** TC05_DDMyAccontAdressChangesTest Completed *****");
	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//datadrivenfile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "updatedetails", "Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
