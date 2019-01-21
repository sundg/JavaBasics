package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import dao.AdminDAO;
import entity.Admin;

public class AdminDAOImpl implements AdminDAO {

	public List<Admin> findAll() throws Exception {
		List<Admin> list=null;
		Connection con=DBUtil.getConnection();
		String sql="select * from admin_msg";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		list=getResultSet(rs);
		DBUtil.close(con);
		return list;
	}
	
	public Admin findByAdmin_code(String account) throws Exception {
		Admin admin=null;
		Connection con=DBUtil.getConnection();
		String sql="select * from admin_msg where admin_code=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, account);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			admin=new Admin();
			admin.setId(rs.getInt("id"));
			admin.setAdmin_code(rs.getString("admin_code"));
			admin.setPassword(rs.getString("password"));
			admin.setName(rs.getString("name"));
			admin.setTelephone(rs.getString("telephone"));
			admin.setEmail(rs.getString("email"));
			admin.setRegisterdate(rs.getTimestamp("registerdate"));
		}
		DBUtil.close(con);
		return admin;
	}
	
	public List<Admin> getResultSet(ResultSet rs) throws SQLException{
		List<Admin> list=new ArrayList<Admin>();
		Admin admin=null;
		while(rs.next()){
			admin=new Admin();
			admin.setId(rs.getInt("id"));
			admin.setAdmin_code(rs.getString("admin_code"));
			admin.setPassword(rs.getString("password"));
			admin.setName(rs.getString("name"));
			admin.setTelephone(rs.getString("telephone"));
			admin.setEmail(rs.getString("email"));
			admin.setRegisterdate(rs.getTimestamp("registerdate"));
			list.add(admin);
		}
		return list;
		
	}

	
}
