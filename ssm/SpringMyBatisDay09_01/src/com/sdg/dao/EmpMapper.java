package com.sdg.dao;

import java.util.List;

import com.sdg.annotation.MyAnnotation;
import com.sdg.common.Condition;
import com.sdg.entity.Emp;

@MyAnnotation
public interface EmpMapper {
	List<Emp> findAll();
	//根据部门号查询
	List<Emp> findByDeptno(Condition condition);
	//根据薪水查询
	List<Emp> findBySalary(Condition condition);
	//根据部门号和薪水查询
	List<Emp> findByDeptnoAndSalary(Condition condition);
	//更新
	void updateEmp(Emp emp);
	
	List<Emp> findByDeptnoAndSalaryTwo(Condition condition);
	//更新
	void updateEmpTwo(Emp emp);
	
	List<Emp> findByEmpno(Condition condition);
}
