package com.sdg.test;

import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.entity.DemoBean;
import com.sdg.entity.TestDemo;

public class TestCase {
	ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
	@Test
	public void test01(){
		TestDemo t1=ac.getBean("testDemo",TestDemo.class);
		//System.out.println(t1);
		System.out.println(t1.getId());
		System.out.println(t1.getName());
		System.out.println("Bean对象");
		if(t1.getUser()!=null){
			System.out.println(t1.getUser().getId());
			System.out.println(t1.getUser().getName());
		}
		
		System.out.println("编程语言：");
		if(t1.getLanguages()!=null){
			for(String language:t1.getLanguages()){
				System.out.println(language);
			}
		}
		System.out.println("城市：");
		if(t1.getCities()!=null){
			for(String city:t1.getCities()){
				System.out.println(city);
			}
		}
		System.out.println("分数：");
		if(t1.getScore()!=null){
			Set<String> keys=t1.getScore().keySet();
			for(String key:keys){
				System.out.println(key+":"+t1.getScore().get(key));
			}
		}
		System.out.println("参数：");
		if(t1.getProperties()!=null){
			Set<Object> keys=t1.getProperties().keySet();
			for(Object key:keys){
				System.out.println(key+":"+t1.getProperties().getProperty(key.toString()));
			}
		}
	}
	
	@Test
	public void test02(){
		TestDemo test2=ac.getBean("testDemo2",TestDemo.class);
		System.out.println("编程语言：");
		if(test2.getLanguages()!=null){
			for(String language:test2.getLanguages()){
				System.out.println(language);
			}
		}
		System.out.println("城市：");
		if(test2.getCities()!=null){
			for(String city:test2.getCities()){
				System.out.println(city);
			}
		}
		System.out.println("分数：");
		if(test2.getScore()!=null){
			Set<String> keys=test2.getScore().keySet();
			for(String key:keys){
				System.out.println(key+":"+test2.getScore().get(key));
			}
		}
		System.out.println("参数：");
		if(test2.getProperties()!=null){
			Set<Object> keys=test2.getProperties().keySet();
			for(Object key:keys){
				System.out.println(key+":"+test2.getProperties().getProperty(key.toString()));
			}
		}
	}
	
	@Test
	public void test03(){
		DemoBean demoBean=ac.getBean("demoBean",DemoBean.class);
		System.out.println(demoBean.getName());
		System.out.println(demoBean.getLanguage());
		System.out.println(demoBean.getCity());
		System.out.println(demoBean.getScore());
		System.out.println(demoBean.getPageSize());
	}
}
