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
	 * ActionInvocation:封装了action与result调用的整个过程
	 */
	public String intercept(ActionInvocation ac) throws Exception {
		System.out.println("some interceptor");
		//调用后续的action以及拦截器,并且确定了result的调用
		String str=ac.invoke();
		
		//只调用后续的action，不调用后续的拦截器，不负责result
//		String str=ac.invokeActionOnly();
		System.out.println("someStr="+str);
		return "error";
	}

}
