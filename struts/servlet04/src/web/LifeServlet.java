package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LifeServlet(){
		System.out.println("constructor....");
	}
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("service........");
		//获取初始参数值city=nj
		//servletConfig对象提供了getInitParameter()
		ServletConfig config=getServletConfig();
		String value=config.getInitParameter("city");
		System.out.println("value="+value);
	}
	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		super.init(config);
//		System.out.println("init.........");
//	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
//		super.init();
		System.out.println("init2.....");
	}
	
	
	@Override
	public void destroy() {
		//释放资源空间
		System.out.println("destroy.....");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
