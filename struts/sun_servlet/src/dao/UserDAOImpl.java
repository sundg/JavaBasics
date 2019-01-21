package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtil;

public class UserDAOImpl implements UserDAO {

	public User findByUsername(String username) throws Exception {
		User user=null;
		Connection conn=DBUtil.getConnection();
		String sql="select *from user where username=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			user=new User(rs.getString("username"),
					rs.getString("name"),
					rs.getString("pwd"),
					rs.getString("sex")
					);
		}
		DBUtil.close(conn);
		return user;
	}

	public void addUser(User user) throws Exception {
		Connection conn=DBUtil.getConnection();
		String sql="insert into user values(null,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPwd());
		ps.setString(4, user.getSex());
		ps.executeUpdate();
	}

	public List<User> findAll() throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="select * from user";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<User> list = new ArrayList<User>();
		User user=null;
		while(rs.next()){
			user=new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setName(rs.getString("name"));
			user.setPwd(rs.getString("pwd"));
			user.setSex(rs.getString("sex"));
			list.add(user);
		}
		DBUtil.close(con);
		return list;
	}

}
