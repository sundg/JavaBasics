package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCountListener implements HttpSessionListener{
	int count=0;
	
	public SessionCountListener(){
		System.out.println("listener constructor");
	}
	/**
	 * 当容器创建session时，调用该方法
	 */
	public void sessionCreated(HttpSessionEvent se) {
		count++;
		HttpSession session=se.getSession();
		ServletContext sc=session.getServletContext();
		sc.setAttribute("count121", count);
	}
	/**
	 * 当容器销毁session时，调用该方法
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		count--;
		HttpSession session=se.getSession();
		ServletContext sc=session.getServletContext();
		sc.setAttribute("count", count);
	}

}
