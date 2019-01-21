package dayo5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
 * java�ķ������
 */
public class ReflectDemo {
	public static void main(String[] args) {
		reflect(new Foo());
	}
	//���䷽��:obj��ʲô���͡�obj����Щ���ԡ�obj��Щ������obj��Щ������
	public static void reflect(Object obj){
		//1��getClass() ���ض��������
		Class cls=obj.getClass();
		System.out.println("��000��"+cls.getName());
		//2��getDeclareFields()	���������ϻ�ȡ��������������
		Field[] fields=cls.getDeclaredFields();
		for(Field field:fields){
			System.out.println(field.getType()+":"+field.getName());
		}
		//3��getDeclareMethods()
		Method[] methods=cls.getDeclaredMethods();
		System.out.println("�������£�");
		for(Method method:methods){
			System.out.println(method.getReturnType()+"");
			System.out.println(method.getName()+"");
			System.out.println(Arrays.toString(method.getParameterTypes()));
		}
		//4��getDeclareConstructors()
		Constructor[] constructors=cls.getConstructors();
		System.out.println("���������£�");
		for(Constructor constructor:constructors){
			System.out.println(constructor.getName()+"");
			System.out.println(Arrays.toString(constructor.getParameterTypes())+"");
		}
	}
}

class Foo{
	int a=3;
	final int c=9;
	
	public double add(int b,Double d){
		return a+b;
	}
}