package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;

public class TC153_HMFprivercypolicylinktest extends BaseClass {

	@Test
	public void headerMenuAndFooterPrivercyPolicyLinkTest() {

		log.info("***** TC153_HMFprivercypolicylinktest Started *****");

		Homepage hmpg = new Homepage(driver);

		hmpg.clickOnPrivercyAndPolicyLinkLink();
		log.info("Privercy And Policy Page Title: " + hmpg.getPageTitle());

		Assert.fail("Page Text Is Not Displayed In The Page");

		log.info("***** TC153_HMFprivercypolicylinktest Completed *****");
	}

}
