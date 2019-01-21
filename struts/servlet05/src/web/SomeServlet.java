package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SomeServlet() {
		super();
	}


	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		out.print("username="+username);
		//重定向
		//response.sendRedirect("jsp1/test1.jsp");
		//转发
		request.getRequestDispatcher("/jsp1/test1.jsp").forward(request, response);
		out.close();
	}

}
