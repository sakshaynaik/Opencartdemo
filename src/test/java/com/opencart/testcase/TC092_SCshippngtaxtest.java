package com.opencart.testcase;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Homepage;
import com.opencart.pageobject.Productpage;
import com.opencart.pageobject.Searchpage;
import com.opencart.pageobject.Shoppingcartpage;

public class TC092_SCshippngtaxtest extends BaseClass {

	@Test(dataProvider = "validcredentials")
	public void shoppingCartCloseWarningMesgOfCoupen(String validdata) {

		log.info("***** TC092_SCshippngtaxtest Started *****");

		String[] data = validdata.split(",");

		Homepage hmpg = new Homepage(driver);
		hmpg.enterSearchTextField(data[1]);
		Searchpage srchpg = hmpg.clickOnSearchButton();
		Assert.assertTrue(srchpg.getSearchPageTitle().contains(config.getSearchPageTitle()));
		log.info("User Navigated To Search Page Title: " + srchpg.getSearchPageTitle());

		Assert.assertTrue(srchpg.isDispalyediMacFromSearchCriteria());
		log.info("iMac Was Displayed On Search Page: " + srchpg.getiMacFromSearchCriteria());

		Productpage prdtpg = srchpg.clickOniMacImg();
		log.info("User Navigated To Product Page Title: " + prdtpg.getProductPageTitle());

		Assert.assertTrue(prdtpg.isDispalyedOfProductAvailabity());
		log.info("Availabity Of iMac Was Displayed On Product Page: " + prdtpg.getTexOfProductAvailabity());

		Assert.assertTrue(prdtpg.isDispalyedOfProductCode());
		log.info("Product Code Of iMac Was Displayed On Product Page: " + prdtpg.getTexOfProductCode());

		prdtpg.clickOnAddToCartButton();
		Assert.assertTrue(prdtpg.isDispalyedOfWhishlistMsg());
		log.info("Success Added To Wish-List Message Displayed");

		Shoppingcartpage shopcart = prdtpg.clickOnShopCartMsgLink();
		Assert.assertEquals(shopcart.getShoppingCartPageTitle(), config.getShoppingCartPageTitle());
		log.info("ShopCart Page Title: " + shopcart.getShoppingCartPageTitle());

		Assert.assertTrue(shopcart.isDisplayediMacImg());
		log.info("Success Added Product To Shopping cart Page");

		shopcart.clickOnShipAndTaxOption();
		shopcart.selectByTextCountry(data[2]);
		shopcart.selectByTextState(Integer.parseInt(data[3]));
		shopcart.enterPostalCodeTextField(data[4]);
		shopcart.clickOnGetQuoteButton();
		log.info("User Submitted All The Mandatory Shipping And Tax Field");

		shopcart.clickOnRadioButtonLightBox();
		shopcart.clickOnApplyShippingButton();
		log.info("User Submitted On Shiiping Button");

		Assert.assertTrue(shopcart.isDisplayedCoupenShippingSussessMsg());
		log.info("Shipping Success Message Displayed On WebPage: " + shopcart.getCoupenShippingSussessMsg());

		log.info("***** TC092_SCshippngtaxtest Started *****");
	}

	@DataProvider(name = "validcredentials")
	public Object[] dataSupplier() {

		JSONParser parser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//shoppingcart.json";
			FileReader reader = new FileReader(filepath);
			object = parser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jsonobject = (JSONObject) object;
		JSONArray jsonarray = (JSONArray) jsonobject.get("shippingstatus");
		Object[] arr = new Object[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object brows = data.get("browser");
			Object prdut = data.get("product");
			Object contry = data.get("country");
			Object state = data.get("state");
			Object pstcode = data.get("postalcode");

			arr[i] = brows + "," + prdut+ "," + contry+ "," + state+ "," + pstcode;
		}
		return arr;
	}
}
