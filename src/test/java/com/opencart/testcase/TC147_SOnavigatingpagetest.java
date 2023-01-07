package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Sitemappage;
import com.opencart.pageobject.Specialofferspage;

public class TC147_SOnavigatingpagetest extends BaseClass {

	@Test
	public void specialOfferNavigatingToPage() {

		log.info("***** TC147_SPnavigatingpagetest Started *****");

		Homepage hmpg = new Homepage(driver);
		Specialofferspage spcialpg = hmpg.clickOnSpecialsLink();
		Assert.assertEquals(spcialpg.getSpecialOffersPageTitle(), config.getSpecialOffersPageTitle());
		log.info("Special Offers Page Title: " + spcialpg.getSpecialOffersPageTitle());

		Sitemappage sitemappg = hmpg.clickOnSiteMap();
		Assert.assertEquals(sitemappg.getSiteMapPageTitle(), config.getSiteMapPageTitle());
		log.info("Site Map Page Title: " + sitemappg.getSiteMapPageTitle());

		sitemappg.clickOnSpecialOffersLink();
		Assert.assertEquals(spcialpg.getSpecialOffersPageTitle(), config.getSpecialOffersPageTitle());
		log.info("Special Offers Page Title: " + spcialpg.getSpecialOffersPageTitle());

		log.info("***** TC147_SPnavigatingpagetest Completed *****");

	}
}
