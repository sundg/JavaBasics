package com.sdg.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

//�������
public class AspectComponent {
	
	public void one(){
		System.out.println("ǰ��֪ͨ");
	}
	public void two(){
		System.out.println("����֪ͨ");
	}
	public void three(){
		System.out.println("����֪ͨ");
	}
	public void four(Exception ex){
		System.out.println("�쳣֪ͨ");
		
		StackTraceElement[] element=ex.getStackTrace();
		//��¼�쳣��Ϣ
		System.out.println("--->"+element[0].toString());
	}
	public void five(ProceedingJoinPoint point) throws Throwable{
		System.out.println("����֪ͨ��ǰ�ò���");
		//ִ��Ŀ������ķ���
		point.proceed();
		System.out.println("����֪ͨ�ĺ��ò���");
	}
}
