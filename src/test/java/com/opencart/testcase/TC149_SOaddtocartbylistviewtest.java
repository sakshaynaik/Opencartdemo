package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Specialofferspage;

public class TC149_SOaddtocartbylistviewtest extends BaseClass {

	@Test
	public void specialOfferAddToCartByListView() {

		log.info("***** TC149_SOaddtocartbylistviewtest Started *****");

		Homepage hmpg = new Homepage(driver);
		Specialofferspage spcialpg = hmpg.clickOnSpecialsLink();
		Assert.assertEquals(spcialpg.getSpecialOffersPageTitle(), config.getSpecialOffersPageTitle());
		log.info("Special Offers Page Title: " + spcialpg.getSpecialOffersPageTitle());

		spcialpg.clickOnListView();
		Productpage prdtpg = spcialpg.clickOnAddToCartButton();
		log.info("Product Page Title: " + prdtpg.getProductPageTitle());

		prdtpg.navigateToBackPage();
		spcialpg.clickOnAddToWishListButton();
		Assert.assertTrue(spcialpg.isDisplayedWishListMessage());
		log.info("Wishlist Message Displayed On WebPage: " + spcialpg.getWishListMessage());
		
		spcialpg.clickOnCompareThisProductButton();
		Assert.assertTrue(spcialpg.isDisplayedCompareProductMessage());
		log.info("Compare This Product Message Displayed On WebPage: " + spcialpg.getCompareProductMessage());
		
		log.info("***** TC149_SOaddtocartbylistviewtest Completed *****");

	}
}
