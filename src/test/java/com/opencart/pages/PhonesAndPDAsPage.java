package com.opencart.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.genericPage.BaseClass;

public class PhonesAndPDAsPage extends BaseClass {

	public PhonesAndPDAsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='menu']//ul[@class='nav navbar-nav']/li[6]")
	WebElement lnkPhonesAndPDAs;

	@FindBy(id = "grid-view")
	WebElement btnGridView;

	@FindBy(xpath = "//select[@id='input-sort']/option")
	List<WebElement> drpSort;

	@FindBy(xpath = "//select[@id='input-limit']/option")
	List<WebElement> drpLimit;

	@FindBy(xpath = "//div[@class='row'][2]//div[@class='caption']//a[text()='iPhone']")
	WebElement lnlIphone;

	@FindBy(xpath = "//*[@id='content']//ul[@class='thumbnails']/li[1]")
	WebElement imgIphone;

	@FindBy(xpath = "//button[contains(@class,'mfp-arrow mfp-arrow-r')]")
	WebElement btnNext;

	@FindBy(xpath = "//button[contains(@class,'mfp-close')]")
	WebElement btnClose;

	@FindBy(id = "input-quantity")
	WebElement txtQuantity;

	@FindBy(id = "button-cart")
	WebElement btnCart;

	@FindBy(xpath = "//div[@id='cart']")
	WebElement btnViewCart;

	public void clickOnPhonesAndPDAs() {
		lnkPhonesAndPDAs.click();
	}

	public boolean ValidatePhonesAndPDAsPage() {
		return driver.getCurrentUrl().contains("oute=product/category&path=24");

	}

	public void clickOnGridView() {
		btnGridView.click();
	}

	public void sortTheMonitors(String sort) {
		for (int i = 0; i < drpSort.size(); i++) {
			if (drpSort.get(i).getText().equalsIgnoreCase(sort)) {
				drpSort.get(i).click();
				break;
			}
		}
	}

	public void showTheMonitorsRange(String range) {
		for (int i = 0; i < drpLimit.size(); i++) {
			if (drpLimit.get(i).getText().equalsIgnoreCase(range)) {
				drpLimit.get(i).click();
				break;
			}
		}
	}

	public void clickOnIphone() {
		lnlIphone.click();
	}

	public boolean ValidateIphonePage() {
		return driver.getCurrentUrl().contains("product&path=24&product_id=40");

	}

	public void clickOnIphoneImage() {
		imgIphone.click();
	}

	public void clickOnNextButton() {
		btnNext.click();
	}

	public void clickOnCloseButton() {
		btnClose.click();
	}

	public void enterQuantity(String quant) {
		txtQuantity.clear();
		txtQuantity.sendKeys(quant);
	}

	public void clickOnAddToCart() {
		btnCart.click();
	}

	public void clickOnViewCart() {
		btnViewCart.click();
	}

}
