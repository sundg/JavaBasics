package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DAOFactory;

import dao.EmpDAO;
import entity.Emp;

public class ListEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		//��emp���в�ѯ���еļ�¼
		try {
			EmpDAO dao=(EmpDAO) DAOFactory.getInstance("EmpDAO");
			//EmpDAO dao=new EmpDAOImpl();
			List<Emp> list=dao.findAll();
			out.print("<table border='1px' width='40%' cellpadding='0' cellspacing='0'>");
			out.print("<tr><td>ID</td><td>����</td><td>����</td><td>н��</td><td>����</td></tr>");
			for(int i=0;i<list.size();i++){
				//����ѯ����ÿһ�������Ա�����ʽչʾ��ҳ����
				Emp emp=list.get(i);
				int id=emp.getId();
				String name=emp.getName();
				int age=emp.getAge();
				double sal=emp.getSalary();
				out.print("<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+sal+"</td><td><a href='del?id="+id+"'>ɾ��</a>&nbsp<a href='load?id="+id+"'>�޸�</a></td></tr>");
			}
			out.print("</table>");
		}catch(Exception e) {
			e.printStackTrace();
			out.print("ϵͳ��æ!!!");
		}
	}
}