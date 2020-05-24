package com.clearcode.testsuite;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.clearcode.po.HomePage;
import com.clearcode.po.MenuBar;
import com.clearcode.po.PatientPage;

import dataProvider.LoginData;

public class TestSuite1 extends TestSetup{

	@Test(priority=1,dataProvider="CreatePatient",dataProviderClass=LoginData.class)
	public void createPatient(String user, String pwd, String title, String fname, String lname) throws InterruptedException {
		wdu.type(HomePage.username_ip, user);
		wdu.type(HomePage.pwd_ip, pwd);
		wdu.click(HomePage.login_btn);
		wdu.mouseOver(MenuBar.patient_menu);
		wdu.click(MenuBar.newPatient_menu);
		wdu.selectByVisibleText(PatientPage.title_select, title);
		wdu.type(PatientPage.fname_ip, fname);
		wdu.type(PatientPage.lname_ip, lname);
		
	}
	
	@Test(enabled=false,dataProvider="SearchPatient",dataProviderClass=LoginData.class)
	public void searchPatient(String user, String pwd, String title, String fname, String lname) {
		wdu.type(HomePage.username_ip, user);
		wdu.type(HomePage.pwd_ip, pwd);
		wdu.click(HomePage.login_btn);
		wdu.mouseOver(MenuBar.patient_menu);
		wdu.click(MenuBar.newPatient_menu);
		wdu.selectByVisibleText(PatientPage.title_select, title);
		wdu.type(PatientPage.fname_ip, fname);
		wdu.type(PatientPage.lname_ip, lname);
	}
	
}
