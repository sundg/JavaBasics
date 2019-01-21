package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		// ��ȡ�û��ڱ������������
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		double salary = Double.parseDouble(req.getParameter("salary"));
		int age = Integer.parseInt(req.getParameter("age"));

		System.out.println(name + ", " + salary + ", " + age);
		// �����ݱ��浽���ݿ���
		// ��ȡ����
		Connection conn = null;

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jsd1707";
		String user = "root";
		String pwd = "1234";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pwd);
			String sql="insert into emp values(null,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setDouble(3, salary);
			int i=ps.executeUpdate();
			if(i>0){
				out.print("��ӳɹ�");
//				out.print("<a href='list'>�鿴Ա��</a>");
//				out.flush();
				res.sendRedirect("list");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("ϵ�y��æ");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

}
