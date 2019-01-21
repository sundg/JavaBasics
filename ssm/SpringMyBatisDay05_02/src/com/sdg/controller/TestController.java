package com.sdg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("testOne.do")
	public String testOne() throws ClassNotFoundException{
		//System.out.println("testOne");
		
		//制造异常
		//java.lang.NumberFormatException
		//Integer.parseInt("abc");
		
		//java.lang.StringIndexOutOfBoundsException
//		"abc".charAt(5);
		
		//java.lang.ClassNotFoundException
		Class.forName("sadfsd");
		
		return "jsp/one";
	}

	@ExceptionHandler
	public String executeException(Exception ex,HttpServletRequest req) throws Exception{
		if(ex instanceof NumberFormatException){
			req.setAttribute("message", "请输入数字");
			return "jsp/message";
		}else if(ex instanceof StringIndexOutOfBoundsException){
			req.setAttribute("message", "字符串下标越界");
			return "jsp/message";
		}else{
		}
			throw ex;
		}
		
	
}
