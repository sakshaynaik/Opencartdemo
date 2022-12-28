package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Registerationpage;

public class TC013_RFplaceholdertest extends BaseClass {

	@Test
	public void resgistringtestForPlaceholder() {

		log.info("***** TC013_RFplaceholdertest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page: " + respg.getRegPageTitle());

		Assert.assertEquals("First Name", respg.getAttributeForFirstNamePlaceholder("placeholder"));
		log.info("Place Holder For First Name Found :" + respg.getAttributeForFirstNamePlaceholder("placeholder"));

		log.info("***** TC013_RFplaceholdertest Completed *****");

	}

}
