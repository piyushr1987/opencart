package com.opencart.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.genericPage.BaseClass;

public class ComponentsPage extends BaseClass {

	public ComponentsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='menu']//li[@class='dropdown']/parent::ul/child::li[3]")
	WebElement lnkComponents;

	@FindBy(xpath = "//*[text()='Monitors (2)']/parent::li/parent::ul/li[2]")
	WebElement lstMonitors;

	@FindBy(id = "list-view")
	WebElement btnList;

	@FindBy(xpath = "//select[@id='input-sort']/option")
	List<WebElement> drpSort;

	@FindBy(xpath = "//select[@id='input-limit']/option")
	List<WebElement> drpLimit;

	@FindBy(xpath = "//*[text()='Samsung SyncMaster 941BW']/parent::h4/parent::div/parent::div/child::div[@class='caption']/descendant::a")
	WebElement lstSamsung;

	@FindBy(xpath = "//div[@class='col-sm-8']//li[@class='active']/a")
	WebElement lstReview;

	@FindBy(id = "input-name")
	WebElement txtName;

	@FindBy(id = "input-review")
	WebElement txtReview;

	@FindBy(xpath = "//input[@type='radio' and @value='3']")
	WebElement radValue;

	@FindBy(id = "button-review")
	WebElement btnContinue;

	@FindBy(id = "input-quantity")
	WebElement txtQuantity;

	@FindBy(id = "button-cart")
	WebElement btnCart;

	@FindBy(xpath = "//div[@id='cart']")
	WebElement btnViewCart;

	public void goToComponents() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(lnkComponents).build().perform();
		Thread.sleep(3000);
		act.moveToElement(lstMonitors).build().perform();
		lstMonitors.click();
	}

	public boolean ValidateMonitorsPage() {
		return driver.getCurrentUrl().contains("product/category&path=25_28");

	}

	public void clickOnListView() {
		btnList.click();
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

	public void clickOnSansungMonitor() {
		lstSamsung.click();
	}

	public void writeReview(String name, String review) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(lstReview));
		lstReview.click();
		wait.until(ExpectedConditions.visibilityOf(txtName));
		txtName.sendKeys(name);
		wait.until(ExpectedConditions.visibilityOf(txtReview));
		txtReview.sendKeys(review);
		radValue.click();
	}

	public void clickOnContinue() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", btnContinue);
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
