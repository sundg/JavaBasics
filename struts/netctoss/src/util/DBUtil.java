package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	//获取连接
	public static Connection getConnection(){
		Connection con=null;
		String driver=ConfigUtil.getValue("driver");
		String url=ConfigUtil.getValue("url");
		String user=ConfigUtil.getValue("user");
		String pwd=ConfigUtil.getValue("pwd");
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	//关闭连接
	public static void close(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
