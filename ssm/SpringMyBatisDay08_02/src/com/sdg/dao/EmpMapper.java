package com.sdg.dao;

import java.util.List;

import com.sdg.annotation.MyAnnotation;
import com.sdg.entity.Emp;

@MyAnnotation
public interface EmpMapper {
	List<Emp> findAll();
}
