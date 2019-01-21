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
			//�ж��˺��Ƿ���ȷ
			if(admin==null){
				msg="�û�������";
				return "fail";
				
			}
			String password=admin.getPassword();
			//�ж������Ƿ���ȷ
			if(pwd.equals(password)){
				//��¼�ɹ�
				//���û���Ϣ�󶨵�session��
				session.put("user", admin);
				return "success";
			}else{
				msg="�������";
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
