package com.sdg.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.entity.Company;
import com.sdg.entity.Dept;
import com.sdg.entity.Emp;
import com.sdg.entity.User;

public class TestCase {
	@Test
	public void test01(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		User u=ac.getBean("user",User.class);
		
		for(String list:u.getList()){
			System.out.println(list);
		}
		for(String set:u.getSet()){
			System.out.println(set);
		}
		for(String key:u.getMap().keySet()){
			System.out.println(key+":"+u.getMap().get(key));
		}
		for(Object key:u.getProperties().keySet()){
			System.out.println(key+":"+u.getProperties().getProperty(key.toString()));
		}
	}
	
	//注入方式
	@Test
	public void test02(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		Emp emp=ac.getBean("emp",Emp.class);
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		Dept dept=ac.getBean("dept",Dept.class);
		System.out.println(dept.getId());
		System.out.println(dept.getName());
		Emp emp1=ac.getBean("emp1",Emp.class);
		System.out.println(emp1.getId());	
	}
	
	
	//自动装配
	@Test
	public void test03(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		Company comp=ac.getBean("company",Company.class);
		if(comp.getDept()!=null){
			System.out.println(comp.getDept().getId());
		}
		if(comp.getEmp()!=null){
			System.out.println(comp.getEmp().getName());
		}
	}
	//参数值
	@Test
	public void test04(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		User u=ac.getBean("user",User.class);
		if(u.getList()!=null){
			for(String list:u.getList()){
				System.out.println(list);
			}
		}
		if(u.getSet()!=null){
			for(String set:u.getSet()){
				System.out.println(set);
			}
		}
		if(u.getMap().keySet()!=null){
			for(String key:u.getMap().keySet()){
				System.out.println(key+":"+u.getMap().get(key.toString()));
			}
		}
		if(u.getProperties().keySet()!=null){
			for(Object key:u.getProperties().keySet()){
				System.out.println(key+":"+u.getProperties().getProperty(key.toString()));
			}
		}
	}
	
	
	
}
