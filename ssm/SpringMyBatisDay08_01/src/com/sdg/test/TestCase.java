package com.sdg.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.dao.EmpMapper;
import com.sdg.entity.Emp;

public class TestCase {
	ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
	EmpMapper mapper=ac.getBean("empMapper",EmpMapper.class);
	@Test
	public void test01(){
		List<Emp> emps=mapper.findAll();
		for(Emp emp:emps){
			System.out.println(emp.getEname()+":"+emp.getSalary());
		}
	}
	
	@Test
	public void test02(){
		Emp emp =new Emp();
		emp.setBonus(999.99);
		emp.setDeptno(6);
		emp.setEname("Ð¡Èý");
		emp.setHiredate(new Date(System.currentTimeMillis()));
		emp.setSalary(99999.99);
		mapper.addEmp(emp);
		List<Emp> emps=mapper.findAll();
		for(Emp empa:emps){
			System.out.println(empa.getEname()+":"+empa.getSalary());
		}
	}
	
	@Test
	public void test03(){
		List<Emp> emps=mapper.findAll();
		
		Emp emp =emps.get(emps.size()-1);
		emp.setBonus(999.99);
		emp.setDeptno(6);
		emp.setEname("Ð¡si");
		emp.setHiredate(new Date(System.currentTimeMillis()));
		emp.setSalary(99999.99);
		mapper.update(emp);
	}
	
	@Test
	public void tets04(){
		mapper.delete(1005);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
