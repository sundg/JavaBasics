package sun_web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DAOFactory;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		String uri=req.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out=res.getWriter();
		UserDAO dao=(UserDAO)DAOFactory.getInstance("UserDAO");
		if("/list".equals(action)){
			try{
				List<User> list=dao.findAll();
				req.setAttribute("list", list);
				req.getRequestDispatcher("userList.jsp").forward(req,res);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if("/regist".equals(action)){
			String username=req.getParameter("username");
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			String sex=req.getParameter("sex");
			try {
				User user=dao.findByUsername(username);
				System.out.println("user="+user);
				if(user==null){
					user=new User(username,name,pwd,sex);
					dao.addUser(user);
					res.sendRedirect("login.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("/login".equals(action)){
			String username=req.getParameter("username");
			String pwd=req.getParameter("pwd");
			try {
//				String s=null;
//				s.length();
				User user=dao.findByUsername(username);
				if(user!=null && pwd.equals(user.getPwd())){
					//登录成功
					res.sendRedirect("list.do");
				}else{
					req.setAttribute("login_msg", "用户名或密码错误");
					req.getRequestDispatcher("login.jsp").forward(req,res);
				}
			} catch (Exception e) {
				e.printStackTrace();
				//res.sendRedirect("error.jsp");
				//将异常信息抛给容器
				throw new ServletException(e);
			}
		}
	}
}
