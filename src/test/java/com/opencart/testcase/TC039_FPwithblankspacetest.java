package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Forgotyourpasswordpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;

public class TC039_FPwithblankspacetest extends BaseClass{

	@Test
	public void forgotPasswordWithBlankEmailTextField() {
		
		log.info("***** TC038_FPresetpaswrdunregistrdtest Completed *****");
	
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

		frgtpasspg.enterEmailOfForgotenPassword("");
		frgtpasspg.clickOnContinueButton();
		log.info("User Entered Non Registered Emailaddress In Emailaddress Field");

		Assert.assertTrue(frgtpasspg.isDisplayedWarnForUnregisteredEmail());
		log.info("Warning Message For Blank Space Email text Field: " + frgtpasspg.getWarnForUnregisteredEmail());         

		log.info("***** TC038_FPresetpaswrdunregistrdtest Completed *****");

	}
}
