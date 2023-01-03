package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Shoppingcartpage;

public class TC097_COnavigatecohederoptiontest extends BaseClass {

	@Test
	public void checkOutByHomePageHeaderOption() {

		Homepage hmpg = new Homepage(driver);
		Shoppingcartpage shopcart = hmpg.clickOnCheckoutHeaderOption();
		Assert.assertEquals(shopcart.getShoppingCartPageTitle(), config.getShoppingCartPageTitle());
		log.info("ShopCart Page Title: " + shopcart.getShoppingCartPageTitle());

		Assert.assertTrue(shopcart.isDisplayedShopcartEmptyMsg());
		log.info("Shopping Cart Empty Message: " + shopcart.getShopcartEmptyMsg());

		shopcart.clickOnContinueButton();
		Assert.assertEquals(hmpg.getHomePageTitle(), config.getHomePageTitle());
		log.info("User Navigated Back To Homepage: " + hmpg.getHomePageTitle());
	}
}
