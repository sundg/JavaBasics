package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	public SomeServlet(){
		System.out.println("some cons...");
	}
	protected void service(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		System.out.println("some service...");
		String uri=req.getRequestURI();
		System.out.println("uri="+uri);
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if("/list".equals(action)){
			System.out.println("查询员工列表...");
		}else if("/del".equals(action)){
			System.out.println("删除员工...");
		}
	}
}
