package day04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonTest2 {
	public static void main(String[] args)  throws Exception{
		/*
		 * 使用ObjectOutputStream进行对象序列化
		 */
		List<String> list=new ArrayList<String>();
		list.add("第一个其他信息");
		list.add("第一个其他信息");
		list.add("第一个其他信息");
		Person2 person=new Person2("小三",23,0,"个人信息",list);
		FileOutputStream fos=new FileOutputStream("person2.obj");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		/*
		 * void writeObject(Object o)
		 */
		oos.writeObject(person);
		oos.close();
		//对象的反序列化过程
		FileInputStream fis=new FileInputStream("person2.obj");
		ObjectInputStream ois=new ObjectInputStream(fis);
		/*
		 * Object readObject(Object o)
		 */
//		Object obj= ois.readObject();
		Person2 obj= (Person2)ois.readObject();
		System.out.println(obj);
		ois.close();
		
		System.out.println(person.equals(obj));//false
	}
}
