package com.clearcode.testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.clearcode.utils.WebDriverUtils;

public class TestSetup {

	WebDriverUtils driver = new WebDriverUtils();
	@BeforeMethod
	public void launch() {
		driver.initialize();
	}
	
	@AfterMethod
	public void close() {
		driver.exit();
	}
}
