package com.superb.camera.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	 /**
     * 获取数据库连接
     * 
     * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
     */
    public static Connection getConnection()  {
        Connection conn = null;
        try {
            //Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
            Driver driver = (Driver)Class.forName("org.logicalcobwebs.proxool.ProxoolDriver").newInstance();
			DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection("proxool.pro_pool");
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return conn;
    }
    
    /**
     * 获取sql语句发送器
     * 
     * @param conn
     * @return
     */
    public static Statement getStmt(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    /**
     * 获取预处理发送器
     * 
     * @param conn
     * @param sql
     * @return
     */
    public static PreparedStatement getPstmt(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    /**
     * 动态绑定参数
     * 
     * @param pstmt
     * @param params
     */
    public static void bindParam(PreparedStatement pstmt, Object... params) {
        for (int i = 0; i < params.length; i++) {
            try {
                pstmt.setObject(i + 1, params[i]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭资源
     * @param autoCloseables 实现了AutoCloseable接口的实现类对象
     */
    public static void closeAll(AutoCloseable...autoCloseables) {
        for (AutoCloseable autoCloseable : autoCloseables) {
            if(autoCloseable!=null){
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
