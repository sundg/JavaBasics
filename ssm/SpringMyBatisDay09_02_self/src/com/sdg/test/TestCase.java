package com.sdg.test;


import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.dao.DeptMapper;
import com.sdg.dao.EmpMapper;
import com.sdg.entity.Dept;
import com.sdg.entity.Emp;



public class TestCase {
	ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
	EmpMapper empMapper=ac.getBean("empMapper",EmpMapper.class);
	DeptMapper deptMapper=ac.getBean("deptMapper",DeptMapper.class);
	
	@Test
	public void test01(){
		Dept dept=new Dept();
		dept.setDname("ʷ�ٷ�");
		dept.setDloc("�л���");
		deptMapper.addDept(dept);
		
		Emp emp =new Emp();
		emp.setEname("�ǲ�˹");
		emp.setSalary(99999.99);
		emp.setBonus(999.99);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		emp.setDeptno(dept.getDeptno());
		empMapper.addEmp(emp);
	}
	
	
	@Test
	public void test02(){
		Emp emp=empMapper.findEmpAndDeptByEmpno(1007);
		System.out.println(emp.getEname()+":"+emp.getDeptno()+":"+
				emp.getDept().getDeptno()+":"+emp.getDept().getDname());
	}
	
	//null:null:9:ʷ�ٷ�
	@Test
	public void test03(){
		Emp emp=empMapper.findEmpAndDeptByEmpnoTwo(1007);
		System.out.println(emp.getEname()+":"+emp.getDeptno()+":"+
				emp.getDept().getDeptno()+":"+emp.getDept().getDname());
	}
	
	
	
	
	
}
