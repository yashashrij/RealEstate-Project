package com.clearcode.utils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	Properties p;
		public void initialize() {
			String b=null;
			PropertyUtils pu = new PropertyUtils();
			p = pu.loadProperty("Project.properties");
//			Properties db = pu.loadProperty("Db.properties");
			String browser = p.getProperty("browser");
			try {
				switch(browser)
				{
				case "gc":
					b = "Google Chrome";
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "ff":
					b = "FireFox";
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "ie":
					b = "Internet Explorer";
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					break;
				default:
					b = "Default - Google Chrome";
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				ATUReports.setWebDriver(driver);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				wait = new WebDriverWait(driver,30);
				ATUReports.add("Initializing browser - "+b, LogAs.PASSED, new CaptureScreen(
	                    ScreenshotOf.DESKTOP));
			}
			catch(Exception e)
			{
				ATUReports.add("Initializing browser - "+b, e.getMessage() , LogAs.FAILED, new CaptureScreen(
	                    ScreenshotOf.DESKTOP));
			}
		}
		
		public void launchUrl() {
			String url = p.getProperty("url");
			ATUReports.add("Launch URL",url, LogAs.INFO, new CaptureScreen(
                    ScreenshotOf.BROWSER_PAGE));
			driver.get(url);
			ATUReports.add("Loaded URL",driver.getCurrentUrl() , LogAs.PASSED, new CaptureScreen(
                    ScreenshotOf.BROWSER_PAGE));
		}
		
		public void navigate(String url) {
			ATUReports.add("Navigate from "+driver.getCurrentUrl()+" to "+url, LogAs.INFO, new CaptureScreen(
                    ScreenshotOf.BROWSER_PAGE));
			driver.get(url);
			ATUReports.add("Navigation",driver.getCurrentUrl() , LogAs.PASSED, new CaptureScreen(
                    ScreenshotOf.BROWSER_PAGE));
		}
		
		public void type(By loc, String value) {
			if(value==null)
			{
				value="";
			}
			find(loc).clear();
			find(loc).sendKeys(value);
			ATUReports.add("Type into "+loc.toString(),value, LogAs.PASSED, new CaptureScreen(
                    ScreenshotOf.BROWSER_PAGE));
		}
		
		
		
		
		private WebElement find(By loc) {
			WebElement element=null;
			try
			{
				element = driver.findElement(loc);
//				wait.until(ExpectedConditions.presenceOfElementLocated(loc));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
				wait.until(ExpectedConditions.visibilityOf(element));
			}
			catch(NoSuchElementException e)
			{
				ATUReports.add("No Element Found",loc.toString(), LogAs.FAILED, new CaptureScreen(
	                    ScreenshotOf.BROWSER_PAGE));
			}
			catch(TimeoutException e)
			{
				ATUReports.add("TimeOut Waiting for the Element",loc.toString(), LogAs.FAILED, new CaptureScreen(
	                    ScreenshotOf.BROWSER_PAGE));
			}
			return element;
		}
		
		public void exit() {
			try
			{
				driver.quit();
				ATUReports.add("Closing browser", LogAs.PASSED, new CaptureScreen(
						ScreenshotOf.DESKTOP));
			}
			catch(Exception e)
			{
				ATUReports.add("Closing browser", LogAs.FAILED, new CaptureScreen(
	                    ScreenshotOf.DESKTOP));
			}
		}
}
