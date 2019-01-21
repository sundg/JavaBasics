package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jsd1707";
		String user = "root";
		String pwd = "1234";
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pwd);
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			int age=Integer.parseInt(req.getParameter("age"));
			double sal=Double.parseDouble(req.getParameter("sal"));
			
			String sql="update emp set name=?,age=?,salary=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setDouble(3, sal);
			ps.setInt(4, id);
			ps.executeUpdate();
			
			res.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("ÏµÍ³·±Ã¦");
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
