package com.sdg.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdg.entity.Cost;
import com.sdg.servcie.CostService;
@Controller
@RequestMapping("/cost")
public class CostController {
	@Resource
	private CostService feeListService;
	@RequestMapping("/feelist.do")
	public String toFeeList(HttpServletRequest req){
		List<Cost> list=feeListService.feeList();
		req.setAttribute("list", list);
		return "cost/fee_list";
	}
	@RequestMapping("/startFee.do")
	public String startFee(int id,HttpServletRequest req){
		List<Cost> list=feeListService.startFee(id);
		req.setAttribute("list", list);
		
		return "cost/fee_list";
	}
	@RequestMapping("/pauseFee.do")
	public String pauseFee(int id,HttpServletRequest req){
		List<Cost> list=feeListService.pauseFee(id);
		req.setAttribute("list", list);
		
		return "cost/fee_list";
	}
	@RequestMapping("delFee.do")
	public String delFee(int id,Model modelMap){
		feeListService.delFee(id);
		List<Cost> list=feeListService.feeList();
		modelMap.addAttribute("list", list);
		
		return "cost/fee_list";
	}
}
