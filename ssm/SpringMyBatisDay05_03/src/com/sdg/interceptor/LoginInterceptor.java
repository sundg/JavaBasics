package com.sdg.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	//整个请求处理完成之后执行
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse res, Object obj, Exception ex)
			throws Exception {
		System.out.println(obj);
		System.out.println("afterCompletion执行");
	}
	//处理器执行后视图解析器调用前
	public void postHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj, ModelAndView modelAndView) throws Exception {
		System.out.println(obj);
		System.out.println("postHandle执行");
		
	}
	//处理器执行前调用
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj) throws Exception {
		System.out.println(obj);
		System.out.println("preHandle执行");
		return true;
	}

}
