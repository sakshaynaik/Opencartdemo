package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Registerationpage;

public class TC032_LFrandomactivitytest extends BaseClass {

	@Test
	public void loginForRandomActivity() throws InterruptedException {

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		Registerationpage regpg = loginpg.clickOnNewCustomerContinueButton();
		log.info("User Clicked On New Customer Button And Navigated To Registration Page: " + regpg.getRegPageTitle());

		regpg.navigateBack();
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("User Navigated From Registration Page To Login Page: " + loginpg.getLoginPageTitle());

		int listgrp = getRandomIntValue(loginpg.getSizeOfListGroupsOption());
		loginpg.clickOnRandomListGroupOption(listgrp);
		loginpg.navigateBack();
		log.info("User Navigated From Random ListGroup Option To Login Page: " + loginpg.getLoginPageTitle());

		int navpulr = getRandomIntValue(loginpg.getSizeOfNavPulRight());
		loginpg.clickOnRandomNavPulRight(navpulr);
		loginpg.navigateBack();
		log.info(
				"User Navigated From Random Navigation Pul Right Option To Login Page: " + loginpg.getLoginPageTitle());

		int bedcrum = getRandomIntValue(loginpg.getSizeOfBedcrumOption());
		loginpg.clickOnRandomBedcrumOption(bedcrum);
		loginpg.navigateBack();
		log.info("User Navigated From Random Bedcrum Option To Login Page: " + loginpg.getLoginPageTitle());

		int navibar = getRandomIntValue(loginpg.getSizeOfNavigationBarOption());
		loginpg.clickOnRandomNavigationOption(navibar);
		loginpg.navigateBack();
		log.info("User Navigated From Random NavigationBar Option To Login Page: " + loginpg.getLoginPageTitle());

		int footer = getRandomIntValue(loginpg.getSizeOfFooterOption());
		loginpg.clickOnRandomFooterOption(footer);
		loginpg.navigateBack();
		log.info("User Navigated From Random Footer Option To Login Page: " + loginpg.getLoginPageTitle());

	}
}
