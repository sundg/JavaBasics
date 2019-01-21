package com.sdg.entity;

public class Dept {
	private Integer id;
	private String name;
	public Dept(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Dept() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
