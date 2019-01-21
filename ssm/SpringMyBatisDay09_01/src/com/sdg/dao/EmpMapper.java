package com.sdg.dao;

import java.util.List;

import com.sdg.annotation.MyAnnotation;
import com.sdg.common.Condition;
import com.sdg.entity.Emp;

@MyAnnotation
public interface EmpMapper {
	List<Emp> findAll();
	//���ݲ��źŲ�ѯ
	List<Emp> findByDeptno(Condition condition);
	//����нˮ��ѯ
	List<Emp> findBySalary(Condition condition);
	//���ݲ��źź�нˮ��ѯ
	List<Emp> findByDeptnoAndSalary(Condition condition);
	//����
	void updateEmp(Emp emp);
	
	List<Emp> findByDeptnoAndSalaryTwo(Condition condition);
	//����
	void updateEmpTwo(Emp emp);
	
	List<Emp> findByEmpno(Condition condition);
}
