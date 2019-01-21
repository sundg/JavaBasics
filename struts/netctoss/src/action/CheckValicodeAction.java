package action;

public class CheckValicodeAction extends BaseAction{
	//input
	private String valicode;
	//output
	private boolean flag=false;
	
	public String execute(){
		String rightcode=(String) session.get("rightCode");
		if(valicode.equalsIgnoreCase(rightcode)){
			flag=true;
		}
		return "success";
	}
	public String getValicode() {
		return valicode;
	}
	public void setValicode(String valicode) {
		this.valicode = valicode;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
