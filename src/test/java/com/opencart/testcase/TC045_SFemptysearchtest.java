package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Searchpage;

public class TC045_SFemptysearchtest extends BaseClass {

	@Test
	public void SearchWithEmptyTextField() {

		log.info("***** TC045_SFemptysearchtest Started *****");

		Homepage hmpg = new Homepage(driver);
		Searchpage srchpg = hmpg.clickOnSearchButton();

		Assert.assertTrue(srchpg.isDispalyedSearchNoProductMsg());
		log.info("User Searched Product Was Not Displayed On SearchPage: " + srchpg.getSearchNoProductMsg());

		log.info("***** TC045_SFemptysearchtest Completed *****");

	}
}
