package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import entity.User;

public class UserDAOImpl implements UserDAO {

	public User findByUsername(String username) throws Exception {
		User user=null;
			Connection conn=DBUtil.getConnection();
			String sql="select id,username,name,pwd,sex from user where username=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user=new User(rs.getInt("id"),
						rs.getString("username"),
						rs.getString("name"),
						rs.getString("pwd"),
						rs.getString("sex")
						);
			}
		DBUtil.close(conn);
		return user;
	}

	public void save(User user) throws Exception {
		Connection conn=DBUtil.getConnection();
		String sql="insert into user values(null,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPwd());
		ps.setString(4, user.getSex());
		ps.executeUpdate();
		DBUtil.close(conn);
	}

}
