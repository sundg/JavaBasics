package com.sdg.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.dao.DeptMapper;
import com.sdg.dao.EmpMapper;
import com.sdg.dao.QuestionMapper;
import com.sdg.entity.Dept;
import com.sdg.entity.Emp;
import com.sdg.entity.Question;



public class TestCase {
	ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
	EmpMapper empMapper=ac.getBean("empMapper",EmpMapper.class);
	DeptMapper deptMapper=ac.getBean("deptMapper",DeptMapper.class);
	QuestionMapper qMapper=ac.getBean("questionMapper",QuestionMapper.class);
	@Test
	public void test01(){
		Dept dept=new Dept();
		dept.setDname("市场部");
		
		deptMapper.addDept(dept);
		System.out.println(dept.getDeptno());
		
		Emp emp=new Emp();
		emp.setEname("小吃");
		emp.setSalary(99999.99);
		emp.setBonus(999.99);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		emp.setDeptno(dept.getDeptno());
		empMapper.addEmp(emp);
	}
	
	@Test
	public void test02(){
		Emp emp =empMapper.findEmpAndDeptByEmpnoOne(1003);
		System.out.println(emp.getEname()+":"+
				emp.getDept().getDname()+emp.getDeptno()+
				":"+emp.getDept().getDeptno());
	}
	
	//多对一的嵌套结果查询
	@Test
	public void test03(){
		Emp emp=empMapper.findEmpAndDeptByEmpnoTwo(1003);
		System.out.println(emp.getEname()+":"+
				emp.getDept().getDname()+emp.getDeptno()+
				":"+emp.getDept().getDeptno());
	}
	
	
	//一对多的嵌套查询
	@Test
	public void test04(){
		Dept dept=deptMapper.findByDeptnoOne(1);
		System.out.println(dept.getDname());
		List<Emp> emps=dept.getEmps();
		for(Emp emp:emps){
			System.out.println(emp.getEname());
		}
	}
	
	
	//一对多的嵌套结果查询
	@Test
	public void test05(){
		Dept dept=deptMapper.findByDeptnoTwo(4);
		System.out.println(dept.getDname());
		List<Emp> emps=dept.getEmps();
		for(Emp emp:emps){
			System.out.println(emp.getEname());
		}
	}
	
	//鉴别器
	@Test
	public void test06(){
		List<Question> questions=qMapper.findAll();
		for(Question question:questions){
			System.out.println(question);
			System.out.println(question.getId()+":"+question.getTitle()+":"+question.getType());
			System.out.println("===================================");
		}
	}
	
	
	
	
	
	
	
}
