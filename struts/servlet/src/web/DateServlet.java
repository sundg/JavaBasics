package web;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		res.setContentType("text/html;charset=utf-8");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
			Date date=new Date();
			String now=sdf.format(date);
			PrintWriter out=res.getWriter();
			
			out.println("<span>"+now+"</span>");
		
	}
}
