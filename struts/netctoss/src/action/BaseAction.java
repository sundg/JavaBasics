package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware{
	//protected:������̳�
	protected Map<String,Object> session;
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}

}
