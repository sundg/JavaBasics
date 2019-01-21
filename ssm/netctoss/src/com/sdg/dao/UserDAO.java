package com.sdg.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
//import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sdg.entity.User;
@Repository
public class UserDAO {
//	@Resource
//	private DataSource ds;
	@Resource
	private JdbcTemplate template;
	public User findByUsername(String username){
		String sql="select * from user where username=?";
		return template.queryForObject(sql, new Object[]{username},new UserRowMapper());
	}
	
	class UserRowMapper implements RowMapper<User>{

		public User mapRow(ResultSet rs, int index) throws SQLException {
			User user=new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setTelephone(rs.getString("telephone"));
			user.setEmail(rs.getString("email"));
			user.setRegisterdate(rs.getTimestamp("registerdate"));
			return user;
		}
		
	}
}
