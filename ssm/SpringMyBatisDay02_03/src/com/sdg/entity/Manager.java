package com.sdg.entity;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Manager {
	private Computer computer;

	public Computer getComputer() {
		return computer;
	}
	
	@Resource(name="computer")
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
}
