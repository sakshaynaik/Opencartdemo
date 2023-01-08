package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Forgotyourpasswordpage;
import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Loginpage;

public class TC038_FPresetpaswrdregistrdemailtest extends BaseClass {

	@Test(dataProvider = "unregemail")
	public void forgotPasswordWithregisteredEmail(String unregemail){

		log.info("***** TC038_FPresetpaswrdunregistrdtest Started *****");
		
		String[] data = unregemail.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.clickOnMyAccountDropMenu();
		Assert.assertTrue(hmpg.isDisplayedLoginOption());
		log.info("Login Option Displayed On MyAccount Drop Menu");

		Loginpage loginpg = hmpg.clickOnLoginLink();
		log.info("Clicked On Login Option From MyAccount Drop Menu");

		Assert.assertEquals(loginpg.getLoginPageTitle(), config.getLoginPageTitle());
		log.info("Navigated To Login Page: " + loginpg.getLoginPageTitle());

		Forgotyourpasswordpage frgtpasspg = loginpg.clickOnForgotPasswordLink();
		Assert.assertEquals(frgtpasspg.getForgotPasswordPageTitle(), config.getForgotPasswrdPageTitle());
		log.info("User Navigated To Forgot Password Page: " + frgtpasspg.getForgotPasswordPageTitle());

		Assert.assertTrue(frgtpasspg.isDisplayedForgetMsgContent());
		log.info("Forgot Password Message Content On Forgot Page: " + frgtpasspg.getForgetMsgContent());

		frgtpasspg.enterEmailOfForgotenPassword(data[1]);
		frgtpasspg.clickOnContinueButton();
		log.info("User Entered Non Registered Emailaddress In Emailaddress Field");

		Assert.assertTrue(loginpg.isDisplayedEmailSentMsgForFP());
		log.info("Forgot Password Email Sent Message Displayed : " + loginpg.getEmailSentMsgForFP());
		
		loginpg.drawBorderEmailSentMsgForFP();
		Assert.fail("Unable To Test The Feature As The Email System Is Not Working");

		log.info("***** TC038_FPresetpaswrdunregistrdtest Completed *****");

	}

	@DataProvider(name = "unregemail")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//forgotpassword.json";
			FileReader reader = new FileReader(filepath);
			object = parser.parse(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("validemail");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);

			Object browser = data.get("browser");
			Object email = data.get("email");

			arr[i] = browser + "," + email;
		}
		return arr;
	}
}
