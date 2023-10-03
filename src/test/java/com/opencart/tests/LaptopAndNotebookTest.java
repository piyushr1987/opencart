package com.opencart.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.genericPage.BaseClass;
import com.opencart.pages.LaptopAndNotebookPage;

public class LaptopAndNotebookTest extends BaseClass {

	LaptopAndNotebookPage laptop;

	public LaptopAndNotebookTest() throws IOException {
		super();
	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		laptop = new LaptopAndNotebookPage();

	}

	@Test(priority = 1)
	public void testDesktopDropdown() throws InterruptedException {
		Logger.info("Go to laptop&Notebooks and then click on show all laptops and notebooks");
		laptop.goToLaptopAndNotebook();
	}

	@Test(priority = 2)
	public void testLaptopAndNotebookPage() throws Exception {
		if (laptop.ValidateLaptopAndNotebookPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to laptop and notebooks page");
		} else {
			captureScreen(driver, "laptop");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testListViewSelection() throws Exception {
		if (laptop.ValidateListViewSelection()) {
			Assert.assertTrue(true);
			Logger.info("list view is selected by default");
		} else {
			captureScreen(driver, "list view");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 4)
	public void testGridView() {
		Logger.info("click on grid view");
		laptop.clickGridView();
	}

	@Test(priority = 5)
	public void testMacBookPro() {
		Logger.info("click on mac book pro");
		laptop.clickOnMacBookPro();
	}

	@Test(priority = 6)
	public void testMacBookProImage() {
		Logger.info("click on mac book pro image");
		laptop.clickOnMacImage();
	}

	@Test(priority = 7)
	public void testNextButton() {
		Logger.info("click on next button");
		laptop.clickOnNextButton();
	}

	@Test(priority = 8)
	public void testCloseButton() {
		Logger.info("click on close button");
		laptop.clickOnCloseButton();
	}

	@Test(priority = 9)
	public void testQuantity() {
		Logger.info("enter the quantity");
		laptop.enterQuantity(prop.getProperty("quantity"));
	}

	@Test(priority = 10)
	public void testAddToCart() {
		Logger.info("click on add to cart");
		laptop.clickOnAddToCart();
	}

	@Test(priority = 11)
	public void testViewCart() {
		Logger.info("click on view cart");
		laptop.clickOnViewCart();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
