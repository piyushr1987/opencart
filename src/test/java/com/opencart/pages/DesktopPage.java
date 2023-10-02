package com.opencart.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.genericPage.BaseClass;

public class DesktopPage extends BaseClass {

	public DesktopPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@id='menu']//li[@class='dropdown']/parent::ul/child::li[1]")
	WebElement lnkDesktop;

	@FindBy(xpath = "//*[@id='menu']//li[@class='dropdown']/parent::ul/child::li[1]//div[@class='dropdown-menu']//li[2]")
	WebElement drpMac;

	@FindBy(id = "list-view")
	WebElement btnList;

	@FindBy(id = "grid-view")
	WebElement btnGrid;

	@FindBy(xpath = "//*[contains(@class,'form-group ')]/label[text()='Sort By:']")
	WebElement lblSortBy;

	@FindBy(xpath = "//select[@id='input-sort']/option[1]")
	WebElement drpDefault;

	@FindBy(xpath = "//select[@id='input-sort']/option")
	List<WebElement> drpRating;

	@FindBy(xpath = "//*[contains(@class,'form-group ')]/label[text()='Show:']")
	WebElement lblShow;

	@FindBy(xpath = "//select[@id='input-limit']/option[1]")
	WebElement drpDefaultLimit;

	@FindBy(xpath = "//select[@id='input-limit']/option")
	List<WebElement> drpLimit;

	@FindBy(xpath = "//div[contains(@class,'product-l')]//div[@class='caption']//a")
	WebElement lnkiMac;

	@FindBy(xpath = "//div[@id='product-product']//ul[@class='thumbnails']/li[1]")
	WebElement imgThumbnail;

	@FindBy(xpath = "//div[contains(@class,'mfp-contai')]//button[@title='Next (Right arrow key)']")
	WebElement btnNext;

	@FindBy(xpath = "//div[contains(@class,'mfp-contai')]//button[@title='Close (Esc)']")
	WebElement btnClose;

	@FindBy(xpath = "//div[@class='col-sm-4']//div[@class='btn-group']/button[2]")
	WebElement btnCompare;

	@FindBy(xpath = "//div[@class='col-sm-9']//div[@class='form-group']/a")
	WebElement lnkCompare;

	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement lblProductCompare;

	@FindBy(xpath = "//div[@class='col-sm-12']/table//tbody[2]//input[1]")
	WebElement btnAddToCart;

	@FindBy(xpath = "//*[@id='cart-total']")
	WebElement btnCartTotal;

	@FindBy(xpath = "//ul[@class='dropdown-menu pull-right']//p//a[1]")
	WebElement lnkViewCart;

	public void goToDesktopAndClickOnMac() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(lnkDesktop).build().perform();
		Thread.sleep(3000);
		act.moveToElement(drpMac).build().perform();
		drpMac.click();
	}

	public boolean ValidateMacPage() {
		return driver.getCurrentUrl().contains("product/category&path=20_27");

	}

	public boolean validateListView() {
		return btnList.isSelected();

	}

	public void clickOnGridView() {
		btnGrid.click();
	}

	public boolean validateTextSortBy() {
		return lblSortBy.isDisplayed();

	}

	public boolean validateSortByDropDown() {
		return drpDefault.isSelected();

	}

	public void selectCatagory(String sorttext) {
		for (int i = 0; i < drpLimit.size(); i++) {
			if (drpRating.get(i).getText().equalsIgnoreCase(sorttext)) {
				drpRating.get(i).click();
				break;
			}
		}
	}

	public boolean validateTextShow() {
		return lblShow.isDisplayed();

	}

	public boolean validateShowByDropdown() {
		return drpDefaultLimit.isSelected();

	}

	public void selectVariousValues(String value) {
		for (int i = 0; i < drpRating.size(); i++) {
			if (drpRating.get(i).getText().equalsIgnoreCase(value)) {
				drpRating.get(i).click();
				break;
			}
		}
	}

	public void clickOnImac() {
		lnkiMac.click();
	}

	public boolean ValidateImacPage() {
		return driver.getCurrentUrl().contains("product_id=41&sort=p.price&order=ASC");

	}

	public void clickOnImageOfImac() {
		imgThumbnail.click();
	}

	public void clickOnNextButton() {
		btnNext.click();
	}

	public void clickOnCloseButton() {
		btnClose.click();
	}

	public void clickOnCompareThisProduct() {
		btnCompare.click();
		driver.navigate().back();
	}

	public void clickOnProductCompare() {
		lnkCompare.click();
	}

	public boolean ValidateProductComparisonDetails() {
		return lblProductCompare.isDisplayed();

	}

	public void clickAddToCart() {
		btnAddToCart.click();
	}

	public void clickCartTotal() {
		explicitWaitCondition(btnCartTotal);
		btnCartTotal.click();
	}

	public void clickOnViewCart() {

		lnkViewCart.click();
	}

	public boolean ValidateCheckOutPage() {
		return driver.getCurrentUrl().contains("checkout/cart");

	}
}
