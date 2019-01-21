package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

public class Find_AddCookieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			String cook=CookieUtil.findCookie(request, "city");
			if(cook==null){
				CookieUtil.addCookie("city", "ÄÏ¾©", 40, response);
			}else{
				out.print("city="+cook+"<br/>");
				}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
