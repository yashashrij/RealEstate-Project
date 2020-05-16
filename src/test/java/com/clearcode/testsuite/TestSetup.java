package com.clearcode.testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.clearcode.utils.WebDriverUtils;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	  MethodListener.class })
public class TestSetup {
	{
        System.setProperty("atu.reporter.config", "src/test/resources/atu.properties");
    }
	WebDriverUtils driver = new WebDriverUtils();
	@BeforeClass
	public void launch() {
		driver.initialize();
	}
	
	@BeforeMethod
	public void loadUrl() {
		driver.launchUrl();
	}
	
	@AfterClass
	public void close() {
		driver.exit();
	}
	
//	@AfterSuite
//	public void openReport() {
//		String loc = System.getProperty("user.dir");
//		driver.initialize();
//		driver.navigate("file:///"+loc+"/ATU%20Reporter/index.html");
//	}
}
