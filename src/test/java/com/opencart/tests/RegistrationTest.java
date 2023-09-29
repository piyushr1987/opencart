package com.opencart.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencart.genericPage.BaseClass;
import com.opencart.pages.RegistrationPage;

public class RegistrationTest extends BaseClass {

	RegistrationPage register;

	public RegistrationTest() throws IOException {
		super();

	}

	@BeforeTest
	public void setUp() throws IOException {
		intialization();
		register = new RegistrationPage();

	}

	@Test(priority = 1)
	public void testMyAccountAndRegister() throws InterruptedException {
		register.clickOnMyAccountAndRegister();
	}

	@Test(priority = 2)
	public void testRegistration() throws Exception {
		if (register.validateRegisterPage()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully navigate to the register page");
		} else {
			captureScreen(driver, "register");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@Test(priority = 3)
	public void testFirstName() {
		register.enterFirstName(prop.getProperty("FirstName"));
	}

	@Test(priority = 4)
	public void testSecondName() {
		register.enterLastName(prop.getProperty("LastName"));
	}

	@Test(priority = 5)
	public void testEmail() {
		register.enterEmail(prop.getProperty("Email"));
	}

	@Test(priority = 6)
	public void testTelephone() {
		register.enterTelephone(prop.getProperty("Phone"));
	}

	@Test(priority = 7)
	public void testPasswordAndConfirmPassword() throws InterruptedException {
		register.enterPassword(prop.getProperty("Password"));
		Thread.sleep(3000);
		register.enterConfirmPassword(prop.getProperty("ConfirmPassword"));
	}

	@Test(priority = 8)
	public void testNewsLetters() {
		register.clickOnNewsletter();
	}

	@Test(priority = 9)
	public void testPrivacyPolicy() {
		register.clickOnPrivacyPolicy();
	}

	@Test(priority = 9)
	public void testContinueButton() {
		register.clickOnContinueButton();
	}

	@Test(priority = 10)
	public void testAccountSucess() throws Exception {
		if (register.validateAccountSucess()) {
			Assert.assertTrue(true);
			Logger.info("sucessfully created the account");
		} else {
			captureScreen(driver, "account sucess");
			Assert.assertTrue(false);
			Logger.info("validation test failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
