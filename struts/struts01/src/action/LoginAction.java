package action;

public class LoginAction {
	//�������������
	private String username;//��������
	private String pwd;//��������
	
	private String msg;//�������
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
			msg="�û������������";
			return "fail";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
