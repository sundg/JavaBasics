package entity;

import java.io.Serializable;
import java.util.Date;

public class Cost implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer base_duration;
	private double base_cost;
	private double unit_cost;
	private String status;
	private String description;
	private Date createtime;
	private Date startetime;
	
	private String ctime;
	private String stime;
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	private String costtype;
	
	
	
	public Cost() {
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
	public void setUnit_cost(double unixCost) {
		unit_cost = unixCost;
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
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getStartetime() {
		return startetime;
	}
	public void setStartetime(Date startetime) {
		this.startetime = startetime;
	}
	public String getCosttype() {
		return costtype;
	}
	public void setCosttype(String costtype) {
		this.costtype = costtype;
	}
	
	
}
