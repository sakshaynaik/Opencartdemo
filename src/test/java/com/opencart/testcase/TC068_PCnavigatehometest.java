package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Desktoppage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productcomparisionpage;

public class TC068_PCnavigatehometest extends BaseClass {

	@Test
	public void productCompareAndNavigateHomePage() {

		log.info("***** TC068_PCnavigatehometest Started *****");

		Homepage hmpg = new Homepage(driver);
		hmpg.hoverMouseOnDesktop();
		Desktoppage deskpg = hmpg.clickOnShowAllOptions();
		log.info("User Clicked On Show More Option Under Desktop");

		Assert.assertEquals(deskpg.getDeskTopPageTitle(), config.getDesktopsPageTitle());
		log.info("User Navigated To Product Comparision Page: " + deskpg.getDeskTopPageTitle());

		Productcomparisionpage prdcompg = deskpg.clickOnProductCompareLink_0();
		Assert.assertEquals(prdcompg.getProductComparePageTitle(), config.getCompareProductPageTitle());
		log.info("User Navigated To Product Compare Page: " + prdcompg.getProductComparePageTitle());

		prdcompg.clickOnContinueButton();
		Assert.assertEquals(hmpg.getHomePageTitle(), config.getHomePageTitle());
		log.info("User Navigated Back To Home Page: " + hmpg.getHomePageTitle());

		log.info("***** TC068_PCnavigatehometest Completed *****");
	}
}
