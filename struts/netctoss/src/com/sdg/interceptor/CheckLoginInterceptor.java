package com.sdg.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckLoginInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public String intercept(ActionInvocation ai) throws Exception {
		//登录校验
		
		//从session中获取用户的信息
		Map<String,Object> map=ai.getInvocationContext().getSession();
		Object obj=map.get("user");
		if(obj==null){
			//未登录过
			return "login";
		}else{
			//登录成功,调用后续组件
			ai.invoke();
		}
		return null;
	}

}
