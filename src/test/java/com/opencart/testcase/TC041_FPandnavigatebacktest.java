package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Forgotyourpasswordpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;

public class TC041_FPandnavigatebacktest extends BaseClass {

	@Test
	public void forgotPasswordAndNavigatingBack() {

		log.info("***** TC041_FPandnavigatebacktest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		Forgotyourpasswordpage frgtpasspg = loginpg.clickOnForgotPasswordLink();
		Assert.assertEquals(frgtpasspg.getForgotPasswordPageTitle(), config.getForgotPasswrdPageTitle());
		log.info("User Navigated To Forgot Password Page: " + frgtpasspg.getForgotPasswordPageTitle());

		Assert.assertTrue(frgtpasspg.isDisplayedForgetMsgContent());
		log.info("Forgot Password Message Content On Forgot Page: " + frgtpasspg.getForgetMsgContent());

		loginpg.navigateBack();
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("User Navigated Back From Forgot Password Page To Login Page :" + loginpg.getLoginPageTitle());

		log.info("***** TC041_FPandnavigatebacktest Completed *****");

	}
}
