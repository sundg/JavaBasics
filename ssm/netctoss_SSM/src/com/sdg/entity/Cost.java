package com.sdg.entity;

import java.sql.Timestamp;


public class Cost {
	private Integer id;
	private String name;
	private Integer base_duration;
	private double base_cost;
	private double unit_cost;
	private String status;
	private String description;
	private Timestamp createtime;
	private Timestamp startetime;
	private String costtype;
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
	public Integer getBase_duration() {
		return base_duration;
	}
	public void setBase_duration(Integer baseDuration) {
		base_duration = baseDuration;
	}
	public double getBase_cost() {
		return base_cost;
	}
	public void setBase_cost(double baseCost) {
		base_cost = baseCost;
	}
	public double getUnit_cost() {
		return unit_cost;
	}
	public void setUnit_cost(double unitCost) {
		unit_cost = unitCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Timestamp getStartetime() {
		return startetime;
	}
	public void setStartetime(Timestamp startetime) {
		this.startetime = startetime;
	}
	public String getCosttype() {
		return costtype;
	}
	public void setCosttype(String costtype) {
		this.costtype = costtype;
	}
	
}
