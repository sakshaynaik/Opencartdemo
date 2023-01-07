package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Contactuspage;
import com.opencart.pageobject.Homepage;

public class TC141_CUnavigatepagetest extends BaseClass {

	@Test
	public void contactUsNavigationPage() {

		Homepage hmpg = new Homepage(driver);
		Contactuspage contactpg = hmpg.clickOnTelephoneOption();
		Assert.assertEquals(contactpg.getContactUsPageTitle(), config.getContactUsPageTitle());
		log.info("Contact Us Page Title: " + contactpg.getContactUsPageTitle());

		contactpg.navigateToBackPage();
		hmpg.clickOnContactUsLink();
		Assert.assertEquals(contactpg.getContactUsPageTitle(), config.getContactUsPageTitle());
		log.info("Contact Us Page Title: " + contactpg.getContactUsPageTitle());

		Assert.assertTrue(contactpg.isDisplayedContactUsPanelBody());
		log.info("Content Present In ContactUs Pannel Body: " + contactpg.getContactUsPanelBody());

	}
}
