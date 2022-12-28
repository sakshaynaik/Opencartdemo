package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Registerationpage;

public class TC004_RFwithoutdatatest extends BaseClass {

	@Test(groups = "Smoke") 
	public void registeringwithoutAnyDataInFields() {

		log.info("***** TC004_RFwithoutdatatest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page :" + respg.getRegPageTitle());

		respg.clickOnContinueButton();

		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User In Registration Page Due To Invaid Details");

		Assert.assertTrue(respg.isDisplayedWarnFirstNameMsg());
		log.info("First Name Warning Message Displayed: " + respg.getWarnFirstNameMsg());

		Assert.assertTrue(respg.isDisplayedWarnLastNameMsg());
		log.info("Last Name Warning Message Displayed: " + respg.getWarnLastNameMsg());

		Assert.assertTrue(respg.isDisplayedWarnEmailMsg());
		log.info("Email Warning Message Displayed: " + respg.getWarnEmailMsg());

		Assert.assertTrue(respg.isDisplayedWarnTelephonemsg());
		log.info("Telephone Warning Message Displayed: " + respg.getWarnTelephonemsg());

		Assert.assertTrue(respg.isDisplayedWarnPasswordMsg());
		log.info("Password Warning Message Displayed: " + respg.getWarnPasswordMsg());

		Assert.assertTrue(respg.isDisplayedWarnPriveryMsg());
		log.info("Privercy Policy Warning Message Displayed: " + respg.getWarnPriveryMsg());

		log.info("***** TC004_RFwithoutdatatest Completed *****");
	}

}
