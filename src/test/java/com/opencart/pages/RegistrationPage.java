package com.opencart.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.genericPage.BaseClass;

public class RegistrationPage extends BaseClass {

	public RegistrationPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='top-links']//li/parent::ul[@class='list-inline']/child::li[2]")
	WebElement lstMyAccount;

	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu d')]/li[1]")
	WebElement drpRegister;

	@FindBy(id = "input-firstname")
	WebElement txtFirstName;

	@FindBy(id = "input-lastname")
	WebElement txtLastName;

	@FindBy(id = "input-email")
	WebElement txtEmail;

	@FindBy(id = "input-telephone")
	WebElement txtTelephone;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(id = "input-confirm")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//label[@class='radio-inline'][1]")
	WebElement radiYes;

	@FindBy(name = "agree")
	WebElement chkPrivacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	public void clickOnMyAccountAndRegister() throws InterruptedException {
		lstMyAccount.click();
		Thread.sleep(3000);
		drpRegister.click();
	}

	public boolean validateRegisterPage() {
		return driver.getCurrentUrl().contains("account/register");

	}

	public void enterFirstName(String fname) {
		txtFirstName.sendKeys(fname);

	}

	public void enterLastName(String lname) {

		txtLastName.sendKeys(lname);

	}

	public void enterEmail(String email) {

		txtEmail.sendKeys(email);

	}

	public void enterTelephone(String phone) {

		txtTelephone.sendKeys(phone);

	}

	public void enterPassword(String pass) throws InterruptedException {

		txtConfirmPassword.sendKeys(pass);

	}

	public void enterConfirmPassword(String cpass) throws InterruptedException {

		txtConfirmPassword.sendKeys(cpass);

	}

	public void clickOnNewsletter() {
		radiYes.click();
	}

	public void clickOnPrivacyPolicy() {
		chkPrivacyPolicy.click();
	}

	public void clickOnContinueButton() {
		btnContinue.click();
	}

	public boolean validateAccountSucess() {
		return driver.getCurrentUrl().contains("account/success");

	}

}
