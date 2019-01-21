package com.sdg.action;

import java.util.HashMap;
import java.util.Map;

import com.sdg.entity.Emp;

public class UIAction {
	private Emp emp;
	private Map<String,Object> map;
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String execute(){
		emp=new Emp();
		emp.setUsername("jack");
		emp.setPwd("1234");
		emp.setSex("f");
		map=new HashMap<String, Object>();
		map.put("m", "ÄÐ");
		map.put("f", "Å®");
		emp.setCity("nj");
		emp.setIns(new String[]{"cooking","sleeping"});
		return "success";
	}
	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
}
