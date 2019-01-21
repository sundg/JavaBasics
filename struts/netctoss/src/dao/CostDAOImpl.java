package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;

import util.DBUtil;

import entity.Cost;

public class CostDAOImpl implements CostDAO {

	public List<Cost> findAll() throws Exception {
		List<Cost> list=new ArrayList<Cost>();
		Connection con=DBUtil.getConnection();
		String sql="select * from cost";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		list=getCostList(rs);
		DBUtil.close(con);
		return list;
	}
	
	public List<Cost> getCostList(ResultSet rs) throws Exception{
		List<Cost> list=new ArrayList<Cost>();
		Cost cost=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while(rs.next()){
			cost=new Cost();
			cost.setId(rs.getInt("id"));
			cost.setName(rs.getString("name"));
			cost.setBase_duration(rs.getInt("base_duration"));
			cost.setBase_cost(rs.getDouble("base_cost"));
			cost.setUnit_cost(rs.getDouble("unit_cost"));
			cost.setStatus(rs.getString("status"));
			cost.setDescription(rs.getString("description"));
			cost.setCreatetime(rs.getTimestamp("createtime"));
			cost.setStartetime(rs.getTimestamp("startetime"));
			Date createtime=rs.getTimestamp("createtime");
			Date startetime=rs.getTimestamp("startetime");
			if(createtime==null){
				cost.setCtime("");
			}else{
				cost.setCtime(sdf.format(createtime));
			}
			if(startetime==null){
				cost.setStime("");
			}else{
				cost.setStime(sdf.format(startetime));
			}
			cost.setCosttype(rs.getString("costtype"));
			
			list.add(cost);
		}
		return list;
	}
	

	public List<Cost> findAll(int page, int pagesize) throws Exception {
		List<Cost> list=new ArrayList<Cost>();
		Connection con=DBUtil.getConnection();
		String sql="select * from cost limit ?,?";
		PreparedStatement ps=con.prepareStatement(sql);
		//从第几条开始抓取，下标从0开始
		ps.setInt(1, (page-1)*pagesize);
		//抓取几条数据
		ps.setInt(2, pagesize);
		ResultSet rs=ps.executeQuery();
		list=getCostList(rs);
		DBUtil.close(con);
		return list;
	}
	//获取总页数
	public int getTotalPages(int pageSize) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="select count(*) as page from cost";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		int i = 0;
		if(rs.next()){
			i=rs.getInt("page");
		}
		if(i%pageSize==0){
			i=i/pageSize;
		}else{
			i=i/pageSize+1;
		}
		DBUtil.close(con);
		return i;
	}
	
	//删除
	public boolean del(int id) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="delete from cost where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		if(i>0){
			return true;
		}
		return false;
	}

	public Cost findById(int id) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="select * from cost where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		Cost cost=getCost(rs);
		return cost;
	}
	
	public Cost getCost(ResultSet rs) throws SQLException{
		Cost cost=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while(rs.next()){
			cost=new Cost();
			cost.setId(rs.getInt("id"));
			cost.setName(rs.getString("name"));
			cost.setBase_duration(rs.getInt("base_duration"));
			cost.setBase_cost(rs.getDouble("base_cost"));
			cost.setUnit_cost(rs.getDouble("unit_cost"));
			cost.setStatus(rs.getString("status"));
			cost.setDescription(rs.getString("description"));
			cost.setCreatetime(rs.getTimestamp("createtime"));
			cost.setStartetime(rs.getTimestamp("startetime"));
			Date createtime=rs.getTimestamp("createtime");
			Date startetime=rs.getTimestamp("startetime");
			if(createtime==null){
				cost.setCtime("");
			}else{
				cost.setCtime(sdf.format(createtime));
			}
			if(startetime==null){
				cost.setStime("");
			}else{
				cost.setStime(sdf.format(startetime));
			}
			cost.setCosttype(rs.getString("costtype"));
		}
		
		return cost;
	}

	public boolean update(Cost cost) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="update cost set name=?,base_duration=?,base_cost=?," +
				"unit_cost=?,description=?,costtype=? where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, cost.getName());
		ps.setInt(2, cost.getBase_duration());
		ps.setDouble(3, cost.getBase_cost());
		ps.setDouble(4, cost.getUnit_cost());
		ps.setString(5, cost.getDescription());
		ps.setString(6, cost.getCosttype());
		ps.setInt(7, cost.getId());
		int i=ps.executeUpdate();
		if(i>0){
			return true;
		}
		return false;
	}
	
	public void startFee(int id) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="update cost set status=0,startetime=now() where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		DBUtil.close(con);
		
	}

	public void stopFee(int id) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="update cost set status=1,startetime=null where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		DBUtil.close(con);
		
	}

	public boolean add(Cost cost) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="insert into cost values(null,?,?,?,?,1,?,now(),null,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, cost.getName());
		ps.setInt(2, cost.getBase_duration());
		ps.setDouble(3, cost.getBase_cost());
		ps.setDouble(4, cost.getUnit_cost());
		ps.setString(5, cost.getDescription());
		ps.setString(6, cost.getCosttype());
		int i=ps.executeUpdate();
		if(i>0){
			return true;
		}else{
			return false;
		}
	}

	public Cost findByCostName(String name) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="select * from cost where name=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		Cost cost=getCost(rs);
		return cost;
	}

	public List<Cost> findAll(int page, int pagesize, String colm, String sort)
			throws Exception {
		List<Cost> list=new ArrayList<Cost>();
		Connection con=DBUtil.getConnection();
		String sql="";
		if(StringUtils.isBlank(colm)||StringUtils.isBlank(sort)){
			sql="select * from cost limit ?,?";
		}else{
			sql="select * from cost order by "+colm+" "+sort+" limit ?,?";
		}
		PreparedStatement ps=con.prepareStatement(sql);
		//从第几条开始抓取，下标从0开始
		ps.setInt(1, (page-1)*pagesize);
		//抓取几条数据
		ps.setInt(2, pagesize);
		ResultSet rs=ps.executeQuery();
		list=getCostList(rs);
		DBUtil.close(con);
		return list;
	}

}
