package action;

import entity.User;

public class LoginAction2 {
	//根据输入算输出
	private User user;
	
	private String msg;//输出属性
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String execute(){
		if("jack".equals(user.getUsername())&&"1234".equals(user.getPwd())){
			return "success";
		}else{
			msg="用户名或密码错误";
			return "fail";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
