package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Desktoppage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productcomparisionpage;

public class TC063_PCsubcatgrygridtest extends BaseClass{

	@Test
	public void productCompareBySubCategoryGridView() {

		log.info("***** TC063_PCsubcatgrygridtest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.hoverMouseOnDesktop();
		Desktoppage deskpg = hmpg.clickOnShowAllOptions();
		log.info("User Clicked On Show More Option Under Desktop");

		Assert.assertEquals(deskpg.getDeskTopPageTitle(), config.getDesktopsPageTitle());
		log.info("User Navigated To Product Comparision Page: " + deskpg.getDeskTopPageTitle());

		deskpg.clickOnGridView();
		Assert.assertTrue(deskpg.getAttributeForCompareListButton("data-original-title") != null);
		log.info("Tool Tip For The Compare Product Button: "
				+ deskpg.getAttributeForCompareListButton("data-original-title"));

		deskpg.clickOnCompareListButton();
		Assert.assertTrue(deskpg.isDisplayedMessageForCompareProduct());
		log.info("Test Message For Compare Products Dispalyed: " + deskpg.getTextMessageForCompareProduct());
		
		Productcomparisionpage prdtcompare = deskpg.clickOnProductComapreLink();
		Assert.assertEquals(prdtcompare.getProductComparePageTitle(), config.getCompareProductPageTitle());
		log.info("User Navigated To Product Comparision Page: " + prdtcompare.getProductComparePageTitle());

		Assert.assertTrue(prdtcompare.isDisplayedHpLp3065());
		Assert.assertTrue(prdtcompare.isDisplayedAddToCartHpLp());
		Assert.assertTrue(prdtcompare.isDisplayedRemoveButton());
		log.info(
				"All The Details Of Product Were Displayed On ProductCompare Page: " + prdtcompare.getTextHpLp3065()
						+ "   " + prdtcompare.getTextAddToCartHpLp() + " " + prdtcompare.getTextRemoveButton());

		log.info("***** TC063_PCsubcatgrygridtest Completed *****");
	}
}
