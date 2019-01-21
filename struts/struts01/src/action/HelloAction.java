package action;

public class HelloAction {
	//成员变量的名字与参数名保持一致
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HelloAction(){
		System.out.println("constructor.....");
	}
	
	//返回类型必须是String
	public String execute(){
		System.out.println("execute....");
		System.out.println("name="+name);
		return "success";
	}
	
}
