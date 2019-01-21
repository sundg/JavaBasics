package action;

import dao.AdminDAO;
import entity.Admin;
import util.DAOFactory;

public class LoginAction extends BaseAction {
	//input
	private String account;
	private String pwd;

	//ouput
	private String msg;
	


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String execute(){
		AdminDAO dao=(AdminDAO) DAOFactory.getInstance("AdminDAO");
		try {
			Admin admin=dao.findByAdmin_code(account);
			//判断账号是否正确
			if(admin==null){
				msg="用户名错误";
				return "fail";
				
			}
			String password=admin.getPassword();
			//判断密码是否正确
			if(pwd.equals(password)){
				//登录成功
				//将用户信息绑定到session上
				session.put("user", admin);
				return "success";
			}else{
				msg="密码错误";
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
