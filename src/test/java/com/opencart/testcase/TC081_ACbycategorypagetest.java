package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Desktoppage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Shoppingcartpage;

public class TC081_ACbycategorypagetest extends BaseClass {

	@Test
	public void addToCartBySubCategoryPage() {

		log.info("***** TC081_ACbycategorypagetest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.hoverMouseOnDesktop();
		Desktoppage deskpg = hmpg.clickOnShowAllOptions();
		log.info("User Clicked On Show More Option Under Desktop");

		Assert.assertEquals(deskpg.getDeskTopPageTitle(), config.getDesktopsPageTitle());
		log.info("DeskTop Page Title: " + deskpg.getDeskTopPageTitle());

		Productpage prdtpg = deskpg.clickOnSubiMacLink();
		log.info("Product Page Title: " + prdtpg.getProductPageTitle());

		Assert.assertTrue(prdtpg.isDisplayedImgInMacPage());
		log.info("iMac Displayed On Mac Page");

		prdtpg.clickOnImgInMacPage();
		prdtpg.clickOnAddToCartButton();
		Assert.assertTrue(prdtpg.isDispalyedOfWhishlistMsg());
		log.info("Success Added To Wish-List Message Displayed: " + prdtpg.getTexOfWhishlistMsg());

		Shoppingcartpage shopcart = prdtpg.clickOnShopCartMsgLink();
		Assert.assertEquals(shopcart.getShoppingCartPageTitle(), config.getShoppingCartPageTitle());
		log.info("ShopCart Page Title: " + shopcart.getShoppingCartPageTitle());

		Assert.assertTrue(shopcart.isDisplayediMacLink());
		log.info("Success Added Product To Shopping cart Page");

		log.info("***** TC081_ACbycategorypagetest Completed *****");

	}
}
