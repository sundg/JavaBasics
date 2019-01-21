package com.sdg.controller;

import org.springframework.stereotype.Controller;

//目标组件
@Controller
public class TestController {
	//查询
	public String findAll(){
		System.out.println("查询");
//		Integer.parseInt("a");
		return "hello";
	}
}
