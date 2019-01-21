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
	
	
	//���ص���ֵ
	//������������ֵ��undefined��null��boolean��number��string
	@RequestMapping("/testOne.do")
	@ResponseBody
	public Integer testOne(){
		return 5;
	}
	
	//���ض��ֵ
	@RequestMapping("/testTwo.do")
	@ResponseBody
	public Map<String,Object> testTwo(){
		Map<String,Object> data=new HashMap<String, Object>();
		data.put("id", 1001);
		data.put("name", "����");
		
		return data;
	}
	
	//����list����
	@RequestMapping("/testThree.do")
	@ResponseBody
	public List<String> testThree(int ds){
		System.out.println(ds);
		List<String> list=new ArrayList<String>();
		list.add("����");
		list.add("����");
		list.add("����");
		return list;
	}
	
	//���ض���
	@RequestMapping("/testFour.do")
	@ResponseBody
	public User testFour(){
		User user=new User();
		user.setId(1003);
		user.setUsername("������");
		return user;
	}
	
	
	//���ض��󼯺�
	@RequestMapping("/testFive.do")
	@ResponseBody
	public List<User> testFive(){
		List<User> list=new ArrayList<User>();
		User user1=new User();
		user1.setId(1003);
		user1.setUsername("������");
		User user2=new User();
		user2.setId(1004);
		user2.setUsername("����");
		User user3=new User();
		user3.setId(1005);
		user3.setUsername("����");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
