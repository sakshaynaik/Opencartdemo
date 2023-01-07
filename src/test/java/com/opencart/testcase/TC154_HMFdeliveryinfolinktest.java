package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;

public class TC154_HMFdeliveryinfolinktest extends BaseClass {

	@Test
	public void headerMenuAndFooterDeliveryInfoLinkTest() {

		log.info("***** TC154_HMFdeliveryinfolinktest Started *****");

		Homepage hmpg = new Homepage(driver);

		hmpg.clickOnDeliveryInfoLink();
		log.info("Delivery Info Page Title: " + hmpg.getPageTitle());

		Assert.fail("Page Text Is Not Displayed In The Page");

		log.info("***** TC154_HMFdeliveryinfolinktest Completed *****");

	}
}
