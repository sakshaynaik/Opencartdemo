package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Specialofferspage;

public class TC148_SOgridandlistviewtest extends BaseClass{

	@Test
	public void specialOfferGridAndListView() {
		
		log.info("***** TC148_SOgridandlistviewtest Started *****");

		Homepage hmpg = new Homepage(driver);
		Specialofferspage spcialpg = hmpg.clickOnSpecialsLink();
		Assert.assertEquals(spcialpg.getSpecialOffersPageTitle(), config.getSpecialOffersPageTitle());
		log.info("Special Offers Page Title: " + spcialpg.getSpecialOffersPageTitle());
		
		spcialpg.clickOnGridView();
		spcialpg.clickOnListView();
		
		log.info("***** TC148_SOgridandlistviewtest Completed *****");

	}
}
