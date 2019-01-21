package com.sdg.test;

import java.util.List;

import org.junit.Test;

import com.sdg.dao.DeptDAO;
import com.sdg.entity.Dept;

public class TestCase {
	DeptDAO dao=new DeptDAO();
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
		dept.setDeptno(6);
		dept.setDloc("中山陵");
		dept.setDname("历史文化部");
		dao.addDept(dept);
	}
	@Test
	public void test04(){
		dao.delete(6);
	}
	@Test
	public void test05(){
		Dept dept=dao.findByDeptno(3);
		dept.setDname("水质管理部");
		dao.update(dept);
	}
	@Test
	public void test06(){
		List<Dept> depts=dao.findAll();
		for(Dept dept:depts){
			System.out.println(dept.getDeptno()+":"+dept.getDname()+":"+dept.getDloc());
		}
	}
	@Test
	public void test07(){
		List<Dept> depts=dao.findAll();
		for(Dept dept:depts){
			System.out.println(dept.getDeptno()+":"+dept.getDname()+":"+dept.getDloc());
		}
	}
	
	
}
