package com.sdg.controller;

import org.springframework.stereotype.Controller;

//Ŀ�����
@Controller
public class TestController {
	//��ѯ
	public String findAll(){
		System.out.println("��ѯ");
//		Integer.parseInt("a");
		return "hello";
	}
}
