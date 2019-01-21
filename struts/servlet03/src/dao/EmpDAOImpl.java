package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import util.DBUtil;

import entity.Emp;

public class EmpDAOImpl implements EmpDAO {

	public void del(int id) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="delete from emp where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		ps.executeUpdate();
		DBUtil.close(con);
	}

	public List<Emp> findAll() throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="select * from emp";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<Emp> list = new ArrayList<Emp>();
		Emp emp=null;
		while(rs.next()){
			emp=new Emp();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setAge(rs.getInt("age"));
			list.add(emp);
		}
		DBUtil.close(con);
		return list;
	}

	public Emp findById(int id) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="select * from emp where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		Emp emp=null;
		if(rs.next()){
			emp=new Emp();
			emp.setId(id);
			emp.setName(rs.getString("name"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setAge(rs.getInt("age"));
		}
		DBUtil.close(con);
		return emp;
	}

	public void save(Emp emp) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="insert into emp values(null,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,emp.getName());
		ps.setInt(2,emp.getAge());
		ps.setDouble(3,emp.getSalary());
		ps.executeUpdate();
		DBUtil.close(con);
	}

	public void update(Emp emp) throws Exception {
		Connection con=DBUtil.getConnection();
		String sql="update emp set name=?,age=?,salary=? where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,emp.getName());
		ps.setInt(2,emp.getAge());
		ps.setDouble(3,emp.getSalary());
		ps.setInt(4,emp.getId());
		ps.executeUpdate();
		DBUtil.close(con);
	}

}
