package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;

public class TC027_LFloginplaceholdertest extends BaseClass {

	@Test
	public void logintestForPlacholder() {

		log.info("***** TC027_LFloginplaceholdertest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		Assert.assertTrue(loginpg.getAttributeOfEmailField("placeholder") != null);
		log.info("Placeholder For Email-Address Text Field: " + loginpg.getAttributeOfEmailField("placeholder"));

		Assert.assertTrue(loginpg.getAttributeOfPasswordField("placeholder") != null);
		log.info("Placeholder For Password Text Field: " + loginpg.getAttributeOfPasswordField("placeholder"));

		log.info("***** TC027_LFloginplaceholdertest Completed *****");

	}
}
