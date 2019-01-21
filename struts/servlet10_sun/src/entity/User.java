package entity;

public class User {
	private String username;
	private int age;
	private Emp emp;
	
	private String[] arrs;
	public String[] getArrs() {
		return arrs;
	}
	public void setArrs(String[] arrs) {
		this.arrs = arrs;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
}
