package com.sdg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sdg.entity.Cost;

@Repository
public class CostDao {
	@Resource
	private JdbcTemplate template;
	//查询全部
	public List<Cost> findAll(){
		String sql="select * from cost";
		
		return template.query(sql,new CostRowMapper());
	}
	//根据id查询
	public Cost findById(int id){
		String sql="select * from cost where id=?";
		return template.queryForObject(sql, new Object[]{id}, new CostRowMapper());
	}
	//修改
	public int update(Cost cost){
		String sql="update cost set name=?,base_duration=?," +
				"base_cost=?,unit_cost=?,description=?," +
				"costtype=? where id=?";
		Object[] parameters=new Object[]{
				cost.getName(),
				cost.getBase_duration(),
				cost.getBase_cost(),
				cost.getUnit_cost(),
				cost.getDescription(),
				cost.getCosttype(),
				cost.getId()
		};
		return template.update(sql, parameters);
		
	}
	class CostRowMapper implements RowMapper<Cost>{
		public Cost mapRow(ResultSet rs, int index) throws SQLException {
			Cost cost=new Cost();
			cost.setId(rs.getInt("id"));
			cost.setName(rs.getString("name"));
			cost.setBase_duration(rs.getInt("base_duration"));
			cost.setBase_cost(rs.getDouble("base_cost"));
			cost.setUnit_cost(rs.getDouble("unit_cost"));
			cost.setStatus(rs.getString("status"));
			cost.setDescription(rs.getString("description"));
			cost.setCreatetime(rs.getTimestamp("createtime"));
			cost.setStartetime(rs.getTimestamp("startetime"));
			cost.setCosttype(rs.getString("costtype"));
			return cost;
		}
		
	}
}
