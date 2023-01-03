package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;

public class TC083_WLnavigatingtowishlisttest extends BaseClass {

	@Test
	public void wishListPageNavigatingWithDifferentLinks() {

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnWishlistHeaderLink();
		log.info("User Clicked On Wishlist Header Link");

		Loginpage lognpg = new Loginpage(driver);
		Assert.assertEquals(lognpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("User Was Directed To Accounts Page For Logging In And Was Not Navigated To Whishlist Page");

	}
}
