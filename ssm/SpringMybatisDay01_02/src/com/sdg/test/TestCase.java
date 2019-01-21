package com.sdg.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.entity.ExampleBean;
import com.sdg.entity.User;


public class TestCase {
	//Spring����ʵ����
	@Test
	public void test01(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		
		User user=ac.getBean("user",User.class);
		System.out.println(user);
		ExampleBean ex=ac.getBean("example",ExampleBean.class);
		System.out.println(ex);
	}
	
	//Bean��������
	@Test
	public void test02(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		User userOne=ac.getBean("user",User.class);
		User userTwo=ac.getBean("user",User.class);
		System.out.println(userOne==userTwo);
		ExampleBean exOne=ac.getBean("example",ExampleBean.class);
		ExampleBean exTwo=ac.getBean("example",ExampleBean.class);
		System.out.println(exOne==exTwo);
	}
	//Bean�ĳ�ʼ�������ٵĻص�����
	@Test
	public void test03(){
		AbstractApplicationContext aac=
			new ClassPathXmlApplicationContext("spring.xml");
		ExampleBean exOne=aac.getBean("example",ExampleBean.class);
		exOne.execute();
		
		//�ر�����
		aac.close();
		
	}
	@Test
	public void test04(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		ExampleBean exOne=ac.getBean("example",ExampleBean.class);
	}

	@Test
	public void test05(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		//ExampleBean exOne=ac.getBean("example",ExampleBean.class);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
