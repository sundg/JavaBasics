package com.sdg.controlller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdg.dao.CostMapper;
import com.sdg.entity.Cost;

@Controller
@RequestMapping("/cost")
public class CostController {
	@Resource
	private CostMapper costMapper;
	
	
	//≤È—Ø
	@RequestMapping("/findAll.do")
	public String findAll(Model modelMap){
		List<Cost> costs=costMapper.findAll();
		modelMap.addAttribute("costs", costs);
		return "cost/fee_list";
	}
	
	//ÃÌº”
	@RequestMapping("/loadAddCost.do")
	public String loadAddCost(){
		return "cost/fee_add";
	}
	
	@RequestMapping("/addCost.do")
	public String addCost(Cost cost){
		costMapper.addCost(cost);
		return "cost/fee_add";
	}
	
}
