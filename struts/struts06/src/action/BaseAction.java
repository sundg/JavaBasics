package action;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

public class BaseAction implements ServletContextAware {
	protected ServletContext sc;
	public void setServletContext(ServletContext arg0) {
		this.sc=arg0;
	}

}
