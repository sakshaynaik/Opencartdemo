package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;

public class TC155_HMFtermconditiontest extends BaseClass{

	@Test
	public void headerMenuAndFooterTermsAndConditionLinkTest() {

		log.info("***** TC155_HMFtermconditiontest Started *****");

		Homepage hmpg = new Homepage(driver);

		hmpg.clickOnTermsAndConditionLink();
		log.info("Terms And Condition Page Title: " + hmpg.getPageTitle());

		Assert.fail("Page Text Is Not Displayed In The Page");

		log.info("***** TC155_HMFtermconditiontest Completed *****");

	}
}
