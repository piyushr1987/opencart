package com.opencart.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.opencart.genericPage.BaseClass;
import com.opencart.pages.LoginPage;
import com.opencart.utilities.XLUtils;

public class LoginTest_DDT extends BaseClass {

	LoginPage login;

	public LoginTest_DDT() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException {
		intialization();
		login = new LoginPage();

	}

	@Test(dataProvider = "LoginData")
	public void testLoginDetails(String user, String pass) {

		Logger.info("sucessfully navigate to open cart home page and click on my account");
		login.clickOnMyAccount();
		Logger.info("click on login");
		login.clickOnLogIn();
		Logger.info("enter email address");
		login.enterEmail(user);
		Logger.info("enter password");
		login.enterPassword(pass);
		Logger.info("click on login button");
		login.clickOnLoginInButton();
	}

	@AfterMethod
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
