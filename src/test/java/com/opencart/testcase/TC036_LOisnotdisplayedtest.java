package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;

public class TC036_LOisnotdisplayedtest extends BaseClass {

	@Test
	public void checkLogoutIsDisplayedBeforeLogin() {

		log.info("***** TC036_LOisnotdisplayedtest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Logout Option Is Not Displayed On MyAccount Drop Menu Before LoggingIn");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Logout Option Is Not Displayed On Right Column Before LoggingIn");

		log.info("***** TC036_LOisnotdisplayedtest Completed *****");
	}
}
