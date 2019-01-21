package com.sdg.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest req,
			HttpServletResponse res, Object obj, Exception ex) {
		System.out.println(obj);
		System.out.println(ex);
		if(ex instanceof StringIndexOutOfBoundsException){
			System.out.println("1234");
			req.setAttribute("message", "字符串下标越界");
		}
		return new ModelAndView("jsp/error");
	}

}
