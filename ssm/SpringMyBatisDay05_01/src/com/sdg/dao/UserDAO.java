package com.sdg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.sdg.entity.User;
@Repository
public class UserDAO {
	@Resource
	private DataSource ds;
	public User findByUsername(String username){
		User user=null;
		try {
			Connection con=ds.getConnection();
			String sql="select * from user where username=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setTelephone(rs.getString("telephone"));
				user.setEmail(rs.getString("email"));
				user.setRegisterdate(rs.getTimestamp("registerdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
