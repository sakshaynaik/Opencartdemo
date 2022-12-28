package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Registerationpage;

public class TC016_RFprivercypolicytest extends BaseClass {

	@Test
	public void registartiontestForPrivercyPolicy() {

		log.info("***** TC016_RFprivercypolicytest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page: " + respg.getRegPageTitle());

		Assert.assertFalse(respg.isSelectedForPrivercyPolicy());
		log.info("Privercy Policy Not Is Not Selected By Default");

	}
}
