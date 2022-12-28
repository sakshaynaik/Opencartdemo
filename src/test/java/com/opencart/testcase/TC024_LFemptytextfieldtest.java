package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC024_LFemptytextfieldtest extends BaseClass {

	@Test(dataProvider = "emptyfield", groups = "Smoke")
	public void loginWithEmptyTextField(HashMap<String, String> hMap) {

		log.info("***** TC024_LFemptytextfieldtest Started *****");

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
		loginpg.clickLoginButton();

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("User Still In Loginpage Due To Invalid Credentials: " + loginpg.getLoginPageTitle());

		Assert.assertTrue(loginpg.isDisplayedWarnInvalidLoginCredential());
		log.info("Warn Message Displayed For Invalid Credentials: " + loginpg.getWarnInvalidLoginCredential());

		log.info("***** TC024_LFemptytextfieldtest Completed *****");
	}

	@DataProvider(name = "emptyfield")
	public Object[][] dataSupplier() {

		Object[][] data = null;

		try {
			String filepath = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(filepath);
			data = ReadXlsxFile.getTestData(xlsreader, "withoutcredentials", "Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
