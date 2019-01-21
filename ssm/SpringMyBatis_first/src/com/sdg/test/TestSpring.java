package com.sdg.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdg.entity.User;

public class TestSpring {
	@Test
	public void test01(){
		//容器的实例化
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		//bean对象的实例化
		/*
		 * bean对象默认情况下在容器实例化时也一起实例化，
		 * 可以通过配置lazy-init属性延迟实例化
		 */
		/*
		 * 也可以使用init-method属性设置Bean对象实例化的回调函数
		 * 同理destroy-method属性
		 */
		User user=ac.getBean("user",User.class);
		
		//可以指定实例化时的回调方法
		
	}
	//Bean对象的作用域
	/*
	 * singleton
	 * prototype
	 * request
	 * session
	 */
	//Bean对象的生命周期
	/*
	 * 实例化init-method
	 * 初始化
	 * execute
	 * 销毁destroy-method
	 */
	//延迟Bean对象实例化
}
