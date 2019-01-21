package com.sdg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sdg.entity.Dept;
import com.sdg.util.MyBatisUtil;



public class DeptDAO {
	//查询全部
	public List<Dept> findAll(){
		SqlSession ss=MyBatisUtil.getSession();
		List<Dept> depts=ss.selectList("com.sdg.dao.DeptDAO.findAll");
		ss.close();
		return depts;
	}
	//根据主键查询
	public Dept findByDeptno(int id){
		SqlSession ss=MyBatisUtil.getSession();
		Dept dept=ss.selectOne("com.sdg.dao.DeptDAO.findByDeptno", id);
		ss.close();
		return dept;
		
	}
	
	//添加部门
	/**
	 * MyBatis对数据库表数据操作不进行自动提交
	 * 需要手动提交
	 */
	public void addDept(Dept dept){
		SqlSession ss=MyBatisUtil.getSession();
		try{
			ss.insert("com.sdg.dao.DeptDAO.addDept", dept);
			ss.commit();
		}catch (Exception e) {
			ss.rollback();
		}finally{
			ss.close();
		}
	}
	
	//删除
	public void delete(int deptno){
		SqlSession ss=MyBatisUtil.getSession();
		try {
			ss.delete("com.sdg.dao.DeptDAO.delete", deptno);
			ss.commit();
		} catch (Exception e) {
			ss.rollback();
		}finally{
			ss.close();
		}
	}
	
	//修改
	public void update(Dept dept){
		SqlSession ss=MyBatisUtil.getSession();
		try {
			ss.update("com.sdg.dao.DeptDAO.update", dept);
			ss.commit();
		} catch (Exception e) {
			ss.rollback();
		}finally{
			ss.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
