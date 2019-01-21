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

public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jsd1707";
		String user = "root";
		String pwd = "1234";
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			//从emp表中查询所有的记录
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pwd);
			String sql="delete from emp where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			//重定向
			res.sendRedirect("list");
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print("系统繁忙");
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
