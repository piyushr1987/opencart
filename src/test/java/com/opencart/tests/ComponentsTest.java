package com.opencart.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.genericPage.BaseClass;
import com.opencart.pages.ComponentsPage;

public class ComponentsTest extends BaseClass {

	ComponentsPage component;

	public ComponentsTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		component = new ComponentsPage();

	}

	@Test(priority = 1)
	public void testComponents() throws InterruptedException {
		Logger.info("Go to components and then click on monitors");
		component.goToComponents();
	}

	@Test(priority = 2)
	public void testMonitorsPage() throws Exception {
		if (component.ValidateMonitorsPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to monitors page");
		} else {
			captureScreen(driver, "monitor");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testListView() {
		Logger.info("click on list view");
		component.clickOnListView();
	}

	@Test(priority = 4)
	public void testRating() {
		Logger.info("select the rating");
		component.sortTheMonitors(prop.getProperty("sort"));
	}

	@Test(priority = 5)
	public void testRange() {
		Logger.info("select the range");
		component.showTheMonitorsRange(prop.getProperty("range"));
	}

	@Test(priority = 6)
	public void testSamsungMonitor() {
		Logger.info("click on samsung monitor");
		component.clickOnSansungMonitor();
	}

	@Test(priority = 7)
	public void testReviews() {
		Logger.info("enter the review");
		component.writeReview(prop.getProperty("name"), prop.getProperty("review"));
	}

	@Test(priority = 8)
	public void testContinue() {
		Logger.info("submit the review");
		component.clickOnContinue();
	}

	@Test(priority = 9)
	public void testQuantity() {
		Logger.info("enter the quantity");
		component.enterQuantity(prop.getProperty("samsungQuantity"));
	}

	@Test(priority = 10)
	public void testAddToCart() {
		Logger.info("click on add to cart");
		component.clickOnAddToCart();
	}

	@Test(priority = 11)
	public void testViewCart() {
		Logger.info("click on view cart");
		component.clickOnViewCart();
	}

	@AfterTest
	public void tearDown() {
		Logger.info("close the browser");
		driver.close();
	}

}
