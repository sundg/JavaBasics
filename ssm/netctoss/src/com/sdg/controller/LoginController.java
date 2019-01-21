package com.sdg.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sdg.entity.User;
import com.sdg.exception.LoginException;
import com.sdg.servcie.LoginServcie;


@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource
	private LoginServcie loginService;
	
	@RequestMapping("/loginform.do")
	public ModelAndView execute(){
		return new ModelAndView("login/login");
	}
	@RequestMapping("/login.do")
	public String login(User user,HttpServletRequest req){
			//Integer.parseInt("abc");
			User loginUser=loginService.checkLogin(user.getUsername(), user.getPassword());
			HttpSession session=req.getSession();
			session.setAttribute("loginUser", loginUser);
			return "main/index";
		
	}
	@ExceptionHandler
	public String executeLogin(Exception ex,HttpServletRequest req) throws Exception{
		if(ex instanceof LoginException){
			req.setAttribute("message", ex.getMessage());
			return "login/login";
		}else{
			throw ex;
		}
	}
	
	@RequestMapping("/valicode.do")
	public void valicode(HttpServletRequest req,HttpServletResponse res){
		res.setContentType("image/jpeg");		
		BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		Random r=new Random();
		g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
		g.fillRect(0, 0, 80, 30);//画实心矩形
		g.setFont(new Font(null, Font.ITALIC, 20));
		String num=getNum(5);
		g.setColor(Color.black);
		g.drawString(num, 5, 25);
		//将正确的验证码绑定到session上
		HttpSession session=req.getSession();
		session.setAttribute("rightCode", num);
		//System.out.println(num);
		//画线
		for(int i=0;i<5;i++){
			g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(30));
		}
		//图片压缩
		OutputStream os;
		try {
			os = res.getOutputStream();
			ImageIO.write(image, "jpeg", os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getNum(int length){
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		Random rd=new Random();
		StringBuffer sf=new StringBuffer();
		for(int i=0;i<length;i++){
			int index=rd.nextInt(str.length());
			char c=str.charAt(index);
			sf.append(c);
		}
		return sf.toString();
	}
}
