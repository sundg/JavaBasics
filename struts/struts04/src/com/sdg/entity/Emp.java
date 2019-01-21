package com.sdg.entity;

public class Emp {
	private String username;
	private String pwd;
	private String sex;
	private String city;
	private String[] ins;
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String[] getIns() {
		return ins;
	}

	public void setIns(String[] ins) {
		this.ins = ins;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
