package com.sdg.action;

import java.util.ArrayList;
import java.util.List;

import com.sdg.entity.Emp;

public class TagsAction {
	private String name;
	private List<Emp> list;
	private List<String> strList;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getStrList() {
		return strList;
	}

	public void setStrList(List<String> strList) {
		this.strList = strList;
	}

	public List<Emp> getList() {
		return list;
	}

	public void setList(List<Emp> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute(){
		name="jack";
		age=20;
		list=new ArrayList<Emp>();
		Emp e1=new Emp();
		e1.setUsername("小米");
		Emp e2=new Emp();
		e2.setUsername("华为");
		list.add(e1);
		list.add(e2);
		strList=new ArrayList<String>();
		strList.add("aaa");
		strList.add("bbbb");
		return "success";
	}
	
}
