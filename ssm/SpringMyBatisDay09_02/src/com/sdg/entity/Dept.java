package com.sdg.entity;

import java.util.List;

public class Dept {
	private Integer deptno;
	private String dname;
	private String dloc;
	
	//��ӹ������ԣ����ڷ�װ��Ӧ��Ա������
	private List<Emp> emps;
	
	
	
	
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDloc() {
		return dloc;
	}
	public void setDloc(String dloc) {
		this.dloc = dloc;
	}
	

}
