package com.sdg.dao;

import java.util.List;

import com.sdg.common.MyAnnotation;
import com.sdg.common.MyInterface;
import com.sdg.entity.Emp;

//@MyAnnotation
public interface EmpMapper extends MyInterface{
	List<Emp> findAll();
	
	void addEmp(Emp emp);
	
	void update(Emp emp);
	
	void delete(int empno);
}
