package action;

import entity.User;

public class LoginAction2 {
	//�������������
	private User user;
	
	private String msg;//�������
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
			msg="�û������������";
			return "fail";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
