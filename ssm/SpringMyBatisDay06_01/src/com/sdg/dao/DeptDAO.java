package com.sdg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sdg.entity.Dept;

@Repository
public class DeptDAO {
	@Resource
	private JdbcTemplate template;
	
	//查询部门信息
	public List<Dept> findAll(){
		String sql="select * from dept";
		return template.query(sql, new DeptRowMapper());
	}
	//根据部门编号查询
	public Dept findByDeptno(int deptno){
		String sql="select * from dept where deptno=?";
		return template.queryForObject(sql, new Object[]{deptno}, new DeptRowMapper());
	}
	//添加
	public void add(Dept dept){
		String sql="insert into dept values(?,?,?)";
		Object[] obj=new Object[]{
				dept.getDeptno(),
				dept.getDname(),
				dept.getDloc()
		};
		template.update(sql, obj);
		
	}
	//更新
	public void update(Dept dept){
		String sql="update dept set dname=?,dloc=? where deptno=?";
		Object[] obj=new Object[]{
				dept.getDname(),
				dept.getDloc(),
				dept.getDeptno()
		};
		template.update(sql,obj);
	}
	//删除
	public void delete(int deptno){
		String sql="delete from dept where deptno=?";
		template.update(sql, deptno);
	}
	
	
	class DeptRowMapper implements RowMapper<Dept>{

		public Dept mapRow(ResultSet rs, int index) throws SQLException {
			Dept dept=new Dept();
			dept.setDeptno(rs.getInt("deptno"));
			dept.setDname(rs.getString("dname"));
			dept.setDloc(rs.getString("dloc"));
			return dept;
		}
		
	}
}
