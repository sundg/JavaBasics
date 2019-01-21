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
	//Request接受请求参数
	@RequestMapping("/testOne.do")
	public ModelAndView testOne(HttpServletRequest req){
		String username=req.getParameter("username");
		String pwd=req.getParameter("pwd");
		System.out.println(username+":"+pwd);
		
		return new ModelAndView("hello");
	}
	
	//方法参数接受请求参数(@RequestParam注解可以解决方法参数名和请求参数名不一致的情况)
	@RequestMapping("/testTwo.do")
	public ModelAndView testTwo(@RequestParam("username")String name,String pwd){
		System.out.println(name+":"+pwd);
		return new ModelAndView("hello");
	}
	//对象接受请求参数
	@RequestMapping("/testThree.do")
	public ModelAndView testThree(User user){
		System.out.println(user.getUsername());
		System.out.println(user.getPwd());
		return new ModelAndView("hello");
	}
	
	//ModelAndView传递数据
	@RequestMapping("/testFour.do")
	public ModelAndView testFour(){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("success", true);
		map.put("message", "操作成功");
		
		return new ModelAndView("hello",map);
	}
	
	
	//ModelMap参数传递数据
	@RequestMapping("testFive.do")
	public ModelAndView testFive(ModelMap modelMap){
		modelMap.addAttribute("success", true);
		modelMap.addAttribute("message", "操作失败");
		return new ModelAndView("hello");
	}
	
	
	//ModelAttribute传递数据
	@RequestMapping("/testSix.do")
	public ModelAndView testSix(@ModelAttribute("username") String name){
		System.out.println(name);
		return new ModelAndView("hello");
	}
	
	//@ModelAttribute传递属性值
	@ModelAttribute("age")
	public Integer getAge(){
		return 25;
	}
	
	
	//返回String
	@RequestMapping("/testSeven.do")
	public String testSeven(){
		return "error";
	}
	
	//RedirectView重定向
	@RequestMapping("/testEight.do")
	public ModelAndView tetstEight(){
		RedirectView view=new RedirectView("testSeven.do");
		return new ModelAndView(view);
	}
	
	//redirect:前缀
	@RequestMapping("/testNine.do")	
	public String testNine(){
			return "redirect:testSeven.do";
		}
	
}
