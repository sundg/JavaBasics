package com.sdg.servcie;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sdg.dao.UserDAO;
import com.sdg.entity.User;
import com.sdg.exception.LoginException;




@Service
public class LoginServcie {
	@Resource
	private UserDAO userDAO;
	public User checkLogin(String username,String pwd){
		User loginUser=userDAO.findByUsername(username);
		if(loginUser!=null&&loginUser.getPassword().equals(pwd)){
			return loginUser;
		}else{
			throw new LoginException("’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
		}
	}
	
	
	
	
	
	
	
	
	
}
