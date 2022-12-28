package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Registerationpage;

public class TC019_RFrandomactivitytest extends BaseClass {

	@Test(groups = "Smoke")
	public void registrationRandomActivity() {

		log.info("***** TC019_RFrandomactivitytest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedRegisterOption());
		log.info("Register Option Displayed In MyAccount Drop Menu");

		Registerationpage respg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(respg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("User Logged Into Registration Page: " + respg.getRegPageTitle());

		int randomnum = getRandomIntValue(respg.getSizeListGroup());
		Loginpage loginpg = respg.clickOnRandomListGroup(randomnum);
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("By Clicking On Random GroupLink On Register Page User Navigated To Loginpage: "
				+ loginpg.getLoginPageTitle());

		log.info("***** TC019_RFrandomactivitytest Completed *****");

	}
}
