package com.sdg.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	//�������������֮��ִ��
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse res, Object obj, Exception ex)
			throws Exception {
		System.out.println(obj);
		System.out.println("afterCompletionִ��");
	}
	//������ִ�к���ͼ����������ǰ
	public void postHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj, ModelAndView modelAndView) throws Exception {
		System.out.println(obj);
		System.out.println("postHandleִ��");
		
	}
	//������ִ��ǰ����
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj) throws Exception {
		System.out.println(obj);
		System.out.println("preHandleִ��");
		return true;
	}

}
