package com.opencart.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.genericPage.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='top-links']//li/parent::ul[@class='list-inline']/child::li[2]")
	WebElement lstMyAccount;

	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu d')]/li[2]")
	WebElement drpLogIn;

	@FindBy(id = "input-email")
	WebElement txtEmail;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogIn;

	@FindBy(xpath = "//div[@id='content']/h2[1]")
	WebElement lblMyAccount;

	public void clickOnMyAccount() {
		lstMyAccount.click();
	}

	public void clickOnLogIn() {
		drpLogIn.click();
	}

	public boolean navigateToLoginPage() {
		return driver.getCurrentUrl().contains("account/login");
	}

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);

	}

	public void enterPassword(String pass) {

		txtPassword.sendKeys(pass);

	}

	public void clickOnLoginInButton() {
		btnLogIn.click();
	}

	public boolean navigateToSucessfullLogin() {
		return lblMyAccount.isDisplayed();
	}

}
