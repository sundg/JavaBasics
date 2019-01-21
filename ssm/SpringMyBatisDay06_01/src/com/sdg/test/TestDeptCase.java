package com.sdg.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.dao.DeptDAO;
import com.sdg.entity.Dept;

public class TestDeptCase {
	
	ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
	DeptDAO dao=ac.getBean("deptDAO", DeptDAO.class);
	@Test
	public void test01(){
		List<Dept> depts=dao.findAll();
		for(Dept dept:depts){
			System.out.println(dept.getDeptno()+":"+dept.getDname()+":"+dept.getDloc());
		}
	}
	
	@Test
	public void test02(){
		Dept dept=dao.findByDeptno(3);
		
			System.out.println(dept.getDeptno()+":"+dept.getDname()+":"+dept.getDloc());
	
	}
	@Test
	public void test03(){
		Dept dept=new Dept();
		dept.setDeptno(5);
		dept.setDname("交通管理部");
		dept.setDloc("中京华夏区");
		dao.add(dept);
	}
	@Test
	public void test04(){
		Dept dept=dao.findByDeptno(5);
		dept.setDloc("呼和浩特");
		dao.update(dept);
	}
	@Test
	public void test05(){
		dao.delete(5);
	}
}
