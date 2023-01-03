package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.PCpage;

public class TC095_HPnavigtetopctest extends BaseClass {

	@Test
	public void homePageNavigationToPc() {
		
		log.info("***** TC095_HMnavigtetopctest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.hoverMouseOnDesktop();
		PCpage pcpg = hmpg.clickOnPCLink();
		Assert.assertEquals(pcpg.getPCPageTitle(), config.getPCPageTitle());
		log.info("PC Page Title: " + pcpg.getPCPageTitle());

		pcpg.clickOnContinueButton();
		Assert.assertEquals(hmpg.getHomePageTitle(), hmpg.getHomePageTitle());
		log.info("Home Page Title: " + hmpg.getHomePageTitle());

		log.info("***** TC095_HMnavigtetopctest Completed *****");
	}
}
