package com.opencart.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.genericPage.BaseClass;
import com.opencart.pages.HomePage;

public class HomeTest extends BaseClass {

	HomePage home;

	public HomeTest() throws IOException {
		super();
	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		home = new HomePage();

	}

	@Test(priority = 1)
	public void testPhoneNumber() throws Exception {
		if (home.validatePhoneNumber()) {
			Assert.assertTrue(true);
			Logger.info("phone number field is displayed on home page");
		} else {
			captureScreen(driver, "phone no");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 2)
	public void testMyAccount() throws Exception {
		if (home.validateMyAccount()) {
			Assert.assertTrue(true);
			Logger.info("my account field is displayed on home page");
		} else {
			captureScreen(driver, "my account");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testWishList() throws Exception {
		if (home.validateWishList()) {
			Assert.assertTrue(true);
			Logger.info("wish list field is displayed on home page");
		} else {
			captureScreen(driver, "wish list");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 4)
	public void testShoppingCart() throws Exception {
		if (home.validateShoppingCart()) {
			Assert.assertTrue(true);
			Logger.info("shopping cart field is displayed on home page");
		} else {
			captureScreen(driver, "shopping cart");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 5)
	public void testCheckOut() throws Exception {
		if (home.validateCheckOut()) {
			Assert.assertTrue(true);
			Logger.info("check out field is displayed on home page");
		} else {
			captureScreen(driver, "check out");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 6)
	public void testCompanyLogo() throws Exception {
		if (home.validateCompanyLogo()) {
			Assert.assertTrue(true);
			Logger.info("company logo is displayed on home page");
		} else {
			captureScreen(driver, "company logo");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 6)
	public void testAddToCart() throws Exception {
		if (home.validateAddTocart()) {
			Assert.assertTrue(true);
			Logger.info("add to cart is displayed on home page");
		} else {
			captureScreen(driver, "add to cart");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 7)
	public void testMyAccountLink() throws Exception {
		if (home.validateMyAccountLinkAtFooter()) {
			Assert.assertTrue(true);
			Logger.info("my account link is displayed on home page at footer");
		} else {
			captureScreen(driver, "my account link");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
