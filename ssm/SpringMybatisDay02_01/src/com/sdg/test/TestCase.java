package com.sdg.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.entity.Company;
import com.sdg.entity.Dept;
import com.sdg.entity.Emp;

public class TestCase {
	ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
	//Setterע��
	@Test
	public void test01(){
		Emp emp=ac.getBean("emp",Emp.class);
		System.out.println(emp.getName());
	}
	
	//������ע��
	@Test
	public void test02(){
		
		Dept dept=ac.getBean("dept",Dept.class);
		System.out.println(dept.getName());
		System.out.println(dept.getId());
		System.out.println(dept);
	}
	
	//�Զ�װ��
	@Test
	public void test03(){
		Company company=ac.getBean("company",Company.class);
		System.out.println(company.getEmp().getName());
		System.out.println("=====================");
		System.out.println(company.getDp().getName());
		System.out.println(company.getDp());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
