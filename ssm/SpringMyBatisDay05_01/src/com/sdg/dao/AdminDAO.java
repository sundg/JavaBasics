package com.sdg.dao;

import java.util.List;

import com.sdg.entity.Admin;


public interface AdminDAO {
	List<Admin> findAll() throws Exception;
	//根据账号查询记录
	Admin findByAdmin_code(String account) throws Exception;
}
