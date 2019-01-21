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
	
	public List<Cost> feeList(){
		List<Cost> list=null;
		try {
			list=costDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
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
	
	public void delFee(int id){
		try {
			costDAO.del(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
