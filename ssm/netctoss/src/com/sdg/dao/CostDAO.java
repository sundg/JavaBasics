package com.sdg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sdg.entity.Cost;


@Repository
public interface CostDAO {
	
	List<Cost> findAll() throws Exception;
	//��ҳ
	List<Cost> findAll(int page,int pagesize) throws Exception;
	//��ҳ
	List<Cost> findAll(int page,int pagesize,String colm,String sort) throws Exception;
	int getTotalPages(int pageSize) throws Exception;
	
	//����idɾ����¼
	boolean del(int id) throws Exception;
	//����id��ѯ
	Cost findById(int id) throws Exception;
	Cost findByCostName(String name) throws Exception;
	//�����ʷ�
	void startFee(int id) throws Exception;
	//��ͣ�ʷ�
	void stopFee(int id) throws Exception;
	//����
	boolean update(Cost cost) throws Exception;
	//����
	boolean add(Cost cost) throws Exception;
}
