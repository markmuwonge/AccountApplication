package com.qa.AccountApplication;

import org.junit.Test;

import junit.framework.TestCase;

public class Test_NumberOfAccountsByFirstName extends TestCase {
	
//	@Test
//	public void test1()
//	{
//		Service service = new Service();
//		assertEquals(1, service.numberOfAccountsByFirstName("Mark"));
//	}
	
	@Test
	public void test2()
	{
		Service service = new Service();
		assertEquals(1, service.numberOfAccountsByFirstName("mark"));
	}
	

}
