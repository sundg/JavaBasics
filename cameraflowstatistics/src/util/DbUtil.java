package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.superb.camera.util.ReadConfigUtil;

 

public class DbUtil {
	private static final Logger log = Logger.getLogger(DbUtil.class);
	   //数据库连接对象
    private static Connection conn = null;
     
    private static String driver = "oracle.jdbc.driver.OracleDriver"; //驱动
     
    private static String url = ReadConfigUtil.getKeyValue("url"); //连接字符串
     
    private static String username = ReadConfigUtil.getKeyValue("username"); //用户名
     
    private static String password = ReadConfigUtil.getKeyValue("password"); //密码
     
     
    // 获得连接对象
    public static synchronized Connection getConn(){
        try {
			if(conn != null && !conn.isClosed()){
				return conn;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        try {
        	Class.forName(driver);
        	conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
        	log.error("获取数据库连接失败"+e);
        	e.printStackTrace();
        }catch (SQLException e) {
        	log.error("获取数据库连接失败"+e);
        	e.printStackTrace();
        }
        return conn;
    }
     
    //执行查询语句
    public void query(String sql, boolean isSelect) throws SQLException{
        PreparedStatement pstmt;
         
        try {
            pstmt = getConn().prepareStatement(sql);
            //建立一个结果集，用来保存查询出来的结果
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    public void query(String sql) throws SQLException{
        PreparedStatement pstmt;
        pstmt = getConn().prepareStatement(sql);
        pstmt.execute();
        pstmt.close();
    }
     
     
    //关闭连接
    public void close(){
        try {
            getConn().close();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException {
    	DbUtil test = new DbUtil();
        try {
            test.query("drop table student");
        } catch (SQLException e) {}
         
       /* test.query("create table student(id int, name nchar(20))");
         
        test.query("insert into student values(1,'zhangsan')");
         
        test.query("insert into student values(2,'lisi')");
         
        test.query("select * from student", true);*/
         
        test.close();
    }
}