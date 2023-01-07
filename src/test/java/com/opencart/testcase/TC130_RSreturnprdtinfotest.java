package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Accountpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Productreturnpage;
import com.opencart.pageobject.Returninformationpage;

public class TC130_RSreturnprdtinfotest extends BaseClass{

	@Test(dataProvider = "validcredentials")
	public void returnsProductsDetails(String validdata) {

		log.info("***** TC130_RSreturnprdtinfotest Started *****");

		String[] data = validdata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(data[1]);
		loginpg.enterRegisteredPassword(data[2]);
		Accountpage accntpg = loginpg.clickLoginButton();
		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		Assert.assertTrue(accntpg.isDisplayedEditInfoLink());
		log.info("Edit Info Link Displayed On Accounts Page");

		Productreturnpage prdtretnpg = accntpg.clickOnViewYourReturnRequestLink();
		Assert.assertEquals(prdtretnpg.getProductReturnPageTitle(), config.getProductReturnPageTitle());
		log.info("Product Return Page Title: " + prdtretnpg.getProductReturnPageTitle());
		
		Returninformationpage retuninfopg = prdtretnpg.clickOnFirstViewReturnProduct();
		Assert.assertEquals(retuninfopg.getReturnInformationPageTitle(), config.getReturnInformationPageTitle());
		log.info("Product Return Information Page Title: " + retuninfopg.getReturnInformationPageTitle());

		Assert.assertTrue(retuninfopg.isDisplayedReturnDetailsForProduct());
		log.info("Product Return Details: " + retuninfopg.getReturnDetailsForProduct());

		Assert.assertTrue(retuninfopg.isDisplayedProductInfoOfReturn());
		log.info("Product Information Details: " + retuninfopg.getProductInfoOfReturn());

		Assert.assertTrue(retuninfopg.isDisplayedReturnReasonForProduct());
		log.info("Product Return Reason Details: " + retuninfopg.getReturnReasonForProduct());

		Assert.assertTrue(retuninfopg.isDisplayedReturnHistoryForProduct());
		log.info("Product Return History Details: " + retuninfopg.getReturnHistoryForProduct());

		prdtretnpg.clickOnContinueButton();
		Assert.assertEquals(prdtretnpg.getProductReturnPageTitle(), config.getProductReturnPageTitle());
		log.info("Product Return Page Title: " + prdtretnpg.getProductReturnPageTitle());
		
		prdtretnpg.clickOnContinueButton();
		Assert.assertEquals(accntpg.getAccountPageTitle(), config.getAccountPageTitle());
		log.info("Acconts Page Title: " + accntpg.getAccountPageTitle());

		log.info("***** TC130_RSreturnprdtinfotest Completed *****");

	}

	@DataProvider(name = "validcredentials")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//returns.json";
			FileReader reader = new FileReader(filepath);
			object = parser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("logincredentials");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object brows = data.get("Browser");
			Object email = data.get("email");
			Object passw = data.get("password");
			Object prdna = data.get("productname");

			arr[i] = brows + "," + email + "," + passw + "," + prdna;
		}
		return arr;

	}
}
