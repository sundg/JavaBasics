package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtherServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;cahrset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext sc=getServletContext();
		String username=(String)sc.getAttribute("username");
		out.print("username="+username+"<br/>");
		//获取全局参数值
		String value=sc.getInitParameter("version");
		out.print("version="+value);
		out.close();
	}

}
