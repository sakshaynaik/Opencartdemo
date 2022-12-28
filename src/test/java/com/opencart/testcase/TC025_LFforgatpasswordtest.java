package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Forgotyourpasswordpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;

public class TC025_LFforgatpasswordtest extends BaseClass {

	@Test
	public void logintestForForgottenPassword() {

		log.info("***** TC025_LFforgatpasswordtest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("User Navigated To Login Page: " + loginpg.getLoginPageTitle());

		Forgotyourpasswordpage forgtpg = loginpg.clickOnForgotPasswordLink();
		log.info("User Clicked On Forgotten Password Link");

		Assert.assertEquals(forgtpg.getForgotPasswordPageTitle(), config.getForgotPasswrdPageTitle());
		log.info("User Navigated To Forgotten Password Page: " + forgtpg.getForgotPasswordPageTitle());

		Assert.assertTrue(forgtpg.isDisplayedForgottenPassOnBedcrum());
		log.info("Forgotten Password Link Displayed on Bedcrum");

		Assert.assertTrue(forgtpg.isDisplayedForgetMsgContent());
		log.info("Forgotten Password Content Displayed On Page: " + forgtpg.getForgetMsgContent());

		log.info("***** TC025_LFforgatpasswordtest Completed *****");
	}
}
