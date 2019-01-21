package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Lore;
import entity.Sale;

public class LoreDAOImpl implements LoreDAO {

	public List<Lore> findByCourseId(int id) throws Exception {
		List<Lore> list=new ArrayList<Lore>();
		String sql="select * from lore where course_id=?";
		Connection con=DBUtil.getConnection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		Lore lore=null;
		while(rs.next()){
			lore=new Lore();
			lore.setId(rs.getInt("id"));
			lore.setName(rs.getString("name"));
			lore.setCourse_id(rs.getInt("course_id"));
			list.add(lore);
		}
		return list;
	}

}
