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
	//查询所有
	public List<Cost> feeList(){
		List<Cost> list=null;
		try {
			list=costDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//开启资费
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
	//暂停资费
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
	//删除资费
	public void delFee(int id){
		try {
			costDAO.del(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改
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
