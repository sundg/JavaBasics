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

public class LoadEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		//��emp�����޸ļ�¼
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			EmpDAO dao=(EmpDAO) DAOFactory.getInstance("EmpDAO");
			Emp emp=dao.findById(id);
			if(emp!=null){
				String name=emp.getName();
				int age=emp.getAge();
				double sal=emp.getSalary();
				//out.print(name+","+age+","+sal);
				out.print("<form method='post' action='update'>");
				out.print("ID:"+id+"</br>");
				out.print("<input type='hidden' name='id' value='"+id+"'/>");
				out.print("����:<input name='name' value='"+name+"'/><br/>");
				out.print("����:<input name='age' value='"+age+"'/><br/>");
				out.print("н��:<input name='salary' value='"+sal+"'/><br/>");
				out.print("<input type='submit' value='�޸�'/>");
				out.print("</form>");
			}
		}catch(Exception e) {
			e.printStackTrace();
			out.print("ϵͳ��æ!!!");
		}
	}

}
