package com.opencart.testcase;

import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;

public class TC151_HMFrandomactivitytest extends BaseClass {

	@Test
	public void headerMenuRandomActivity() {

		log.info("***** TC151_HMFrandomactivitytest Started *****");

		Homepage hmpg = new Homepage(driver);

		hmpg.clickOnRandomTopHeaderLink();
		log.info("Randomly Top Header Links Were Clicked And Passed ");
		
		hmpg.clickOnRandomHeaderNavigationBarLink();
		log.info("Randomly Top Navigation Links Were Clicked And Passed ");    
		
		log.info("***** TC151_HMFrandomactivitytest Completed *****");
	}
}
