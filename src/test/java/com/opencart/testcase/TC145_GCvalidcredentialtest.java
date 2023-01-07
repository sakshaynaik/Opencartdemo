package com.opencart.testcase;

import java.util.HashMap;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobject.Giftcertificatepage;
import com.opencart.pageobject.Homepage;
import com.opencart.utilities.MyXlsReader;
import com.opencart.utilities.ReadXlsxFile;

public class TC145_GCvalidcredentialtest extends BaseClass {

	@Test(dataProvider = "gftcertifate")
	public void giftCertificateTestWithValidData(HashMap<String, String> hMap) {

		log.info("***** TC0145_GCvalidcredentialtest Started *****");

		if (!ReadXlsxFile.isRunnable(xlsreader, "Giftcertificate", "Testcases") || hMap.get("Runmode").equals("N")) {

			throw new SkipException("Test Skipped Due To Runmode Set As N");
		}

		Homepage hmpg = new Homepage(driver);
		Giftcertificatepage gftpg = hmpg.clickOnGiftCertificateLink();
		Assert.assertEquals(gftpg.getGiftCertificatePageTitle(), config.getGiftCertificatePageTitle());
		log.info("Gift Certificate Page Title: " + gftpg.getGiftCertificatePageTitle());

		gftpg.enterRecipientsNameTextField(hMap.get("RecipitName"));
		gftpg.enterRecipientsEmailTextField(hMap.get("RecipitEmail"));
		gftpg.enterSenderNameTextField(hMap.get("ename"));
		gftpg.enterSenderEmailTextField(hMap.get("email"));
		gftpg.clickOnGiftCertifacteTheme(hMap.get("GiftCertTheme"));
		gftpg.enterAmountTextField(hMap.get("Amount"));
		gftpg.clickOnAgreeCheckBox();
		gftpg.clickOnContinueButton();

		Assert.assertTrue(gftpg.isDisplayedGiftCertificateMsg());
		log.info("Gift Certificate Purchase Success Message: " + gftpg.getGiftCertificateMsg());

		log.info("***** TC0145_GCvalidcredentialtest Completed *****");
	}

	@DataProvider(name = "gftcertifate")
	public Object[][] datasuppiler() {

		Object[][] data = null;

		try {
			String filepath = System.getProperty("user.dir") + "//testdata//testdatafile.xlsx";
			xlsreader = new MyXlsReader(filepath);
			data = ReadXlsxFile.getTestData(xlsreader, "validata", "giftcertificate");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return data;
	}

}
