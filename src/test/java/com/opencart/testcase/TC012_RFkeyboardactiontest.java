package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Registerationpage;
import com.opencart.pageobject.Successpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC012_RFkeyboardactiontest extends BaseClass {

	@Test(dataProvider = "Keyboardaction")
	public void registeringWithKeyboardActions(HashMap<String, String> hMap) throws InterruptedException {

		log.info("***** TC012_RFkeyboardactiontest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Register", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due to Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page: " + respg.getRegPageTitle());

		Successpage sucespg = respg.registrationWithKeyboardActions(hMap.get("FirstName"), hMap.get("LastName"),
				getRandomStringValue(4) + "@gmail.com", hMap.get("Telephone"), hMap.get("Password"),
				hMap.get("ConfirmPassword"));
		log.info("User Registration Completed By Keyboard Actions");
 
		Assert.assertEquals(sucespg.getSuccessPageTitle(), config.getSuccessPageTitle());
		log.info("User Logged Into AccountSuccess Page: " + sucespg.getSuccessPageTitle());

		Assert.assertTrue(sucespg.isDisplayedLogoutOption());
		log.info("Logout Option Displayed On MyAccount Drop Menu");

		Assert.assertTrue(sucespg.isDisplayedSuccessOnBedcrum());
		log.info("Success Link Displayed On Bedcrum");

		Assert.assertTrue(sucespg.isDisplayedSubAccountSuccessMsg());
		log.info("Account Success Message Displayed: " + sucespg.getSubAccountSuccessMsg());

		Accountpage accpg = sucespg.clickOnContinueButton();
		Assert.assertTrue(accpg.isDisplayedEditInfoLink());
		log.info("Edit your account information Link Displayed On WebPage");

		Assert.assertEquals(accpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("User Logged Into Account Page: " + accpg.getAccountPageTitle());

		Assert.assertTrue(accpg.isDisplayedAccountLinkOnBedcrum());
		log.info("Account Link Displayed On Bedcrum");

		log.info("***** TC012_RFkeyboardactiontest Completed *****");

	}

	@DataProvider(name = "Keyboardaction")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {

			String path = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(path);
			data = ReadXlsxFile.getTestData(xlsreader, "RegisterMndtryFld", "Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}
}
