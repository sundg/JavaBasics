package com.sdg.entity;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("example")
@Scope("singleton")
public class ExampleBean {
	public ExampleBean(){
		System.out.println("实例化ExampleBean："+this);
	}
	
	//作为初始化的回调方法
	@PostConstruct
	public void init(){
		System.out.println("初始化ExampleBean");
	}
	public void execute(){
		System.out.println("执行execute方法");
	}
	
	//作为销毁的回调方法
	@PreDestroy
	public void destroy(){
		System.out.println("销毁ExampleBean");
	}
}
