package day01;
/*
 * throw关键字：用于自动抛出异常
 * 通常以下两种情况会自动抛出异常
 * 	1、当前语法片段出现了一个语法错误，但是不满足业务逻辑的情况时，我们会抛出异常
 * 	2、当前代码片段出现了一个异常，但该异常的处理不应该是当前代码片段负责处理时，我们需要抛出异常
 */
public class ExceptionDemo3 {
	public static void main(String[] args) {
		try {
			Person p=new Person();
			p.setAge(1000);
			System.out.println(p);
		} catch (Exception e) {
			//输出异常出现的堆栈信息
			e.printStackTrace();
			//输出异常出现的原因
			System.out.println(e.getMessage());
		}
		System.out.println("程序结束");
	}

}
class Person{
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<0||age>150){
			throw new RuntimeException("不是人类的年龄");
		}
		this.age = age;
	}

	@Override
	public String toString() {
		return "age=" + age ;
	}
}
