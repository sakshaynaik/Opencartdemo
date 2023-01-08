package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Forgotyourpasswordpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC040_FPinvalidunregemailidtest extends BaseClass {

	@Test(dataProvider = "invaliddata")
	public void forgotPasswordWithInvalidEmailId(HashMap<String, String> hMap) {

		log.info("***** TC040_FPinvalidemailidtest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Forgotpassword", "Testcases") || hMap.get("Runmode").equals("N")) {

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

		Forgotyourpasswordpage frgtpasspg = loginpg.clickOnForgotPasswordLink();
		Assert.assertEquals(frgtpasspg.getForgotPasswordPageTitle(), config.getForgotPasswrdPageTitle());
		log.info("User Navigated To Forgot Password Page: " + frgtpasspg.getForgotPasswordPageTitle());

		Assert.assertTrue(frgtpasspg.isDisplayedForgetMsgContent());
		log.info("Forgot Password Message Content On Forgot Page: " + frgtpasspg.getForgetMsgContent());

		frgtpasspg.enterEmailOfForgotenPassword(hMap.get("Email"));
		frgtpasspg.clickOnContinueButton();
		log.info("User Entered Non Registered Emailaddress In Emailaddress Field");

		Assert.assertTrue(frgtpasspg.isDisplayedWarnForUnregisteredEmail());
		log.info("Warning Message For Unregisterd Email Displayed: " + frgtpasspg.getWarnForUnregisteredEmail());

		log.info("***** TC040_FPinvalidemailidtest Completed *****");

	}

	@DataProvider(name = "invaliddata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String filepath = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(filepath);
			data = ReadXlsxFile.getTestData(xlsreader, "invalidemail", "Data");

		} catch (Exception e) {

			e.printStackTrace();
		}
		return data;
	}
}
