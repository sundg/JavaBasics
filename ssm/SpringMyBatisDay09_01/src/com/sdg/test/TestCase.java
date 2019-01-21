package com.sdg.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.common.Condition;
import com.sdg.dao.EmpMapper;
import com.sdg.entity.Emp;

public class TestCase {
	ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
	EmpMapper empMapper=ac.getBean("empMapper", EmpMapper.class);
	@Test
	public void test01(){
		Condition cond=new Condition();
		cond.setDeptno(1);
		List<Emp> emps=empMapper.findByDeptno(cond);
		for(Emp emp:emps){
			System.out.println(emp.getEname()+":"+emp.getEmpno());
		}
	}
	
	
	@Test
	public void test02(){
		Condition cond=new Condition();
		cond.setSalary(50000D);
		List<Emp> emps=empMapper.findBySalary(cond);
		for(Emp emp:emps){
			System.out.println(emp.getEname()+":"+emp.getEmpno());
		}
	}
	@Test
	public void test03(){
		//根据部门号和薪水查询
		Condition cond=new Condition();
		cond.setDeptno(1);
		//cond.setSalary(40000.0);
		List<Emp> emps=empMapper.findByDeptnoAndSalary(cond);
		for(Emp emp:emps){
			System.out.println(emp.getEname()+":"+emp.getEmpno());
		}
	}
	@Test
	public void test04(){
		//根据部门号和薪水查询
		Emp emp=new Emp();
		emp.setEmpno(1003);
		emp.setEname("中三");
		emp.setSalary(66666.66);
		emp.setDeptno(3);
		empMapper.updateEmp(emp);
	}
	@Test
	public void test05(){
		//trim替换where
		Condition cond=new Condition();
		cond.setDeptno(1);
		//cond.setSalary(40000.0);
		List<Emp> emps=empMapper.findByDeptnoAndSalaryTwo(cond);
		for(Emp emp:emps){
			System.out.println(emp.getEname()+":"+emp.getEmpno());
		}
	}
	@Test
	public void test06(){
		//trim替换set
		Emp emp=new Emp();
		emp.setEmpno(1009);
		emp.setEname("中三");
		emp.setSalary(66666.66);
		emp.setDeptno(3);
		empMapper.updateEmpTwo(emp);
	}
	
	
	@Test
	public void test07(){
		List<Integer> empnos=new ArrayList<Integer>();
		empnos.add(1003);
		empnos.add(1001);
		empnos.add(1005);
		empnos.add(1007);
		Condition condition=new Condition();
		condition.setEmpnos(empnos);
		List<Emp> emps=empMapper.findByEmpno(condition);
		for(Emp emp:emps){
			System.out.println(emp.getEname()+":"+emp.getEmpno());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
