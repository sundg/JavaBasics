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
	 * ActionInvocation:封装了action与result调用的整个过程
	 */
	public String intercept(ActionInvocation ac) throws Exception {
		System.out.println("other interceptor");
		//调用后续的action,并且确定了result的调用
//		ac.invoke();
		
		//只调用后续的action，不负责result
		String str=ac.invokeActionOnly();
		System.out.println("otherStr="+str);
		return "error";
	}

}
