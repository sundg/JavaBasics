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

public class Find_AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies=request.getCookies();
		boolean flag=false;
		if(cookies!=null){
			for(Cookie c:cookies){
				if("city".equals(c.getName())){
					flag=true;
					out.print(c.getName()+"="+URLDecoder.decode(c.getValue(), "utf-8")+"<br/>");
				}
			}
		}
		if(!flag){
			Cookie cookie=new Cookie("city","nj");
			response.addCookie(cookie);
			out.print("ÒÑ´´½¨");
		}
		out.close();
	}

}
