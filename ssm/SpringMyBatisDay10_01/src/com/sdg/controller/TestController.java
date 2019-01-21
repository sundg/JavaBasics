package com.sdg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdg.entity.User;

@Controller
@RequestMapping("/test")
public class TestController {
	
	
	//返回单个值
	//基本数据类型值：undefined，null，boolean，number，string
	@RequestMapping("/testOne.do")
	@ResponseBody
	public Integer testOne(){
		return 5;
	}
	
	//返回多个值
	@RequestMapping("/testTwo.do")
	@ResponseBody
	public Map<String,Object> testTwo(){
		Map<String,Object> data=new HashMap<String, Object>();
		data.put("id", 1001);
		data.put("name", "张三");
		
		return data;
	}
	
	//返回list集合
	@RequestMapping("/testThree.do")
	@ResponseBody
	public List<String> testThree(int ds){
		System.out.println(ds);
		List<String> list=new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("忘我");
		return list;
	}
	
	//返回对象
	@RequestMapping("/testFour.do")
	@ResponseBody
	public User testFour(){
		User user=new User();
		user.setId(1003);
		user.setUsername("张三丰");
		return user;
	}
	
	
	//返回对象集合
	@RequestMapping("/testFive.do")
	@ResponseBody
	public List<User> testFive(){
		List<User> list=new ArrayList<User>();
		User user1=new User();
		user1.setId(1003);
		user1.setUsername("张三丰");
		User user2=new User();
		user2.setId(1004);
		user2.setUsername("李四");
		User user3=new User();
		user3.setId(1005);
		user3.setUsername("王五");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
