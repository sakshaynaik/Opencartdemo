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

public class TC073_PDwithnegativeqtytest extends BaseClass {

	@Test(dataProvider = "invalidqty")
	public void productCompareWithNegativeQuantity(String fielddata) {

		log.info("***** TC073_PDwithnegativeqtytest Started *****");

		String[] data = fielddata.split(",");

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

		prdtpg.enterNumberOfProductInQtyTextField(data[2]);
		prdtpg.clickOnAddToCartButton();

		try {

			Assert.assertEquals(prdtpg.getTexOfWhishlistMsg(), data[3]);
			log.info("Warning Message Of WhishList Was Displayed On Product Page: " + prdtpg.getTexOfWhishlistMsg());

		} catch (Throwable e) {
			
			prdtpg.drawBorderForProductInQtyTextField();
			prdtpg.drawBorderWishlistMsg();
			Assert.fail("Warning Message 'Quantity Should Be A Positive Number' "
					+ "Is Not Getting Displayed For The Applied Negative Value For Quantity");
		}

		log.info("***** TC073_PDwithnegativeqtytest Completed *****");
	}

	@DataProvider(name = "invalidqty")
	public Object[] dataSupplier() {

		JSONParser jsonparser = new JSONParser();
		Object object = null;

		try {
			String filepath = System.getProperty("user.dir") + "//jsonfiles//Productdisplay.json";
			FileReader reader = new FileReader(filepath);
			object = jsonparser.parse(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonobject = ((JSONObject) object);
		JSONArray jsonarray = (JSONArray) jsonobject.get("invalidqty");
		Object[] arr = new Object[jsonarray.size()];
		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject data = (JSONObject) jsonarray.get(i);
			Object browser = data.get("browser");
			Object prdt = data.get("product");
			Object qty = data.get("qtynos");
			Object wrnmsg = data.get("warnmsg");

			arr[i] = browser + "," + prdt + "," + qty + "," + wrnmsg;
		}
		return arr;
	}
}
