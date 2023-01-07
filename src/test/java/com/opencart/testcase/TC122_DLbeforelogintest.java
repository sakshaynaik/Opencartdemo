package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Downloadspage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Registerationpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC122_DLbeforelogintest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void downloadsBeforeLogin(HashMap<String, String> hMap) {

		log.info("***** TC122_DLbeforelogintest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Downloads", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed On MyAccount Drop Menu");

		Registerationpage regpg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(regpg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("Registration Page Title: " + regpg.getRegPageTitle());

		regpg.clickOnDownloadsLink();
		Loginpage loginpg = new Loginpage(driver);
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(hMap.get("Email"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		loginpg.clickLoginButton();

		Downloadspage downloadpg = new Downloadspage(driver);
		Assert.assertEquals(downloadpg.getDownloadsPageTitle(), config.getDownloadsPageTitle());
		log.info("Downloads Page Title: " + downloadpg.getDownloadsPageTitle());

		log.info("***** TC122_DLbeforelogintest Completed *****");
	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "validcredentials", "downloads");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
