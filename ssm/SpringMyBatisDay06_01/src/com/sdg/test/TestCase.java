package com.sdg.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.dao.EmpDAO;
import com.sdg.entity.Emp;

public class TestCase {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		EmpDAO empDAO=ac.getBean("empDAO",EmpDAO.class);
	@Test
	public void test01(){
		List<Emp> emps=empDAO.findAll();
		for(Emp emp:emps){
			System.out.println(emp.getEname()+":"+emp.getSalary());
		}
	}
	@Test
	public void tets02(){
		Emp emp=empDAO.findByEmpno(1002);
		System.out.println(emp.getEname()+":"+emp.getSalary());
	}
	@Test
	public void test03(){
		Emp emp=new Emp();
		emp.setEmpno(null);
		emp.setEname("张三分");
		emp.setSalary(88888.88);
		emp.setBonus(888.88);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		emp.setDeptno(5);
		
		empDAO.save(emp);
		
	}
	@Test
	public void test04(){
		Emp emp=empDAO.findByEmpno(1005);
		emp.setEname("美猴王");
		
		empDAO.update(emp);
		
	}
	
	
	@Test
	public void tets05(){
		empDAO.delete(1005);
	}
}
