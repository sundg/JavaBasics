package com.sdg.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sdg.entity.User;

@Controller
@RequestMapping("/test")
public class TestController {
	//Request�����������
	@RequestMapping("/testOne.do")
	public ModelAndView testOne(HttpServletRequest req){
		String username=req.getParameter("username");
		String pwd=req.getParameter("pwd");
		System.out.println(username+":"+pwd);
		
		return new ModelAndView("hello");
	}
	
	//�������������������(@RequestParamע����Խ�������������������������һ�µ����)
	@RequestMapping("/testTwo.do")
	public ModelAndView testTwo(@RequestParam("username")String name,String pwd){
		System.out.println(name+":"+pwd);
		return new ModelAndView("hello");
	}
	//��������������
	@RequestMapping("/testThree.do")
	public ModelAndView testThree(User user){
		System.out.println(user.getUsername());
		System.out.println(user.getPwd());
		return new ModelAndView("hello");
	}
	
	//ModelAndView��������
	@RequestMapping("/testFour.do")
	public ModelAndView testFour(){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("success", true);
		map.put("message", "�����ɹ�");
		
		return new ModelAndView("hello",map);
	}
	
	
	//ModelMap������������
	@RequestMapping("testFive.do")
	public ModelAndView testFive(ModelMap modelMap){
		modelMap.addAttribute("success", true);
		modelMap.addAttribute("message", "����ʧ��");
		return new ModelAndView("hello");
	}
	
	
	//ModelAttribute��������
	@RequestMapping("/testSix.do")
	public ModelAndView testSix(@ModelAttribute("username") String name){
		System.out.println(name);
		return new ModelAndView("hello");
	}
	
	//@ModelAttribute��������ֵ
	@ModelAttribute("age")
	public Integer getAge(){
		return 25;
	}
	
	
	//����String
	@RequestMapping("/testSeven.do")
	public String testSeven(){
		return "error";
	}
	
	//RedirectView�ض���
	@RequestMapping("/testEight.do")
	public ModelAndView tetstEight(){
		RedirectView view=new RedirectView("testSeven.do");
		return new ModelAndView(view);
	}
	
	//redirect:ǰ׺
	@RequestMapping("/testNine.do")	
	public String testNine(){
			return "redirect:testSeven.do";
		}
	
}
