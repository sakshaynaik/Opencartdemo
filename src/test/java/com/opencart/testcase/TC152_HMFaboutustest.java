package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;

public class TC152_HMFaboutustest extends BaseClass{

	@Test
	public void headerMenuAndFooterAboutUsLinkTest() {
		
		log.info("***** TC151_HMFrandomactivitytest Started *****");

		Homepage hmpg = new Homepage(driver);
		
		hmpg.clickOnAboutUsLink();
		log.info("About Us Page Title: " + hmpg.getPageTitle());
		
		Assert.fail("Page Text Is Not Displayed In The Page");
		
		log.info("***** TC153_HMFprivercypolicylinktest Completed *****");
	}
}
