package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext sc=getServletContext();
		sc.setAttribute("username", "jack");
		out.print("��servletContext�ϰ���username<br/>");
		//��ȡȫ�ֲ���ֵ
		String value=sc.getInitParameter("version");
		out.print("version="+value);
		out.close();
	}

}
