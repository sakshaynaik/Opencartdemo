package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Registerationpage;
import com.opencart.pageobject.Transactionhistorypage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC133_THdetailspresenttest extends BaseClass{

	@Test(dataProvider = "existdata")
	public void transactionHistoryPageNavigationBeforeLogin(HashMap<String, String> hMap) {

		log.info("***** TC133_THdetailspresenttest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Transactionhistory", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Method Skipped Due To Run Mode Set To N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed On MyAccount Drop Menu");

		 Registerationpage regpg = hmpg.clickOnRegisterLink();
		log.info("Clicked On Register Option From MyAccount Drop Menu");

		Assert.assertEquals(regpg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("Navigated To Registration Page: " + regpg.getRegPageTitle());
		
		Transactionhistorypage transactpg = regpg.clickOnTransactionLink();
		
        Loginpage loginpg = new Loginpage(driver);
		loginpg.enterRegisteredEmail(hMap.get("Email"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		Accountpage accntpg = loginpg.clickLoginButton();
	
		Assert.assertEquals(transactpg.getTransactionHistoryPageTitle(), config.getTransactionHistoryPageTitle());
		log.info("Transaction History Page Title: " + transactpg.getTransactionHistoryPageTitle());
		
		Assert.assertTrue(transactpg.isDisplayedBalanceInTHpage());
		log.info("Get Current Balance Text On Transactions Page: " + transactpg.getBalanceInTHpage());
		
		transactpg.clickOnContinueButton();
		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		accntpg.clickOnTransactionLink();
		Assert.assertEquals(transactpg.getTransactionHistoryPageTitle(), config.getTransactionHistoryPageTitle());
		log.info("Transaction History Page Title: " + transactpg.getTransactionHistoryPageTitle());

		log.info("***** TC133_THdetailspresenttest Completed *****");

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
