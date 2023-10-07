package com.opencart.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.genericPage.BaseClass;
import com.opencart.pages.PhonesAndPDAsPage;

public class PhonesAndPDAsTest extends BaseClass {

	PhonesAndPDAsPage phone;

	public PhonesAndPDAsTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		phone = new PhonesAndPDAsPage();

	}

	@Test(priority = 1)
	public void testPhoneAndPDAs() throws Exception {
		Logger.info("Click on phones and PDAs");
		phone.clickOnPhonesAndPDAs();
		captureScreen(driver, "phone");
	}

	@Test(priority = 2)
	public void testPhoneAndPDASPage() throws Exception {
		if (phone.ValidatePhonesAndPDAsPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to phone and PDAs page");
		} else {
			captureScreen(driver, "phone page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testGridView() throws Exception {
		Logger.info("Click on grid view");
		phone.clickOnGridView();
		captureScreen(driver, "grid view");
	}

	@Test(priority = 4)
	public void testRating() throws Exception {
		Logger.info("select the rating");
		phone.sortTheMonitors(prop.getProperty("sort"));
		captureScreen(driver, "rating");

	}

	@Test(priority = 5)
	public void testRange() throws Exception {
		Logger.info("select the range");
		phone.showTheMonitorsRange(prop.getProperty("range"));
		captureScreen(driver, "range");
	}

	@Test(priority = 6)
	public void testIphone() throws Exception {
		Logger.info("Click on iphone");
		phone.clickOnIphone();
		captureScreen(driver, "iphone");
	}

	@Test(priority = 7)
	public void testIphonePage() throws Exception {
		if (phone.ValidateIphonePage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to iphone page");
		} else {
			captureScreen(driver, "iphone page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 8)
	public void testIphoneImage() throws Exception {
		Logger.info("Click on iphone image");
		phone.clickOnIphoneImage();
		captureScreen(driver, "iphone image");

	}

	@Test(priority = 9)
	public void testNextButton() throws Exception {
		Logger.info("Click on next button");
		phone.clickOnNextButton();
		captureScreen(driver, "next button");

	}

	@Test(priority = 10)
	public void testCloseButton() throws Exception {
		Logger.info("Click on close button");
		phone.clickOnCloseButton();
		captureScreen(driver, "close button");
	}

	@Test(priority = 11)
	public void testQuantity() throws Exception {
		Logger.info("enter the quantity");
		phone.enterQuantity(prop.getProperty("iphoneQuantity"));
		captureScreen(driver, "quantity");
	}

	@Test(priority = 12)
	public void testAddToCart() throws Exception {
		Logger.info("click on add to cart");
		phone.clickOnAddToCart();
		captureScreen(driver, "add cart");
	}

	@Test(priority = 13)
	public void testViewCart() throws Exception {
		Logger.info("click on view cart");
		phone.clickOnViewCart();
		captureScreen(driver, "view cart");
	}

	@AfterTest
	public void tearDown() {
		Logger.info("close the browser");
		driver.close();
	}

}
