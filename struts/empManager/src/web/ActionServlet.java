package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/*
 *�ϲ�Ա������ģ����ѯ,ɾ��,���,�޸�����
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DAOFactory;
import dao.EmpDAO;
import dao.UserDAO;
import entity.Emp;
import entity.User;

public class ActionServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service
	(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		String uri=req.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out=res.getWriter();
		EmpDAO dao=(EmpDAO) DAOFactory.getInstance("EmpDAO");
		UserDAO userdao=(UserDAO)DAOFactory.getInstance("UserDAO");
		if("/list".equals(action)){
			try {
				//��¼У��
				HttpSession session=req.getSession();
				Object obj=session.getAttribute("user");
				if(obj==null){
					//�ض��򵽵�¼ҳ��
					res.sendRedirect("login.jsp");
					return;
				}
				List<Emp> list=dao.findAll();
				req.setAttribute("list", list);
				req.getRequestDispatcher("empList.jsp").forward(req,res);
			}catch(Exception e) {
				e.printStackTrace();
				out.print("ϵͳ��æ!!!");
			}
		}else if("/del".equals(action)){
			int id=Integer.parseInt(req.getParameter("id"));
			try {
				dao.del(id);
				res.sendRedirect("list.do");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if("/add".equals(action)){
			String name=req.getParameter("name");
			double sal=Double.parseDouble(req.getParameter("salary"));
			int age=Integer.parseInt(req.getParameter("age"));
			//System.out.println(name+","+sal+","+age);
			try {
				Emp emp=new Emp(name,sal,age);
				dao.save(emp);
				res.sendRedirect("list.do");
			}catch(Exception e) {
				e.printStackTrace();
				out.print("ϵͳ��æ!!!");
			}	
		}else if("/load".equals(action)){
			int id=Integer.parseInt(req.getParameter("id"));
			try {
				Emp emp=dao.findById(id);
				if(emp!=null){
//					String name=emp.getName();
//					int age=emp.getAge();
//					double sal=emp.getSalary();
					//
					req.setAttribute("load", emp);
					req.getRequestDispatcher("updateEmp.jsp").forward(req, res);
//					out.print("<form method='post' action='update.do'>");
//					out.print("ID:"+id+"</br>");
//					out.print("<input type='hidden' name='id' value='"+id+"'/>");
//					out.print("����:<input name='name' value='"+name+"'/><br/>");
//					out.print("����:<input name='age' value='"+age+"'/><br/>");
//					out.print("н��:<input name='salary' value='"+sal+"'/><br/>");
//					out.print("<input type='submit' value='�޸�'/>");
//					out.print("</form>");
				}
			}catch(Exception e) {
				e.printStackTrace();
				out.print("ϵͳ��æ!!!");
			}
		}else if("/update".equals(action)){
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			double sal=Double.parseDouble(req.getParameter("salary"));
			int age=Integer.parseInt(req.getParameter("age"));
			try {
				Emp emp=new Emp(id,name,sal,age);
				dao.update(emp);
				res.sendRedirect("list.do");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if("/regist".equals(action)){
			String username=req.getParameter("username");
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			String sex=req.getParameter("sex");
			String userCode=req.getParameter("number");
			//У����֤��
			HttpSession session=req.getSession();
			String rightCode=(String)session.getAttribute("rightCode");
			if(!(userCode!=null && userCode.equalsIgnoreCase(rightCode))){
				//��֤��У��ʧ��
				req.setAttribute("code_msg", "��֤�����");
				req.getRequestDispatcher("regist.jsp").forward(req, res);
				return;
			}
			try {
				User user=userdao.findByUsername(username);
				if(user==null){
					user=new User(username,name,pwd,sex);
					userdao.save(user);
					res.sendRedirect("login.jsp");
				}else{
					req.setAttribute("regist_msg", "�û�����ռ��");
					req.getRequestDispatcher("regist.jsp").forward(req,res);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/login".equals(action)){
			String username=req.getParameter("username");
			String pwd=req.getParameter("pwd");
			try {
				User user=userdao.findByUsername(username);
				//System.out.println("pwd="+user.getPwd());
				if(pwd.equals(user.getPwd())){
					//��¼�ɹ�
					//�ض���֮ǰ���û���Ϣ�󶨵�session��
					HttpSession session=req.getSession();
					session.setAttribute("user", user);
					res.sendRedirect("list.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/logout".equals(action)){
			//��session�а󶨵��û���Ϣɾ��
			HttpSession session=req.getSession();
			session.invalidate();
			//�ض���
			res.sendRedirect("login.jsp");
		}
	}
}
