package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Recurringpaymentpage;
import com.opencart.pageobject.Registerationpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC135_RPbeforelogintest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void recurringPaymentPageNavigation(HashMap<String, String> hMap) {

		log.info("***** TC135_RPbeforelogintest Started *****");

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

		Recurringpaymentpage reccrpg = regpg.clickOnRecurringPaymentLinkOnLeftSide();

		Loginpage loginpg = new Loginpage(driver);
		loginpg.enterRegisteredEmail(hMap.get("Email"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		Accountpage accntpg = loginpg.clickLoginButton();
		Assert.assertEquals(reccrpg.getRecurrigPaymentPageTitle(), config.getRecurringPaymentPageTitle());
		log.info("Recurringpayment Page Title: " + reccrpg.getRecurrigPaymentPageTitle());
		
		Assert.assertTrue(reccrpg.isDisplayedRecurringPaymentMsg());
		log.info("Recurringpayment Message Displayed On Webpage: " + reccrpg.getRecurringPaymentMsg());

		reccrpg.clickOnContinueButton();
		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		accntpg.clickOnRecurringPaymentLinkOnLeftSide();
		Assert.assertEquals(reccrpg.getRecurrigPaymentPageTitle(), config.getRecurringPaymentPageTitle());
		log.info("Recurringpayment Page Title: " + reccrpg.getRecurrigPaymentPageTitle());

		log.info("***** TC135_RPbeforelogintest Completed *****");

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
