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
		//��¼У��
		
		//��session�л�ȡ�û�����Ϣ
		Map<String,Object> map=ai.getInvocationContext().getSession();
		Object obj=map.get("user");
		if(obj==null){
			//δ��¼��
			return "login";
		}else{
			//��¼�ɹ�,���ú������
			ai.invoke();
		}
		return null;
	}

}
