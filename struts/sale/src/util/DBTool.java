package util;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

public class DBTool {
	public static Connection getConnection(){
		Connection con=null;
		BasicDataSource dbs=null;
		try{
			dbs=new BasicDataSource();
			ConfigUtil.getValue("");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
}
