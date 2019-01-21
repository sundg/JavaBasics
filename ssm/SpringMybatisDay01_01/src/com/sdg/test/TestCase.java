package com.sdg.test;


import java.util.Date;
import java.util.Calendar;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.entity.ExampleBean;
import com.sdg.entity.User;

public class TestCase {
	//Spring容器的实例化
	@Test
	public void testOne(){
		String xml="spring.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(xml);
		System.out.println(ac);
		User user=(User) ac.getBean("user");
		System.out.println(user);
		
		System.out.println(user.getName());
		System.out.println(user.getId());
	}
	
	//实例化Bean方式
	@Test
	public void testTwo(){
		//第一步实例化容器
		String xml="spring.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(xml);
		Calendar c1=(Calendar) ac.getBean("gregorianCalendar");
		System.out.println(c1);
		
		Calendar c2=ac.getBean("calendar", Calendar.class);
		System.out.println(c2);
		
		Date d1=ac.getBean("date",Date.class);
		System.out.println(d1);
	}

	
	//Bean的作用域
	@Test
	public void testThree(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		User userOne=ac.getBean("userOne",User.class);
		User userTwo=ac.getBean("userOne",User.class);
		
		System.out.println(userOne==userTwo);
		
		User userThree=ac.getBean("userTwo",User.class);
		System.out.println(userTwo==userThree);
		
		User userFour=ac.getBean("userTwo",User.class);
		System.out.println(userFour==userThree);
		User userFive=ac.getBean("user",User.class);
		System.out.println(userOne==userFive);
	}
	
	
	//Bean的生命周期
	@Test
	public void testFour(){
		AbstractApplicationContext aac=new ClassPathXmlApplicationContext("spring.xml");
		ExampleBean exampleBean=aac.getBean("exampleBean",ExampleBean.class);
		exampleBean.execute();
		aac.close();
	}
	
	//Bean的延迟实例化
	@Test
	public void testFive(){
		//实例化Spring容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		
		ac.getBean("example",ExampleBean.class);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
