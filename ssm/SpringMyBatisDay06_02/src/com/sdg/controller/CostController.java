package com.sdg.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdg.dao.CostDao;
import com.sdg.entity.Cost;

@Controller
@RequestMapping("/cost")
public class CostController {
	@Resource
	private CostDao costDao;
	@RequestMapping("/findAll.do")
	public String findAll(Model modelMap){
		List<Cost> costs=costDao.findAll();
		modelMap.addAttribute("costs",costs);
		return "cost/cost_list";
	}
	@RequestMapping("/loadCost.do")
	public String loadFee(int id,ModelMap modelMap){
		Cost cost=costDao.findById(id);
		modelMap.addAttribute("cost", cost);
		return "/cost/cost_modi";
	}
	
	@RequestMapping("/updateCost.do")
	public String update(Cost cost,Model modelMap){
		int i=costDao.update(cost);
		if(i>0){
			modelMap.addAttribute("flag", true);
		}else{
			modelMap.addAttribute("flag", false);
		}
		return "/cost/cost_modi";
	}
	
	
	
	
	
	
	
	
	
	
	
}
