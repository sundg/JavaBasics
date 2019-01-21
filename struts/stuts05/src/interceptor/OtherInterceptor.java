package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class OtherInterceptor implements Interceptor {
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
		System.out.println("other interceptor");
		//���ú�����action,����ȷ����result�ĵ���
//		ac.invoke();
		
		//ֻ���ú�����action��������result
		String str=ac.invokeActionOnly();
		System.out.println("otherStr="+str);
		return "error";
	}

}
