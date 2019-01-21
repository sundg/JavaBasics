package com.sdg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sdg.entity.Dept;
import com.sdg.util.MyBatisUtil;

public class DeptDAO {
	public List<Dept> findAll(){
		SqlSession ss=MyBatisUtil.getSession();
		List<Dept> list=ss.selectList("com.sdg.dao.DeptDAO.findAll");
		ss.close();
		return list;
	}
}
