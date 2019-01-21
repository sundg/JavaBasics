package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SomeInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;

	public void destroy() {
		System.out.println("destory interceptor");

	}

	public void init() {
		System.out.println("init interceptor.");

	}
	/*
	 * ActionInvocation:��װ��action��result���õ���������
	 */
	public String intercept(ActionInvocation ac) throws Exception {
		System.out.println("some interceptor");
		//���ú�����action�Լ�������,����ȷ����result�ĵ���
		String str=ac.invoke();
		
		//ֻ���ú�����action�������ú�������������������result
//		String str=ac.invokeActionOnly();
		System.out.println("someStr="+str);
		return "error";
	}

}
