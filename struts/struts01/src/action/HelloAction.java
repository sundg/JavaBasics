package action;

public class HelloAction {
	//��Ա���������������������һ��
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
	
	//�������ͱ�����String
	public String execute(){
		System.out.println("execute....");
		System.out.println("name="+name);
		return "success";
	}
	
}
