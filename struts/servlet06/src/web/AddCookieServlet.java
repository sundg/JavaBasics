package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie c=new Cookie("username",URLEncoder.encode("小虎", "utf-8"));
		response.addCookie(c);
		Cookie c2=new Cookie("pwd","1234");
		//设置cookie保存时间
		c2.setMaxAge(40);
		response.addCookie(c2);
		out.print("添加成功cookie");
		out.close();
		
	}

	

}
