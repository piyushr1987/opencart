package com.opencart.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.genericPage.BaseClass;
import com.opencart.pages.DesktopPage;

public class DesktopTest extends BaseClass {

	DesktopPage desktop;

	public DesktopTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		desktop = new DesktopPage();

	}

	@Test(priority = 1)
	public void testDesktopDropdown() throws InterruptedException {
		Logger.info("Go to desktop and then click on mac");
		desktop.goToDesktopAndClickOnMac();
	}

	@Test(priority = 2)
	public void testMacPage() throws Exception {
		if (desktop.ValidateMacPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to mac page");
		} else {
			captureScreen(driver, "mac");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testListView() throws Exception {
		if (desktop.validateListView()) {
			Assert.assertTrue(true);
			Logger.info("List view is selected by default");
		} else {
			captureScreen(driver, "list view");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 4)
	public void testGridView() {
		Logger.info("click on grid view");
		desktop.clickOnGridView();
	}

	@Test(priority = 5)
	public void testLableSortBy() throws Exception {
		if (desktop.validateTextSortBy()) {
			Assert.assertTrue(true);
			Logger.info("Sort by label is displayed on page");
		} else {
			captureScreen(driver, "sort by");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 6)
	public void testDropdownSortBy() throws Exception {
		if (desktop.validateSortByDropDown()) {
			Assert.assertTrue(true);
			Logger.info("default value is selected");
		} else {
			captureScreen(driver, "default");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 7)
	public void testDefaultValue() {
		Logger.info("click on grid view");
		desktop.selectCatagory(prop.getProperty("value"));
	}

	@Test(priority = 8)
	public void testLabelShow() throws Exception {
		if (desktop.validateTextShow()) {
			Assert.assertTrue(true);
			Logger.info("show label is displayed");
		} else {
			captureScreen(driver, "show label");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 9)
	public void testDefalutValueOfShow() throws Exception {
		if (desktop.validateShowByDropdown()) {
			Assert.assertTrue(true);
			Logger.info("defalut value is sucessfully displayed");
		} else {
			captureScreen(driver, "show label");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 10)
	public void testShowValue() {
		Logger.info("select show value");
		desktop.selectCatagory(prop.getProperty("value2"));
	}

	@Test(priority = 11)
	public void testImac() {
		Logger.info("click on iMac");
		desktop.clickOnImac();
	}

	@Test(priority = 12)
	public void testImacPage() throws Exception {
		if (desktop.ValidateImacPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to imac page");
		} else {
			captureScreen(driver, "imac page");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 13)
	public void testImacImage() {
		Logger.info("click on iMac image");
		desktop.clickOnImageOfImac();
	}

	@Test(priority = 14)
	public void testNextButton() {
		Logger.info("click on next button");
		desktop.clickOnNextButton();
	}

	@Test(priority = 15)
	public void testCloseButton() {
		Logger.info("click on close button");
		desktop.clickOnCloseButton();
	}

	@Test(priority = 16)
	public void testCompareThisProduct() {
		Logger.info("click on compare this product");
		desktop.clickOnCompareThisProduct();
		WebElement alert = driver.findElement(By.xpath("//*[text()=' Success: You have added ']"));
		String alertText = alert.getText();
		Assert.assertEquals(alertText, prop.getProperty("text"), "check for correct alert");
	}

	@Test(priority = 17)
	public void testCompareLink() {
		Logger.info("click on product compare link");
		desktop.clickOnProductCompare();
	}

	@Test(priority = 18)
	public void testProductCompareLable() throws Exception {
		if (desktop.ValidateProductComparisonDetails()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully dispalyed the product details");
		} else {
			captureScreen(driver, "product details");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 19)
	public void testAddToCart() {
		Logger.info("click on add to cart");
		desktop.clickAddToCart();
	}

	@Test(priority = 20)
	public void testCartTotal() {
		Logger.info("click on cart total");
		desktop.clickCartTotal();
	}

	@Test(priority = 21)
	public void testViewCart() {
		Logger.info("click on view cart");
		desktop.clickOnViewCart();
	}

	@Test(priority = 22)
	public void testCheckOutPage() throws Exception {
		if (desktop.ValidateCheckOutPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to check out page");
		} else {
			captureScreen(driver, "check out");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
