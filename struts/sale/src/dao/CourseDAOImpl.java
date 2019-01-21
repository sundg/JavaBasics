package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Course;

public class CourseDAOImpl implements CourseDAO {

	public List<Course> findAll() throws Exception {
		List<Course> list=new ArrayList<Course>();
		String sql="select * from course";
		Connection con=DBUtil.getConnection();
		PreparedStatement ps =con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		Course c=null;
		while(rs.next()){
			c=new Course();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			list.add(c);
		}
		return list;
	}

}
