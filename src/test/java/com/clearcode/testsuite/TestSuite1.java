package com.clearcode.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.clearcode.po.HomePage;

public class TestSuite1 extends TestSetup{

	@Test(priority=1)
	public void createPatient() throws InterruptedException {
		wdu.type(HomePage.username_ip, "admin");
		wdu.type(HomePage.pwd_ip, "pass");
		wdu.click(HomePage.login_btn);
		wdu.mouseOver(By.xpath("//div[text()='Patient/Client']"));
		wdu.click(By.xpath("//div[text()='New/Search']"));
		wdu.selectByVisibleText(By.id("form_title"), "Mr.");
	}
	
	@Test(enabled=false)
	public void test2() {
		System.out.println("This is test 2");
	}
	
}
