package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productcomparisionpage;

public class TC065_PCfromhomepagetest extends BaseClass {

	@Test
	public void productCompareFromHomePage() {

		log.info("***** TC065_PCfromhomepagetest Started *****");

		Homepage hmpg = new Homepage(driver);
		Assert.assertTrue(hmpg.getAttributeCompareProductButton("data-original-title") != null);
		log.info("When Hovered Mouse On Compare Product Option The Text Displayed: "
				+ hmpg.getAttributeCompareProductButton("data-original-title"));

		hmpg.clickOnCompareProductButton();
		Assert.assertTrue(hmpg.isDisplayedMessageForCompareProduct());
		log.info("Success Product Compare Message Displayed: " + hmpg.getTextMessageForCompareProduct());

		Productcomparisionpage prdcompage = hmpg.clickOnProductCompareLink();
		Assert.assertTrue(prdcompage.isDisplayedLinkForProductInProductComaprePage());
		Assert.assertTrue(prdcompage.isDisplayedWhishlistButtonInProductComaprePage());
		Assert.assertTrue(prdcompage.isDisplayedRemoveButtonInProductComaprePage());
		log.info("Product Added To Product Compare Page Was Displayed: "
				+ prdcompage.getTextForProductInProductComaprePage() + "  "
				+ prdcompage.getTextRemoveButtonProductComaprePage());

		log.info("***** TC065_PCfromhomepagetest Started *****");

	}
}
