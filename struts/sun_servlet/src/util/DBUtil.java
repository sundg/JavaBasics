package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
	
	//��ȡ���ݿ�����
	public static Connection getConnection(){
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/jsd1707";
		String user="root";
		String pwd="1234";
		String driver="com.mysql.jdbc.Driver";
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pwd);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	//�ر����ݿ�����
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
