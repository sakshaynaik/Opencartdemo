package com.opencart.utilities;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

import com.opencart.testcase.BaseClass;

public class WebDriveListeners extends BaseClass implements WebDriverListener {

	@Override
	public void afterGet(WebDriver driver, String url) {

		log.info("Loaded WebPage In The Current Browser Window");
	}

	@Override
	public void afterGetCurrentUrl(String result, WebDriver driver) {

		log.info("String Representing The Current URL");
	}

	@Override
	public void afterGetTitle(WebDriver driver, String result) {

		log.info("String Representing The Current PageTitle");
	}

	@Override
	public void afterGetPageSource(WebDriver driver, String result) {

		log.info("String Representing The Current PageSource");
	}

	@Override
	public void afterClose(WebDriver driver) {

		log.info("Close The Current Window");
	}

	@Override
	public void afterQuit(WebDriver driver) {

		log.info("Quit The Driver, Closing Every Associated Window.");
	}

	@Override
	public void afterGetWindowHandles(WebDriver driver, Set<String> result) {

		log.info("Return A Set Of Window Handles To Switch A Specific Window");
	}

	@Override
	public void afterGetWindowHandle(WebDriver driver, String result) {

		log.info("Return A Window Handle");
	}

	@Override
	public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {

		log.info("After Execute Script");
	}

	@Override
	public void afterPerform(WebDriver driver, Collection<Sequence> actions) {

		log.info("Action Performed By Actions Class");
	}

	@Override
	public void afterClick(WebElement element) {

		log.info("Clicked On WebElement");
	}

	@Override
	public void afterSubmit(WebElement element) {

		log.info("After Submitting");
	}

	@Override
	public void afterClear(WebElement element) {

		log.info("Clearing The Data From An Element");
	}

	@Override
	public void afterGetTagName(WebElement element, String result) {

		log.info("Tag Name Of Element");
	}

	@Override
	public void afterGetAttribute(WebElement element, String name, String result) {

		log.info("String Attribut Of Element");
	}

	@Override
	public void afterGetText(WebElement element, String result) {

		log.info("String Text Of Webelement");
	}

	@Override
	public void afterGetLocation(WebElement element, Point result) {

		log.info("Retrived Location Of Element");
	}

	@Override
	public void afterGetSize(WebElement element, Dimension result) {

		log.info("Retrived Size Of Element");
	}

	@Override
	public void afterGetCssValue(WebElement element, String propertyName, String result) {

		log.info("String CssValue Of WebElement");
	}

	@Override
	public void afterTo(Navigation navigation, String url) {

		log.info("On Navigating To");
	}

	@Override
	public void afterBack(Navigation navigation) {

		log.info("On Navigating Back");
	}

	@Override
	public void afterForward(Navigation navigation) {

		log.info("On Navigating Forward");
	}

	@Override
	public void afterRefresh(Navigation navigation) {

		log.info("On Navigating Refresh");
	}

	@Override
	public void afterAccept(Alert alert) {

		log.info("Alert Accepted");
	}

	@Override
	public void afterDismiss(Alert alert) {

		log.info("Alert Dismissed");
	}

	@Override
	public void afterGetText(Alert alert, String result) {

		log.info("Retrived The Text From Alert Box");
	}

	@Override
	public void afterAddCookie(Options options, Cookie cookie) {

		log.info("New Cookie Added");
	}

	@Override
	public void afterDeleteCookieNamed(Options options, String name) {

		log.info("Deleted The CookieNamed");
	}

	@Override
	public void afterDeleteAllCookies(Options options) {

		log.info("Deleted All The Cookies");
	}

	@Override
	public void afterGetCookies(Options options, Set<Cookie> result) {

		log.info("Retrived All The Set<Cookie>");
	}

	@Override
	public void afterGetCookieNamed(Options options, String name, Cookie result) {

		log.info("Retrived The CookieNamed");
	}

	@Override
	public void afterAnyTimeoutsCall(Timeouts timeouts, Method method, Object[] args, Object result) {

		log.info("TimeOut Call From Method");
	}

	@Override
	public void afterImplicitlyWait(Timeouts timeouts, Duration duration) {

		log.info("WebElement Implicitly Waited In Sec");
	}

	@Override
	public void afterSetScriptTimeout(Timeouts timeouts, Duration duration) {

		log.info("Set ScriptTimeOut");
	}

	@Override
	public void afterPageLoadTimeout(Timeouts timeouts, Duration duration) {

		log.info("On PageLoad TimeOut");
	}

	@Override
	public void afterGetSize(Window window, Dimension result) {

		log.info("Retrieved The Size Of WebElement");
	}

	@Override
	public void afterSetSize(Window window, Dimension size) {

		log.info("Size Of The Window Is Set To");
	}

	@Override
	public void afterGetPosition(Window window, Point result) {

		log.info("Retrived The Position Of WebElement");
	}

	@Override
	public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {

		log.info("List<WebElement> Located " + locator);
	}

	@Override
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {

		log.info("WebElement Located " + locator);
	}

	@Override
	public void afterFindElements(WebElement element, By locator, List<WebElement> result) {

		log.info("Maximized The Current Window If It Is Not Already Maximized");
	}

	@Override
	public void afterFullscreen(Window window) {

		log.info("Fullscreen The Current Window If It Is Not Already Fullscreen");
	}

}