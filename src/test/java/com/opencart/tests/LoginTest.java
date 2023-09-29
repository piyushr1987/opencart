package com.opencart.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.utilities.XLUtils;
import com.opencart.genericPage.BaseClass;
import com.opencart.pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage login;

	public LoginTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		login = new LoginPage();

	}

	@Test(priority = 1)
	public void testMyAccount() {
		Logger.info("sucessfully navigate to open cart home page and click on my account");
		login.clickOnMyAccount();
	}

	@Test(priority = 2)
	public void testLogin() {
		Logger.info("click on login");
		login.clickOnLogIn();
	}

	@Test(priority = 3)
	public void testLoginPage() throws Exception {
		if (login.navigateToLoginPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the login page");
		} else {
			captureScreen(driver, "login");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 4)
	public void testLoginDetails() {
		Logger.info("enter email address");
		login.enterEmail(prop.getProperty("Email"));
		Logger.info("enter password");
		login.enterPassword(prop.getProperty("Password"));
	}

	@Test(priority = 5)
	public void testLogInButton() {
		Logger.info("click on login button");
		login.clickOnLoginInButton();
	}

	@Test(priority = 6)
	public void testSucessfullLogin() throws Exception {
		if (login.navigateToSucessfullLogin()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully login to the account");
		} else {
			captureScreen(driver, "login screen");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/java/com/opencart/TestData/TestDataOpenCart.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i < rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
