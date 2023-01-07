package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;
import com.opencart.pageobject.Orderhistorypage;
import com.opencart.pageobject.Orderinformationpage;
import com.opencart.pageobject.Registerationpage;

public class TC112_OHbeforelogintest extends BaseClass{

	@Test(dataProvider = "validcredentials")
	public void orderHistoryNavigatingBeforeLogin(String validdata) {
		
		log.info("***** TC112_OHbeforelogintest Started *****");

		String[] data = validdata.split(",");
		
		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		log.info("Clicked On MyAccount Drop Menu");

		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Registerationpage regpg = hmpg.clickOnRegisterLink();
		Assert.assertEquals(regpg.getRegPageTitle(), config.getRegisterationPageTitle());
		log.info("Registration Page Title: " + regpg.getRegPageTitle());

	    regpg.clickOnOrderHistoryLink();
		Loginpage loginpg = new Loginpage(driver);
		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Login Page Title: " + loginpg.getLoginPageTitle());

		loginpg.enterRegisteredEmail(data[1]);
		loginpg.enterRegisteredPassword(data[2]);
		loginpg.clickLoginButton();
		
		Orderhistorypage orderpg = new Orderhistorypage(driver);
		Assert.assertEquals(orderpg.getOrderHistoryPageTitle(), config.getOrderHistoryPageTitle());
		log.info("Order History Page Title: " + orderpg.getOrderHistoryPageTitle());

		Orderinformationpage orderinfopg = orderpg.clickOnViewOrderInfo();
		Assert.assertEquals(orderinfopg.getOrderInfoPageTitle(), config.getOrderInfoPageTitle());
		log.info("Order Information Page Title: " + orderinfopg.getOrderInfoPageTitle());

		log.info("***** TC112_OHbeforelogintest Completed *****");
	}
	@DataProvider(name = "validcredentials")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//orderhistory.json";
			FileReader reader = new FileReader(filepath);
			object = parser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("loginsearch");
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
