package com.sdg.dao;

import com.sdg.annotation.MyAnnotation;
import com.sdg.entity.Dept;

@MyAnnotation
public interface DeptMapper {
	void addDept(Dept dept);
	
	Dept findByDeptnoOne(int deptno);
	
	Dept findByDeptnoTwo(int deptno);
}
