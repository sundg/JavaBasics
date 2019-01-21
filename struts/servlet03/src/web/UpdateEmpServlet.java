package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DAOFactory;

import dao.EmpDAO;
import entity.Emp;

public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		//��emp�����޸ļ�¼
		req.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double sal=Double.parseDouble(req.getParameter("salary"));
		int age=Integer.parseInt(req.getParameter("age"));
		try {
			EmpDAO dao=(EmpDAO) DAOFactory.getInstance("EmpDAO");
			Emp emp=new Emp(id,name,sal,age);
			dao.update(emp);
			//�ض���
			res.sendRedirect("list");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
