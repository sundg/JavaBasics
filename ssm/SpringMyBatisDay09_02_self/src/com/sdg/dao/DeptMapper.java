package com.sdg.dao;

import com.sdg.annotation.MyAnnotation;
import com.sdg.entity.Dept;

@MyAnnotation
public interface DeptMapper {
	void addDept(Dept dept);
	
}
