package com.clearcode.utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils {
	
	WebDriver driver = null;
		public void initialize() {
			PropertyUtils pu = new PropertyUtils();
			Properties p = pu.loadProperty("Project.properties");
//			Properties db = pu.loadProperty("Db.properties");
			String browser = p.getProperty("browser");
			switch(browser)
			{
			case "gc":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "ff":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		}
		
		public void exit() {
			driver.quit();
		}
}
