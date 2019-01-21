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
		System.out.println("ʵ����ExampleBean��"+this);
	}
	
	//��Ϊ��ʼ���Ļص�����
	@PostConstruct
	public void init(){
		System.out.println("��ʼ��ExampleBean");
	}
	public void execute(){
		System.out.println("ִ��execute����");
	}
	
	//��Ϊ���ٵĻص�����
	@PreDestroy
	public void destroy(){
		System.out.println("����ExampleBean");
	}
}
