package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountSessionServlet extends HttpServlet {
	int num=0;
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		HttpSession session=request.getSession();
		Integer str= (Integer)session.getAttribute("count");
		
		if(str==null){
			num=1;
		}else{
			num++;
		}
		session.setAttribute("count", num);
		out.print(username+num);
		out.close();
	}

}
