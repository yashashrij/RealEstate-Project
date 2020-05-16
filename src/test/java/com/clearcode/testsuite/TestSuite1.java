package com.clearcode.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestSuite1 extends TestSetup{

	@Test
	public void test1() {
		driver.type(By.id("authUser"), "admin");
	}
	
	@Test
	public void test2() {
		System.out.println("This is test 2");
	}
	
}
