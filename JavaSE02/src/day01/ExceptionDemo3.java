package day01;
/*
 * throw�ؼ��֣������Զ��׳��쳣
 * ͨ����������������Զ��׳��쳣
 * 	1����ǰ�﷨Ƭ�γ�����һ���﷨���󣬵��ǲ�����ҵ���߼������ʱ�����ǻ��׳��쳣
 * 	2����ǰ����Ƭ�γ�����һ���쳣�������쳣�Ĵ���Ӧ���ǵ�ǰ����Ƭ�θ�����ʱ��������Ҫ�׳��쳣
 */
public class ExceptionDemo3 {
	public static void main(String[] args) {
		try {
			Person p=new Person();
			p.setAge(1000);
			System.out.println(p);
		} catch (Exception e) {
			//����쳣���ֵĶ�ջ��Ϣ
			e.printStackTrace();
			//����쳣���ֵ�ԭ��
			System.out.println(e.getMessage());
		}
		System.out.println("�������");
	}

}
class Person{
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<0||age>150){
			throw new RuntimeException("�������������");
		}
		this.age = age;
	}

	@Override
	public String toString() {
		return "age=" + age ;
	}
}
