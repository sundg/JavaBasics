package com.sdg.test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.sdg.dao.EmpDAO;
import com.sdg.entity.Emp;



public class TestCase {
	EmpDAO empDAO=new EmpDAO();
	@Test
	public  void test01(){
        List<Emp> emps=empDAO.findAll();
        for (Emp emp:emps){
            System.out.println(emp.getEname()+":"+emp.getSalary());
        }
	}
	@Test
	public void tets02(){
		Emp emp=empDAO.findByEmpno(1003);
		System.out.println(emp.getEname()+":"+emp.getSalary());
	}
	
	public void test03(){
		Emp emp=new Emp();
		emp.setEname(" ‘ ‘ø¥");
		emp.setSalary(88888.88);
		emp.setBonus(888.88);
		emp.setHiredate(new Date(System.currentTimeMillis()));
		emp.setDeptno(1);
		empDAO.addEmp(emp);
	}
	
	@Test
	public void test04(){
		Emp emp=empDAO.findByEmpno(1003);
		emp.setEname("ÀÔŒÚø’");
		empDAO.update(emp);
	}
	@Test
	public void test05(){
		empDAO.delete(1005);
	}
	@Test
	public void test06(){
		Map<String,Object> map=empDAO.findEmpAndDeptByEmpno(1004);
		Set<String> keys=map.keySet();
		for(String key:keys){
			System.out.println(key+":"+map.get(key));
		}
	}
	
	
	@Test
	public void test07(){
		List<Map<String,Object>> list=empDAO.findEmpAndDept();
		for(Map<String,Object> map:list){
			Set<String> keys=map.keySet();
			for(String key:keys){
				System.out.println(key+":"+map.get(key));
			}
			System.out.println("============================");
		}
	}
	
	
	
	
	
	
	
	
	
}