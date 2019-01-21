package dayo5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
 * java的反射机制
 */
public class ReflectDemo {
	public static void main(String[] args) {
		reflect(new Foo());
	}
	//反射方法:obj是什么类型、obj有哪些属性、obj哪些方法、obj哪些构造器
	public static void reflect(Object obj){
		//1、getClass() 返回对象的类型
		Class cls=obj.getClass();
		System.out.println("类000："+cls.getName());
		//2、getDeclareFields()	返回在类上获取声明的所有属性
		Field[] fields=cls.getDeclaredFields();
		for(Field field:fields){
			System.out.println(field.getType()+":"+field.getName());
		}
		//3、getDeclareMethods()
		Method[] methods=cls.getDeclaredMethods();
		System.out.println("方法如下：");
		for(Method method:methods){
			System.out.println(method.getReturnType()+"");
			System.out.println(method.getName()+"");
			System.out.println(Arrays.toString(method.getParameterTypes()));
		}
		//4、getDeclareConstructors()
		Constructor[] constructors=cls.getConstructors();
		System.out.println("构造器如下：");
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