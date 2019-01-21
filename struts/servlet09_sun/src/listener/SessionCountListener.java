package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCountListener implements HttpSessionListener {
	int count=0;
	public void sessionCreated(HttpSessionEvent se) {
		count++;
		HttpSession session=se.getSession();
		ServletContext sc=session.getServletContext();
		sc.setAttribute("count", count);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		
		
	}

}
