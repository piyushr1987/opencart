package com.opencart.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.genericPage.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='top-links']//li/parent::ul[@class='list-inline']/child::li[1]")
	WebElement lstPhoneNo;

	@FindBy(xpath = "//div[@id='top-links']//li/parent::ul[@class='list-inline']/child::li[2]")
	WebElement lstMyAccount;

	@FindBy(xpath = "//div[@id='top-links']//li/parent::ul[@class='list-inline']/child::li[3]")
	WebElement lstWishList;

	@FindBy(xpath = "//div[@id='top-links']//li/parent::ul[@class='list-inline']/child::li[4]")
	WebElement lstShoppingCart;

	@FindBy(xpath = "//div[@id='top-links']//li/parent::ul[@class='list-inline']/child::li[5]")
	WebElement lstCheckOut;

	@FindBy(xpath = "//div[@id='logo']")
	WebElement companyLogo;

	@FindBy(xpath = "//div[@id='cart']")
	WebElement btnCart;

	@FindBy(xpath = "//a[contains(text(),'My Account')]")
	WebElement lnkMyAccount;

	public boolean validatePhoneNumber() {
		return lstPhoneNo.isDisplayed();

	}

	public boolean validateMyAccount() {
		return lstMyAccount.isDisplayed();

	}

	public boolean validateWishList() {
		return lstWishList.isDisplayed();

	}

	public boolean validateShoppingCart() {
		return lstShoppingCart.isDisplayed();

	}

	public boolean validateCheckOut() {
		return lstCheckOut.isDisplayed();

	}

	public boolean validateCompanyLogo() {
		return companyLogo.isDisplayed();

	}

	public boolean validateAddTocart() {
		return btnCart.isDisplayed();

	}

	public boolean validateMyAccountLinkAtFooter() {
		return lnkMyAccount.isDisplayed();

	}

}
