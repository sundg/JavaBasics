package com.sdg.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestDemo {
	//基本值
	private Integer id;
	private String name;
	
	//Bean对象
	private User user;

	//集合
	private List<String> languages;
	private Set<String> cities;
	private Map<String,Object> score;
	private Properties properties;
	
	
	
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	public Set<String> getCities() {
		return cities;
	}
	public void setCities(Set<String> cities) {
		this.cities = cities;
	}
	public Map<String, Object> getScore() {
		return score;
	}
	public void setScore(Map<String, Object> score) {
		this.score = score;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
