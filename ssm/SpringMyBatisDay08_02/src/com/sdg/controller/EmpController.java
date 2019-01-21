package com.sdg.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdg.dao.EmpMapper;
import com.sdg.entity.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController {
	@Resource
	private EmpMapper empMapper;
	@RequestMapping("/findAll.do")
	public String findAll(Model modelMap){
		List<Emp> emps=empMapper.findAll();
		modelMap.addAttribute("emps", emps);
		
		return "emp/emp_list";
	}
}
