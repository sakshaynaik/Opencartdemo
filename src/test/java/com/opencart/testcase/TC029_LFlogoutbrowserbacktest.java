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

public class TC029_LFlogoutbrowserbacktest extends BaseClass {

	@Test(dataProvider = "validata", groups = "Smoke")
	public void loginAndLogoutBrowserBack(HashMap<String, String> hMap) {

		log.info("***** TC29_LFlogoutbrowserbacktest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Login", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
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
		log.info("Account Link Displayed On BedCrum Of Accounts Page");

		accntpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(accntpg.isDisplayedLogoutOption());
		Accountlogoutpage accntlogoutpg = accntpg.clickLogoutOption();
		log.info("User Logged Out From MyAccounts Page");

		accntlogoutpg.navigateBack();
		accntlogoutpg.refreshByJavascript();
		
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("User was Not Able To Login After Navigating Back But Directed To Login Page :"
				+ loginpg.getLoginPageTitle());

		accntpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		log.info("***** TC29_LFlogoutbrowserbacktest Completed *****");

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
