package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.junit.Test;

import util.DateProcessor;



import entity.User;

public class TestJson {
	@Test
	public void test1(){
		User u=new User();
		u.setAge(10);
		u.setName("张三");
		u.setDate(new Date());
		//将user对象转成字符串
		//String data=JSONObject.fromObject(u).toString();
		JsonConfig config=new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateProcessor());
		String data=JSONObject.fromObject(u,config).toString();
		System.out.println(data);
	}
	
	@Test
	public void test2(){
		User u1=new User();
		u1.setAge(10);
		u1.setName("张三");
		User u2=new User();
		u2.setAge(20);
		u2.setName("李四");
		List<User> list=new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		
		String data=JSONArray.fromObject(list).toString();
		System.out.println(data);
	}
	
	@Test
	public void test3(){
		User u1=new User();
		u1.setAge(10);
		u1.setName("张三");
		User u2=new User();
		u2.setAge(20);
		u2.setName("李四");
		User[] arr={u1,u2};
		String data=JSONArray.fromObject(arr).toString();
		System.out.println(data);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
