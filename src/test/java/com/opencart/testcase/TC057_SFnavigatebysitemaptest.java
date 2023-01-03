package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Searchpage;
import com.opencart.pageobject.Sitemappage;

public class TC057_SFnavigatebysitemaptest extends BaseClass {

	@Test
	public void SearchByNavigatigThroughSiteMap() {

		Homepage hmpg = new Homepage(driver);
		Sitemappage sitemappage = hmpg.clickOnSiteMap();
		Assert.assertEquals(sitemappage.getSiteMapPageTitle(), config.getSiteMapPageTitle());
		log.info("User Navigated To SiteMap Page: " + sitemappage.getSiteMapPageTitle());
		
		Searchpage srchpg = sitemappage.clickOnSearchLink();
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());
		
		Assert.assertTrue(srchpg.isDispalyedSearchNoProductMsg());
		log.info("User Searched Product Was Not Displayed On SearchPage: " + srchpg.getSearchNoProductMsg());

	}
}
