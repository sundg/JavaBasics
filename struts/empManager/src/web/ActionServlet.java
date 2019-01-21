package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/*
 *合并员工管理模块测查询,删除,添加,修改请求
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
				//登录校验
				HttpSession session=req.getSession();
				Object obj=session.getAttribute("user");
				if(obj==null){
					//重定向到登录页面
					res.sendRedirect("login.jsp");
					return;
				}
				List<Emp> list=dao.findAll();
				req.setAttribute("list", list);
				req.getRequestDispatcher("empList.jsp").forward(req,res);
			}catch(Exception e) {
				e.printStackTrace();
				out.print("系统繁忙!!!");
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
				out.print("系统繁忙!!!");
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
//					out.print("姓名:<input name='name' value='"+name+"'/><br/>");
//					out.print("年龄:<input name='age' value='"+age+"'/><br/>");
//					out.print("薪资:<input name='salary' value='"+sal+"'/><br/>");
//					out.print("<input type='submit' value='修改'/>");
//					out.print("</form>");
				}
			}catch(Exception e) {
				e.printStackTrace();
				out.print("系统繁忙!!!");
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
			//校验验证码
			HttpSession session=req.getSession();
			String rightCode=(String)session.getAttribute("rightCode");
			if(!(userCode!=null && userCode.equalsIgnoreCase(rightCode))){
				//验证码校验失败
				req.setAttribute("code_msg", "验证码错误");
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
					req.setAttribute("regist_msg", "用户名被占用");
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
					//登录成功
					//重定向之前将用户信息绑定到session上
					HttpSession session=req.getSession();
					session.setAttribute("user", user);
					res.sendRedirect("list.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/logout".equals(action)){
			//将session中绑定的用户信息删除
			HttpSession session=req.getSession();
			session.invalidate();
			//重定向
			res.sendRedirect("login.jsp");
		}
	}
}
