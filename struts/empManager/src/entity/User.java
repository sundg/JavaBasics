package entity;

public class User {
	private int id;
	private String username;
	private String name;
	private String pwd;
	private String sex;
	
	
	
	
	public User() {
		super();
	}
	
	public User(String username, String name, String pwd, String sex) {
		super();
		this.username = username;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
	}
	
	
	public User(int id, String username, String name, String pwd, String sex) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
