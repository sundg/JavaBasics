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
		//��ȡ�û��ڱ����������
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		double sal=Double.parseDouble(req.getParameter("salary"));
		int age=Integer.parseInt(req.getParameter("age"));
		System.out.println(name+","+sal+","+age);
		//�����ݱ��浽���ݿ���
		//��ȡ���Ӷ���
		try {
			EmpDAO dao=(EmpDAO) DAOFactory.getInstance("EmpDAO");
			Emp emp=new Emp(name,sal,age);
			dao.save(emp);
			//out.print("��ӳɹ�!!!");
			//out.print("<a href='list'>�鿴Ա��</a>");
			//�ض���:
			res.sendRedirect("list");
		}catch(Exception e) {
			e.printStackTrace();
			out.print("ϵͳ��æ!!!");
		}	
	}
}
