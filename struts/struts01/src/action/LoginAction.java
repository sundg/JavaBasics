package action;

public class LoginAction {
	//根据输入算输出
	private String username;//输入属性
	private String pwd;//输入属性
	
	private String msg;//输出属性
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String execute(){
		if("jack".equals(username)&&"1234".equals(pwd)){
			return "success";
		}else{
			msg="用户名或密码错误";
			return "fail";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
