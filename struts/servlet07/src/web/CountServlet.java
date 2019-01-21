package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//统计一个人访问某个应用的总次数
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(40);
		Integer count=(Integer)session.getAttribute("count");
		if(count==null){
			count=1;
		}else{
			count++;
		}
		session.setAttribute("count", count);
		out.print("你是第"+count+"次访问");
		out.close();
	}

}
