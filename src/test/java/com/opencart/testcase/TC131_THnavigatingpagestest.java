package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Transactionhistorypage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC131_THnavigatingpagestest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void transcationHistoryPageNavigation(HashMap<String, String> hMap) {

		log.info("***** TC131_THnavigatingpagestest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Transactionhistory", "Testcases") || hMap.get("Runmode").equals("N")) {

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

		Transactionhistorypage transactpg = accntpg.clickOnYourTransactionLink();
		Assert.assertEquals(transactpg.getTransactionHistoryPageTitle(), config.getTransactionHistoryPageTitle());
		log.info("Transaction History Page Title: " + transactpg.getTransactionHistoryPageTitle());

		transactpg.clickOnContinueButton();
		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		accntpg.clickOnTransactionLink();
		Assert.assertEquals(transactpg.getTransactionHistoryPageTitle(), config.getTransactionHistoryPageTitle());
		log.info("Transaction History Page Title: " + transactpg.getTransactionHistoryPageTitle());

		log.info("***** TC131_THnavigatingpagestest Completed *****");

	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "returnprdtcredent", "transactionhistry");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
