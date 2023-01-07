package com.opencart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	String filepath = System.getProperty("user.dir") + "//configration//config.properties";

	public ReadConfig() {

		prop = new Properties();
		File file = new File(filepath);

		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {

		String browser = prop.getProperty("Browser");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("Browser Name Not Found In Properties File");
	}

	public String getURL() {

		String url = prop.getProperty("URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("URL Not Found In Properties File");
	}

	public String getHomePageTitle() {

		String hmpg = prop.getProperty("HomePageTitle");
		if (hmpg != null)
			return hmpg;
		else
			throw new RuntimeException("HomePageTitle Not Found In Properties File");
	}

	public String getRegisterationPageTitle() {

		String repg = prop.getProperty("RegisterPageTitle");
		if (repg != null)
			return repg;
		else
			throw new RuntimeException("RegisterPageTitle Not Found In Properties File");
	}

	public String getSuccessPageTitle() {

		String scpg = prop.getProperty("SuccessPageTitle");
		if (scpg != null)
			return scpg;
		else
			throw new RuntimeException("SuccessPageTitle Not Found In Properties File");
	}

	public String getAccountPageTitle() {

		String acpg = prop.getProperty("AccountPageTitle");
		if (acpg != null)
			return acpg;
		else
			throw new RuntimeException("AccountPageTitle Not Found In Properties File");
	}

	public String getNewsletterPageTitle() {

		String nwpg = prop.getProperty("NewletterPageTitle");
		if (nwpg != null)
			return nwpg;
		else
			throw new RuntimeException("NewletterPageTitle Not Found In Properties File");
	}

	public String getLoginPageTitle() {

		String lgpg = prop.getProperty("loginPageTitle");
		if (lgpg != null)
			return lgpg;
		else
			throw new RuntimeException("LoginPageTitle Not Found In Properties File");
	}

	public String getForgotPasswrdPageTitle() {

		String fgpg = prop.getProperty("forgotpasswrdTitle");
		if (fgpg != null)
			return fgpg;
		else
			throw new RuntimeException("ForgotpasswrdTitle Not Found In Properties File");
	}

	public String getAccountLogoutPageTitle() {

		String aclogt = prop.getProperty("AccountlogoutTitle");
		if (aclogt != null)
			return aclogt;
		else
			throw new RuntimeException("AccountlogoutTitle Not Found In Properties File");
	}

	public String getSearchPageTitle() {

		String srcgpg = prop.getProperty("SearchPageTitle");
		if (srcgpg != null)
			return srcgpg;
		else
			throw new RuntimeException("SearchPageTitle Not Found In Properties File");
	}

	public String getCompareProductPageTitle() {

		String comprd = prop.getProperty("ComapreProdutTitle");
		if (comprd != null)
			return comprd;
		else
			throw new RuntimeException("ComapreProdutPageTitle Not Found In Properties File");
	}

	public String getSiteMapPageTitle() {

		String sitemap = prop.getProperty("siteMapTitle");
		if (sitemap != null)
			return sitemap;
		else
			throw new RuntimeException("siteMapPageTitle Not Found In Properties File");
	}

	public String getDesktopsPageTitle() {

		String desktop = prop.getProperty("DesktopsPageTitle");
		if (desktop != null)
			return desktop;
		else
			throw new RuntimeException("DesktopsPageTitle Not Found In Properties File");
	}

	public String getWishlistPageTitle() {

		String wshlst = prop.getProperty("WishlistPageTitle");
		if (wshlst != null)
			return wshlst;
		else
			throw new RuntimeException("WishlistPageTitle Not Found In Properties File");
	}

	public String getShoppingCartPageTitle() {

		String scpg = prop.getProperty("ShoppingCartPagTitle");
		if (scpg != null)
			return scpg;
		else
			throw new RuntimeException("ShoppingCartPageTitle Not Found In Properties File");
	}

	public String getPCPageTitle() {

		String pcpg = prop.getProperty("PCPageTitle");
		if (pcpg != null)
			return pcpg;
		else
			throw new RuntimeException("PCPageTitle Not Found In Properties File");
	}

	public String getCheckoutPageTitle() {

		String ckpg = prop.getProperty("CheckoutpPageTitle");
		if (ckpg != null)
			return ckpg;
		else
			throw new RuntimeException("CheckoutPageTitle Not Found In Properties File");
	}

	public String getOrderPlacedPageTitle() {

		String odrpg = prop.getProperty("OrderPlacedPageTitle");
		if (odrpg != null)
			return odrpg;
		else
			throw new RuntimeException("OrderPlacedPageTitle Not Found In Properties File");
	}

	public String getMyAccountInfoPageTitle() {

		String myinfopf = prop.getProperty("MyAccountInfoPageTle");
		if (myinfopf != null)
			return myinfopf;
		else
			throw new RuntimeException("MyAccountInfoPageTitle Not Found In Properties File");
	}

	public String getChangePasswordPageTitle() {

		String cppg = prop.getProperty("ChangePaswrdPageTlte");
		if (cppg != null)
			return cppg;
		else
			throw new RuntimeException("ChangePasswordPageTilte Not Found In Properties File");
	}

	public String getAddressBookPageTitle() {

		String addbkpg = prop.getProperty("AddressBookPageTitle");
		if (addbkpg != null)
			return addbkpg;
		else
			throw new RuntimeException("AddressBookPageTitle Not Found In Properties File");
	}

	public String getOrderHistoryPageTitle() {

		String ohpg = prop.getProperty("OrderHistoryPageTle");
		if (ohpg != null)
			return ohpg;
		else
			throw new RuntimeException("OrderHistoryPageTitle Not Found In Properties File");
	}

	public String getOrderInfoPageTitle() {

		String oipg = prop.getProperty("OrderInfoPageTitle");
		if (oipg != null)
			return oipg;
		else
			throw new RuntimeException("OrderInfoPageTitle Not Found In Properties File");
	}

	public String getProductReturnPageTitle() {

		String prpg = prop.getProperty("ProductReturnPagetle");
		if (prpg != null)
			return prpg;
		else
			throw new RuntimeException("ProductReturnPagetitle Not Found In Properties File");
	}

	public String getDownloadsPageTitle() {

		String dwnpg = prop.getProperty("DownloadsPageTitle");
		if (dwnpg != null)
			return dwnpg;
		else
			throw new RuntimeException("DownloadsPageTitle Not Found In Properties File");
	}

	public String getRewardsPointPageTitle() {

		String rwpg = prop.getProperty("RewardsPointPageTle");
		if (rwpg != null)
			return rwpg;
		else
			throw new RuntimeException("RewardsPointPageTitle Not Found In Properties File");
	}

	public String getReturnInformationPageTitle() {

		String ripg = prop.getProperty("ReturnInfoPageTitle");
		if (ripg != null)
			return ripg;
		else
			throw new RuntimeException("ReturnInfoPageTitle Not Found In Properties File");
	}

	public String getTransactionHistoryPageTitle() {

		String trspg = prop.getProperty("TransactionPageTitle");
		if (trspg != null)
			return trspg;
		else
			throw new RuntimeException("TransactionPageTitle Not Found In Properties File");
	}

	public String getRecurringPaymentPageTitle() {

		String recpg = prop.getProperty("RecurringPageTitle");
		if (recpg != null)
			return recpg;
		else
			throw new RuntimeException("RecurringPageTitle Not Found In Properties File");
	}

	public String getContactUsPageTitle() {

		String contpg = prop.getProperty("ContactUsPageTitle");
		if (contpg != null)
			return contpg;
		else
			throw new RuntimeException("ContactUsPageTitle Not Found In Properties File");
	}

	public String getGiftCertificatePageTitle() {

		String gftpg = prop.getProperty("GiftCertificatePgTle");
		if (gftpg != null)
			return gftpg;
		else
			throw new RuntimeException("GiftCertificatePageTitle Not Found In Properties File");
	}

	public String getSpecialOffersPageTitle() {

		String spofpg = prop.getProperty("SpecialOfferPageTitl");
		if (spofpg != null)
			return spofpg;
		else
			throw new RuntimeException("SpecialOfferPageTitle Not Found In Properties File");
	}
}
