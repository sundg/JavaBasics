package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Foo {
	private String name;
	private int age;
	private String[] arrs;
	private List<String> list;
	private Map<String,Object> map;
	private Emp emp;
	public Foo() {
		this.name = name;
		this.age = 10;
		this.arrs = new String[]{"one","two","three"};
		this.list = new ArrayList<String>();
		list.add("java");
		list.add("javascript");
		this.map = new HashMap<String, Object>();
		map.put("one", "@");
		map.put("two", "@@");
		this.emp =new Emp();
		emp.setUsername("jack");
	}
	public String[] getArrs() {
		return arrs;
	}
	public void setArrs(String[] arrs) {
		this.arrs = arrs;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
