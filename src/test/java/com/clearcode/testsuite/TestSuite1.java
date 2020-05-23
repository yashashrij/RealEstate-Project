package com.clearcode.testsuite;

import org.testng.annotations.Test;

import com.clearcode.po.HomePage;
import com.clearcode.po.MenuBar;
import com.clearcode.po.PatientPage;

import dataProvider.LoginData;

public class TestSuite1 extends TestSetup{

	@Test(priority=1,dataProvider="negativeLogin",dataProviderClass=LoginData.class)
	public void createPatient(String desc, String user, String pwd) throws InterruptedException {
		wdu.type(HomePage.username_ip, user);
		wdu.type(HomePage.pwd_ip, pwd);
		wdu.click(HomePage.login_btn);
//		wdu.mouseOver(MenuBar.patient_menu);
//		wdu.click(MenuBar.newPatient_menu);
//		wdu.selectByVisibleText(PatientPage.title_select, "Mr.");
	}
	
	@Test(enabled=false)
	public void test2() {
		System.out.println("This is test 2");
	}
	
}
