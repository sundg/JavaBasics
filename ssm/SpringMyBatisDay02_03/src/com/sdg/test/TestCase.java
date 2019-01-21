package com.sdg.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.entity.Manager;
import com.sdg.entity.Programmer;
import com.sdg.entity.Student;
import com.sdg.entity.Teacher;

public class TestCase {
	
	ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
	
	//@Autowired/@Qualifier��ʽ�Թ�������ʽע��
	@Test
	public void test01(){
		Programmer prog=ac.getBean("programmer",Programmer.class);
		System.out.println(prog);
		System.out.println(prog.getComputer());
		System.out.println(prog.getComputer().getName());
	}
	//@Autowired/@Qualifier��ʽ��Setter��ʽע��
	@Test
	public void test02(){
		Teacher teacher=ac.getBean("teacher",Teacher.class);
		System.out.println(teacher);
		System.out.println(teacher.getComputer());
		System.out.println(teacher.getComputer().getPrice());
	}
	
	//@Autowired/@Qualifier��ʽ������������
	@Test
	public void test03(){
		Student stu=ac.getBean("student",Student.class);
		System.out.println(stu);
		System.out.println(stu.getCompuer());
		System.out.println(stu.getCompuer().getName());
	}
	
	
	//@Resource��ʽ��setter��ʽע��
	@Test
	public void test04(){
		Manager manager=ac.getBean("manager",Manager.class);
		System.out.println(manager);
		System.out.println(manager.getComputer());
		System.out.println(manager.getComputer().getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
