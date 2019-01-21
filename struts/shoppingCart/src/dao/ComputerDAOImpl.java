package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Computer;

public class ComputerDAOImpl implements ComputerDAO {

	public List<Computer> findAll() throws Exception {
		List<Computer> list=new ArrayList<Computer>();
		Connection conn=DBUtil.getConnection();
		String sql="select * from computer";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		Computer comp=null;
		while(rs.next()){
			comp=new Computer();
			comp.setId(rs.getInt("id"));
			comp.setModel(rs.getString("model"));
			comp.setPic(rs.getString("pic"));
			comp.setProDesc(rs.getString("proDesc"));
			comp.setPrice(rs.getDouble("price"));
			list.add(comp);
		}
		DBUtil.close(conn);
		return list;
	}

	public Computer findById(int id) throws Exception {
		Connection conn=DBUtil.getConnection();
		String sql="select * from computer where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		Computer comp=null;
		while(rs.next()){
			comp=new Computer();
			comp.setId(rs.getInt("id"));
			comp.setModel(rs.getString("model"));
			comp.setPic(rs.getString("pic"));
			comp.setProDesc(rs.getString("proDesc"));
			comp.setPrice(rs.getDouble("price"));
		}
		DBUtil.close(conn);
		return comp;
	}

}
