package com.sdg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sdg.entity.Cost;


@Repository
public interface CostDAO {
	
	List<Cost> findAll() throws Exception;
	//分页
	List<Cost> findAll(int page,int pagesize) throws Exception;
	//分页
	List<Cost> findAll(int page,int pagesize,String colm,String sort) throws Exception;
	int getTotalPages(int pageSize) throws Exception;
	
	//根据id删除记录
	boolean del(int id) throws Exception;
	//根据id查询
	Cost findById(int id) throws Exception;
	Cost findByCostName(String name) throws Exception;
	//启用资费
	void startFee(int id) throws Exception;
	//暂停资费
	void stopFee(int id) throws Exception;
	//更新
	boolean update(Cost cost) throws Exception;
	//增加
	boolean add(Cost cost) throws Exception;
}
