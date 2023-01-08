package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountlogoutpage;
import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC035_LOlogoutfromrightcolumntest extends BaseClass {

	@Test(dataProvider = "validata")
	public void loginAndLogoutFromRightColumn(HashMap<String, String> hMap) {

		log.info("***** TC035_LOlogoutfromrightcolumntest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Login", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(hMap.get("Email1"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		Accountpage accntpg = loginpg.clickLoginButton();
		log.info("User Logged Into Accounts Page ");

		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		Assert.assertTrue(accntpg.isDisplayedEditInfoLink());
		log.info("Edit Info Link Displayed On Accounts Page");

		Assert.assertTrue(accntpg.isDisplayedAccountLinkOnBedcrum());
		log.info("Accont Link Displayed On BedCrum Of Accounts Page");

		Accountlogoutpage acclogoutpg = accntpg.clickLogoutOption();
		Assert.assertEquals(acclogoutpg.getAccountLogoutPageTitle(), config.getAccountLogoutPageTitle());
		log.info("User Logged Out From MyAccounts Page And Navigated To Account Logout Page: "
				+ acclogoutpg.getAccountLogoutPageTitle());

		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		acclogoutpg.clickOnContinueButton();
		Assert.assertEquals(hmpg.getHomePageTitle(), config.getHomePageTitle());
		log.info("User Navigated To Home Page After Clicking On Continue Button From AccountLogout Page: "
				+ hmpg.getHomePageTitle());

		log.info("***** TC035_LOlogoutfromrightcolumntest Completed *****");

	}

	@DataProvider(name = "validata")
	public Object[][] dataSupplier() {

		Object[][] data = null;

		try {
			String filepath = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(filepath);
			data = ReadXlsxFile.getTestData(xlsreader, "validcredentials", "Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
