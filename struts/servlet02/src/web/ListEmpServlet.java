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

public class ListEmpServlet extends HttpServlet {
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
			//��emp���в�ѯ���еļ�¼
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pwd);
			String sql="select *from emp";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			out.print("<table border='1px' width='20%' cellpadding='0' cellspacing='0'>");
			out.print("<tr>" +
					"<td>id</td>" +
					"<td>����</td>" +
					"<td>����</td>" +
					"<td>н��</td>" +
					"<td>����</td>" +
					"</tr>");
			while(rs.next()){
				//����ѯ��ÿһ�������Ա�����ʽչʾ��ҳ����
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				double salary=rs.getDouble("salary");
				out.print("<tr>" +
						"<td>"+id+"</td>" +
						"<td>"+name+"</td>" +
						"<td>"+age+"</td>" +
						"<td>"+salary+"</td>" +
						"<td><a href='del?id="+id+"'>ɾ��</a>" +
						"&nbsp;<a href='loademp?id="+id+"'>�޸�</a>"+
						"</tr>");
			}
			out.print("</table>");
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
