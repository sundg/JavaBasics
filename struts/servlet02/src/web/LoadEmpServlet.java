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

public class LoadEmpServlet extends HttpServlet{
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
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			//��emp���в�ѯ���еļ�¼
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pwd);
			String sql="select * from emp where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				String name=rs.getString("name");
				int age=rs.getInt("age");
				double sal=rs.getDouble("salary");
//				out.print(name+","+age+","+sal);
				//����id������ʽһ������ʽ������post
				//out.print("<form method='post' action='update?id="+id+"'>");
				out.print("<form method='post' action='update'>");
				out.print("ID:"+id+"<br/>");
				//��ʽ����������
				out.print("<input type='hidden' name='id' value='"+id+"'/>");
				out.print("����:<input name='name' value='"+name+"' type='text'/><br/>");
				out.print("����:<input name='age' value='"+age+"' type='text'/><br/>");
				out.print("н��:<input name='sal' value='"+sal+"' type='text'/><br/>");
				out.print("<input value='ȷ��' type='submit'/>");
				out.print("</form>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print("ϵͳ��æ");
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
