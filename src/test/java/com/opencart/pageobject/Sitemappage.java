package com.opencart.pageobject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.ReadAction;

public class Sitemappage {

	WebDriver ldriver;

	public Sitemappage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Search")
	private WebElement searchlink;

	@FindBy(linkText = "Address Book")
	private WebElement addressbook;

	@FindBy(linkText = "Order History")
	private WebElement orderhistorylink;

	@FindBy(linkText = "Downloads")
	private WebElement downloadlink;

	@FindBy(linkText = "Reward Points")
	private WebElement rewardpointlink;

	@FindBy(linkText = "Special Offers")
	private WebElement specialoffer;

	@FindBy(xpath = "//div[@id='content']//li//a")
	private List<WebElement> listlinkonsitemap;

	///////////////////////////////////////////////////////

	public void clickOnRandomLinks() {

		Random random = new Random();
		int num = random.nextInt(listlinkonsitemap.size());

		for (int i = 0; i < 20; i++) {
			ldriver.findElement(By.xpath("//div[@id='content']//li[" + (num + 1) + "]//a")).click();
			try {
				ldriver.navigate().back();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Specialofferspage clickOnSpecialOffersLink() {

		specialoffer.click();
		return (new Specialofferspage(ldriver));
	}

	public Rewardspointpage clickOnRewardPointsLink() {

		rewardpointlink.click();
		return (new Rewardspointpage(ldriver));
	}

	public Downloadspage clickOnDownloadsLink() {

		downloadlink.click();
		return (new Downloadspage(ldriver));
	}

	public Orderhistorypage clickOnOrderHistoryLink() {

		ReadAction.JSClick(ldriver, orderhistorylink);
		return (new Orderhistorypage(ldriver));
	}

	public Addressbookpage clickOnAddressBookLink() {

		addressbook.click();
		return (new Addressbookpage(ldriver));
	}

	public Searchpage clickOnSearchLink() {

		searchlink.click();
		return (new Searchpage(ldriver));
	}

	public void navigateToBackPage() {

		ldriver.navigate().back();
	}

	public String getSiteMapPageTitle() {

		return (ldriver.getTitle());
	}

}
