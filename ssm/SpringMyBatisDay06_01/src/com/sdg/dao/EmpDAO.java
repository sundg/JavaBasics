package com.sdg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sdg.entity.Emp;

@Repository
public class EmpDAO {
	@Resource
	private JdbcTemplate template;
	
	//查询全部员工
	public List<Emp> findAll(){
		String sql="select * from emp";
		
		
		return template.query(sql, new EmpRowMapper());
	}
	//根据员工号查询员工
	public Emp findByEmpno(int empno){
		String sql="select * from emp where empno=?";
		
		return template.queryForObject(sql, new Object[]{empno}, new EmpRowMapper());
	}
	//添加
	public void save(Emp emp){
		String sql="insert into emp values(?,?,?,?,?,?)";
		Object[] parameters={
				emp.getEmpno(),
				emp.getEname(),
				emp.getSalary(),
				emp.getBonus(),
				emp.getHiredate(),
				emp.getDeptno()
		};
		template.update(sql, parameters);
	}
	
	//修改员工
	public void update(Emp emp){
		String sql="update emp set ename=?,bonus=?,salary=?,hiredate=?,deptno=? where empno=?";
		Object[] parameters={
				emp.getEname(),
				emp.getBonus(),
				emp.getSalary(),
				emp.getHiredate(),
				emp.getDeptno(),
				emp.getEmpno()
		};
		template.update(sql, parameters);
	}
	//删除员工
	public void delete(int empno){
		String sql="delete from emp where empno=?";
		
		template.update(sql, empno);
	}
	class EmpRowMapper implements RowMapper<Emp>{

		public Emp mapRow(ResultSet rs, int index) throws SQLException {
			//index代表结果集中的记录，从0开始
//			System.out.println(index);
			Emp emp=new Emp();
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setBonus(rs.getDouble("bonus"));
			emp.setHiredate(rs.getDate("hiredate"));
			emp.setDeptno(rs.getInt("deptno"));
			return emp;
		}
		
	}
}
