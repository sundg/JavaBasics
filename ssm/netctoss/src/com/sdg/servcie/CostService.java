package com.sdg.servcie;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sdg.dao.CostDAO;
import com.sdg.dao.impl.CostDAOImpl;
import com.sdg.entity.Cost;

@Service
public class CostService {
	@Resource
	private CostDAO costDAO;
	//��ѯ����
	public List<Cost> feeList(){
		List<Cost> list=null;
		try {
			list=costDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//�����ʷ�
	public List<Cost> startFee(int id){
		List<Cost> list=null;
		try {
			costDAO.startFee(id);
			list=costDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//��ͣ�ʷ�
	public List<Cost> pauseFee(int id){
		List<Cost> list=null;
		try {
			costDAO.stopFee(id);
			list=costDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//ɾ���ʷ�
	public void delFee(int id){
		try {
			costDAO.del(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�޸�
	public void modify(Cost cost){
		try {
			costDAO.update(cost);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Cost modify_load(int id){
		try {
			return costDAO.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int totalPages(int pageSize) throws Exception{
		return costDAO.getTotalPages(pageSize);
	}
}
