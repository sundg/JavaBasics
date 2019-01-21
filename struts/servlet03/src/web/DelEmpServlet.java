package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DAOFactory;

import dao.EmpDAO;

public class DelEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		//��emp����ɾ����¼
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			EmpDAO dao=(EmpDAO) DAOFactory.getInstance("EmpDAO");
			dao.del(id);
			//�ض���
			res.sendRedirect("list");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
