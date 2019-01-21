package com.sdg.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.sdg.dao.DeptDAO;
import com.sdg.dao.EmpMapper;
import com.sdg.entity.Dept;
import com.sdg.entity.Emp;
import com.sdg.util.MyBatisUtil;

public class TestCase {
	@Test
	public void test01(){
		DeptDAO dao=new DeptDAO();
		List<Dept> depts=dao.findAll();
		for(Dept dept:depts){
			System.out.println(dept.getId()+":"+dept.getName()+":"+dept.getLoc());
		}
	}
	@Test
	public void tets02(){
		SqlSession ss=MyBatisUtil.getSession();
		EmpMapper mapper=ss.getMapper(EmpMapper.class);
		System.out.println("mapper="+mapper);
		List<Emp> emps=mapper.findAll();
		for(Emp emp:emps){
			System.out.println(emp.getEname()+":"+emp.getSalary());
		}
	}
}
