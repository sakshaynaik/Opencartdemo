package com.opencart.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Searchpage;

public class TC048_SFplaceholdertest extends BaseClass {

	@Test
	public void searchTextFieldPlaceholder() {

		log.info("***** TC048_SFplaceholdertest Started *****");

		Homepage hmpg = new Homepage(driver);
		Assert.assertTrue(hmpg.getAttributeForSearchField("placeholder") != null);
		log.info("Homepage Search Text Field Placehoder: " + hmpg.getAttributeForSearchField("placeholder"));
		Searchpage srchpg = hmpg.clickOnSearchButton();

		Assert.assertTrue(srchpg.getAttributeOfSearchCriteria("placeholder") != null);
		log.info("Searchpage Search criteria Field Placehoder: " + srchpg.getAttributeOfSearchCriteria("placeholder"));

		log.info("***** TC048_SFplaceholdertest Completed *****");

	}
}
