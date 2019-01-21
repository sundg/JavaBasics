package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DAOFactory;

import dao.EmpDAO;
import entity.Emp;

public class AddEmpServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		//获取用户在表单输入的数据
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		double sal=Double.parseDouble(req.getParameter("salary"));
		int age=Integer.parseInt(req.getParameter("age"));
		System.out.println(name+","+sal+","+age);
		//将数据保存到数据库中
		//获取连接对象
		try {
			EmpDAO dao=(EmpDAO) DAOFactory.getInstance("EmpDAO");
			Emp emp=new Emp(name,sal,age);
			dao.save(emp);
			//out.print("添加成功!!!");
			//out.print("<a href='list'>查看员工</a>");
			//重定向:
			res.sendRedirect("list");
		}catch(Exception e) {
			e.printStackTrace();
			out.print("系统繁忙!!!");
		}	
	}
}
