package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.NewsletterSubscriptionpage;
import com.opencart.pageobject.Registerationpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC138_NLbeforelogintest extends BaseClass {

	@Test(dataProvider = "existdata")
	public void newsLetterBeforeLogin(HashMap<String, String> hMap) {

		log.info("***** TC138_NLbeforelogintest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Newsletter", "Testcases") || hMap.get("Runmode").equals("N")) {

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

		NewsletterSubscriptionpage newlettrpg = regpg.clickOnNewsLetterLinkRightOption();

		Loginpage loginpg = new Loginpage(driver);
		loginpg.enterRegisteredEmail(hMap.get("Email"));
		loginpg.enterRegisteredPassword(hMap.get("Password"));
		Accountpage accntpg = loginpg.clickLoginButton();
		Assert.assertEquals(newlettrpg.getNewsletterPageTitle(), config.getNewsletterPageTitle());
		log.info("NewsLetter Page Title: " + newlettrpg.getNewsletterPageTitle());

		newlettrpg.clickOnContinueButton();
		Assert.assertTrue(accntpg.isDisplayedNewsLetterSuccessMsg());
		log.info("NewsLetter Success Message: " + accntpg.getNewsLetterSuccessMsg());

		accntpg.clickOnNewsLetterLink();
		Assert.assertEquals(newlettrpg.getNewsletterPageTitle(), config.getNewsletterPageTitle());
		log.info("NewsLetter Page Title: " + newlettrpg.getNewsletterPageTitle());

		log.info("***** TC138_NLbeforelogintest Completed *****");

	}

	@DataProvider(name = "existdata")
	public Object[][] dataSupplier() {

		Object[][] data = null;
		try {
			String file = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(file);
			data = ReadXlsxFile.getTestData(xlsreader, "returnprdtcredent", "newsletter");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
