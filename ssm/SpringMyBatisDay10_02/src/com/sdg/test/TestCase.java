package com.sdg.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.controller.TestController;

public class TestCase {
	@Test
	public void testOne(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		TestController tc=ac.getBean("testController",TestController.class);
		
		tc.findAll();
	}
}
