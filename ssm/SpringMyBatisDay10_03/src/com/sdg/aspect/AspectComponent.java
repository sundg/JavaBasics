package com.sdg.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//�������
@Component
@Aspect
public class AspectComponent {
	
	@Before("within(com.sdg.controller.*)")
	public void one(){
		System.out.println("ǰ��֪ͨ");
	}
	
	@AfterReturning("execution(public String findAll())")
	public void two(){
		System.out.println("����֪ͨ");
	}
	
	@After("bean(testController)")
	public void three(){
		System.out.println("����֪ͨ");
	}
	
	@AfterThrowing(throwing="ex",pointcut="within(com.sdg.controller.*)")
	public void four(Exception ex){
		System.out.println("�쳣֪ͨ");
		
		StackTraceElement[] element=ex.getStackTrace();
		//��¼�쳣��Ϣ
		System.out.println("--->"+element[0].toString());
	}
	
	@Around("within(com.sdg.controller.*)")
	public void five(ProceedingJoinPoint point) throws Throwable{
		System.out.println("����֪ͨ��ǰ�ò���");
		//ִ��Ŀ������ķ���
		point.proceed();
		System.out.println("����֪ͨ�ĺ��ò���");
	}
}
