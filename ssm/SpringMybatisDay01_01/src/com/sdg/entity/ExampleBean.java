package com.sdg.entity;

public class ExampleBean {
	public ExampleBean(){
		System.out.println("ʵ����ExampleBean��"+this);
	}
	
	//��Ϊ��ʼ���Ļص�����
	public void init(){
		System.out.println("��ʼ��ExampleBean");
	}
	public void execute(){
		System.out.println("ִ��execute����");
	}
	
	//��Ϊ���ٵĻص�����
	public void destroy(){
		System.out.println("����ExampleBean");
	}
}
