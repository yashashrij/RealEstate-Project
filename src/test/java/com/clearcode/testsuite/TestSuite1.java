package com.clearcode.testsuite;

import org.testng.annotations.Test;

public class TestSuite1 extends TestSetup{

	@Test
	public void test1() {
		System.out.println("This is test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("This is test 2");
	}

}
