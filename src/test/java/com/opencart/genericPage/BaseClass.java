package com.opencart.genericPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger Logger;
	public static WebDriverWait wait;

	public BaseClass() throws IOException {
		FileInputStream fis;
		fis = new FileInputStream(
				"C:\\Users\\piyush ramteke\\eclipse-workspace\\opencart\\Configuration\\commonData.properties");
		prop = new Properties();
		prop.load(fis);
	}

	public void intialization() {
		Logger = Logger.getLogger("ebay");
		PropertyConfigurator.configure("log4j.properties");
		Logger.info("open the chrome browser");
		String browserName = prop.getProperty("browserName");

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\piyush ramteke\\eclipse-workspace\\opencart\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		} else if (browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\piyush ramteke\\eclipse-workspace\\opencart\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browserName.contains("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\piyush ramteke\\eclipse-workspace\\opencart\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("Please giver correct browser name");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void captureScreen(WebDriver driver, String tname) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileHandler.copy(source, target);
		System.out.println("Screen shot taken");

	}

	public void explicitWaitCondition(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
