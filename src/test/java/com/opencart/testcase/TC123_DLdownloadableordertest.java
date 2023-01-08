package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Downloadspage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC123_DLdownloadableordertest extends BaseClass{

	@Test(dataProvider = "existdata")
	public void downloadValidateDownloadableOrders(HashMap<String, String> hMap) {
		
		log.info("***** TC123_DLdownloadableordertest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Downloads", "Testcases") || hMap.get("Runmode").equals("N")) {

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

		loginpg.enterRegisteredEmail(hMap.get("Email"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		Accountpage accntpg = loginpg.clickLoginButton();
		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		Assert.assertTrue(accntpg.isDisplayedEditInfoLink());
		log.info("Edit Info Link Displayed On Accounts Page");
		
		Downloadspage downloadpg = accntpg.clickOnDownloadsLink();
		Assert.assertEquals(downloadpg.getDownloadsPageTitle(), config.getDownloadsPageTitle());
		log.info("Downloads Page Title: " + downloadpg.getDownloadsPageTitle());
		
		Assert.fail("There Are No Products In The Website To Place The Downloadable Orders And Hence Cannot Test");
		
		log.info("***** TC123_DLdownloadableordertest Completed *****");
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
