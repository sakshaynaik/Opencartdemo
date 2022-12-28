package com.opencart.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.NewsletterSubscriptionpage;
import com.opencart.pageobject.Registerationpage;
import com.opencart.pageobject.Successpage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC005_RFnewsletterfieldtest extends BaseClass {

	@Test(dataProvider = "NewsLetterData")
	public void registeringWithNewsLetter(HashMap<String, String> hMap) {

		log.info("***** TC005_RFnewsletterfieldtest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Register", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Skipped Due To Runmode Set As N");
		}

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page: " + respg.getRegPageTitle());

		respg.enterFirstNameTextField(hMap.get("FirstName"));
		respg.enterLastNameTextField(hMap.get("LastName"));
		respg.enterEmialTextField(getRandomStringValue(5) + "@gmail.com");
		respg.enterTelephoneTextField(hMap.get("Telephone"));
		respg.enterPasswordTextField(hMap.get("Password"));
		respg.enterConfirmPasswordTextField(hMap.get("ConfirmPassword"));
		respg.clickOnNewsLetterRadioButton();
		respg.clickOnPriveryPolicyField();

		Successpage sucespg = respg.clickOnContinueButton();
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

		NewsletterSubscriptionpage nwspg = accpg.clickOnNewsLetterLink();
		Assert.assertEquals(nwspg.getNewsletterPageTitle(), config.getNewsletterPageTitle());
		log.info("Newsletter Subscription Page Dispalyed :" + nwspg.getNewsletterPageTitle());

		Assert.assertTrue(nwspg.isSelectedNewsletterRadioOption());
		log.info("YES Option Selected By Default In Newsletter Page");


		log.info("***** TC005_RFnewsletterfieldtest Completed *****");

	}

	@DataProvider(name = "NewsLetterData")
	public Object[][] datasuppiler() {

		Object[][] data = null;

		try {
			String filepath = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(filepath);
			data = ReadXlsxFile.getTestData(xlsreader, "RegisterMndtryFld", "Data");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return data;
	}

}
