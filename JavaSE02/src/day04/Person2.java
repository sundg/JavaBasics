package day04;

import java.io.Serializable;
import java.util.List;
/*
 * 所有需要序列化的类，必须是Serializable接口的子类
 */
public class Person2  implements Serializable{
	private String name;
	private int age;
	private int sex;
	//transient关键字：该关键字修饰的属性在序列化时被忽略
	private transient String info;
	private List<String> otherInfo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public List<String> getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}
	@Override
	public String toString() {
		return "Person2 [age=" + age + ", info=" + info + ", name=" + name
				+ ", otherInfo=" + otherInfo + ", sex=" + sex + "]";
	}
	public Person2(String name, int age, int sex, String info,
			List<String> otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.info = info;
		this.otherInfo = otherInfo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((otherInfo == null) ? 0 : otherInfo.hashCode());
		result = prime * result + sex;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person2 other = (Person2) obj;
		if (age != other.age)
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (otherInfo == null) {
			if (other.otherInfo != null)
				return false;
		} else if (!otherInfo.equals(other.otherInfo))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}
	
}
