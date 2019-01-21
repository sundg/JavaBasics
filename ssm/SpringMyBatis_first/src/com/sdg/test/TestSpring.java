package com.sdg.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.entity.User;

public class TestSpring {
	@Test
	public void test01(){
		//������ʵ����
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		//bean�����ʵ����
		/*
		 * bean����Ĭ�������������ʵ����ʱҲһ��ʵ������
		 * ����ͨ������lazy-init�����ӳ�ʵ����
		 */
		/*
		 * Ҳ����ʹ��init-method��������Bean����ʵ�����Ļص�����
		 * ͬ��destroy-method����
		 */
		User user=ac.getBean("user",User.class);
		
		//����ָ��ʵ����ʱ�Ļص�����
		
	}
	//Bean�����������
	/*
	 * singleton
	 * prototype
	 * request
	 * session
	 */
	//Bean�������������
	/*
	 * ʵ����init-method
	 * ��ʼ��
	 * execute
	 * ����destroy-method
	 */
	//�ӳ�Bean����ʵ����
}
