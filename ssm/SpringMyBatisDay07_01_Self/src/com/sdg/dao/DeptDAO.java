package com.sdg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sdg.entity.Dept;
import com.sdg.util.MyBatisUtil;



public class DeptDAO {
	//��ѯȫ��
	public List<Dept> findAll(){
		SqlSession ss=MyBatisUtil.getSession();
		List<Dept> depts=ss.selectList("com.sdg.dao.DeptDAO.findAll");
		ss.close();
		return depts;
	}
	//����������ѯ
	public Dept findByDeptno(int id){
		SqlSession ss=MyBatisUtil.getSession();
		Dept dept=ss.selectOne("com.sdg.dao.DeptDAO.findByDeptno", id);
		ss.close();
		return dept;
		
	}
	
	//��Ӳ���
	/**
	 * MyBatis�����ݿ�����ݲ����������Զ��ύ
	 * ��Ҫ�ֶ��ύ
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
	
	//ɾ��
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
	
	//�޸�
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
