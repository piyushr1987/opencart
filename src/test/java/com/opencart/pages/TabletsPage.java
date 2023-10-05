package com.opencart.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.genericPage.BaseClass;

public class TabletsPage extends BaseClass {

	public TabletsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='menu']//ul[@class='nav navbar-nav']/li[4]")
	WebElement lnkTablets;

	@FindBy(id = "grid-view")
	WebElement btnGridView;

	@FindBy(xpath = "//select[@id='input-sort']/option")
	List<WebElement> drpSort;

	@FindBy(xpath = "//select[@id='input-limit']/option")
	List<WebElement> drpLimit;

	@FindBy(xpath = "//*[text()='Samsung Galaxy Tab 10.1']/parent::h4/parent::div/parent::div/child::div[@class='caption']//a")
	WebElement lnkSamsungGalaxy;

	@FindBy(xpath = "//*[@id='content']//ul[@class='thumbnails']/li[1]")
	WebElement imgSamsung;

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

	public void clickOnTablet() {
		lnkTablets.click();
	}

	public boolean ValidateTabletsPage() {
		return driver.getCurrentUrl().contains("product/category&path=57");

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

	public void clickOnSamsungGalaxy() {
		lnkSamsungGalaxy.click();
	}

	public boolean ValidateSamsungGalaxyPage() {
		return driver.getCurrentUrl().contains("/product&path=57&product_id=49");

	}

	public void clickOnSamsungGalaxyImage() {
		imgSamsung.click();
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
