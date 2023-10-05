package com.opencart.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.genericPage.BaseClass;
import com.opencart.pages.TabletsPage;

public class TabletsTest extends BaseClass {

	TabletsPage tablet;

	public TabletsTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		tablet = new TabletsPage();

	}

	@Test(priority = 1)
	public void testTablets() throws InterruptedException {
		Logger.info("Click on tablets");
		tablet.clickOnTablet();
		Assert.assertTrue(true);
	}

	@Test(priority = 2)
	public void testTabletsPage() throws Exception {
		if (tablet.ValidateTabletsPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to tablets page");
		} else {
			captureScreen(driver, "tablet");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testGridView() throws InterruptedException {
		Logger.info("Click on grid view");
		tablet.clickOnGridView();
		Assert.assertTrue(true);
	}

	@Test(priority = 4)
	public void testRating() {
		Logger.info("select the rating");
		tablet.sortTheMonitors(prop.getProperty("sort"));
		Assert.assertTrue(true);
	}

	@Test(priority = 5)
	public void testRange() {
		Logger.info("select the range");
		tablet.showTheMonitorsRange(prop.getProperty("range"));
		Assert.assertTrue(true);
	}

	@Test(priority = 6)
	public void testSamsungGalaxy() throws InterruptedException {
		Logger.info("Click on samsung galaxy");
		tablet.clickOnSamsungGalaxy();
		Assert.assertTrue(true);
	}

	@Test(priority = 7)
	public void testSamsungGalaxyPage() throws Exception {
		if (tablet.ValidateSamsungGalaxyPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to samsung galaxy page");
		} else {
			captureScreen(driver, "samsung");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 8)
	public void testSamsungGalaxyImage() throws InterruptedException {
		Logger.info("Click on samsung galaxy image");
		tablet.clickOnSamsungGalaxyImage();
		Assert.assertTrue(true);
	}

	@Test(priority = 9)
	public void testNextButton() throws InterruptedException {
		Logger.info("Click on next button");
		tablet.clickOnNextButton();
		Assert.assertTrue(true);
	}

	@Test(priority = 10)
	public void testCloseButton() throws InterruptedException {
		Logger.info("Click on close button");
		tablet.clickOnCloseButton();
		Assert.assertTrue(true);
	}

	@Test(priority = 11)
	public void testQuantity() {
		Logger.info("enter the quantity");
		tablet.enterQuantity(prop.getProperty("samsungQuantity"));
		Assert.assertTrue(true);
	}

	@Test(priority = 12)
	public void testAddToCart() {
		Logger.info("click on add to cart");
		tablet.clickOnAddToCart();
		Assert.assertTrue(true);
	}

	@Test(priority = 13)
	public void testViewCart() {
		Logger.info("click on view cart");
		tablet.clickOnViewCart();
		Assert.assertTrue(true);
	}

	@AfterTest
	public void tearDown() {
		Logger.info("close the browser");
		driver.close();
	}

}
