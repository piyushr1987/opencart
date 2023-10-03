package com.opencart.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.genericPage.BaseClass;

public class LaptopAndNotebookPage extends BaseClass {

	public LaptopAndNotebookPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='menu']//li[@class='dropdown']/parent::ul/child::li[2]")
	WebElement lnkLapAndNote;

	@FindBy(xpath = "//*[text()='Show All Laptops & Notebooks']/parent::div[@class='dropdown-menu']//a[@class='see-all']")
	WebElement lnkShowAll;

	@FindBy(id = "list-view")
	WebElement btnListView;

	@FindBy(id = "grid-view")
	WebElement btnGridView;

	@FindBy(xpath = "//div[@class='product-thumb']//a[normalize-space()='MacBook Pro']")
	WebElement txtMac;

	@FindBy(xpath = "//div[@id='content']//ul[@class='thumbnails']//li[1]")
	WebElement imgMac;

	@FindBy(xpath = "//*[contains(@class,'mfp-conta')]//button[contains(@title,'Next (Right arrow key)')]")
	WebElement btnNext;

	@FindBy(xpath = "//*[contains(@class,'mfp-conta')]//button[contains(@title,'Close (Esc)')]")
	WebElement btnClose;

	@FindBy(id = "input-quantity")
	WebElement txtQuantity;

	@FindBy(id = "button-cart")
	WebElement btnCart;

	@FindBy(xpath = "//div[@id='cart']")
	WebElement btnViewCart;

	public void goToLaptopAndNotebook() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(lnkLapAndNote).build().perform();
		Thread.sleep(3000);
		act.moveToElement(lnkShowAll).build().perform();
		lnkShowAll.click();
	}

	public boolean ValidateLaptopAndNotebookPage() {
		return driver.getCurrentUrl().contains("route=product/category&path=18");

	}

	public boolean ValidateListViewSelection() {
		return btnListView.isSelected();

	}

	public void clickGridView() {
		btnGridView.click();
	}

	public void clickOnMacBookPro() {
		txtMac.click();
	}

	public void clickOnMacImage() {
		imgMac.click();
	}

	public void clickOnNextButton() {
		btnNext.click();
	}

	public void clickOnCloseButton() {
		btnClose.click();
	}

	public void enterQuantity(String quantity) {
		txtQuantity.clear();
		txtQuantity.sendKeys(quantity);
	}

	public void clickOnAddToCart() {
		btnCart.click();
	}

	public void clickOnViewCart() {
		btnViewCart.click();
	}

}
