package com.sdg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/testOne.do")
	public String testOne(){
		System.out.println("���");
		return "jsp/hello";
	}
	@RequestMapping("/testTwo.do")
	public String testTwo(){
		System.out.println("�Һ�");
		return "jsp/hello";
	}
}
