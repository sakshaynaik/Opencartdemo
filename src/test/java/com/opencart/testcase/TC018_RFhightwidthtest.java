package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Registerationpage;

public class TC018_RFhightwidthtest extends BaseClass {

	@Test
	public void registrationTextfieldsize() {

		log.info("***** TC018_RFheightwidthtest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page: " + respg.getRegPageTitle());

		Assert.assertEquals(34, respg.getHeigthOfEmailField());
		log.info("Height Of The Email Text field: " + respg.getHeigthOfEmailField());

		Assert.assertEquals(701, respg.getWidthOfEmailField());
		log.info("Height Of The Email Text field: " + respg.getWidthOfEmailField());

		Assert.assertEquals(250, respg.getXCordinateOfPasswordField());
		log.info("X Cordinate Of The Password Text field: " + respg.getXCordinateOfPasswordField());

		Assert.assertEquals(652, respg.getYCordinateOfPasswordField());
		log.info("X Cordinate Of The Password Text field: " + respg.getYCordinateOfPasswordField());

		log.info("***** TC018_RFheightwidthtest Completed *****");

	}
}
