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
		 * ʹ��ObjectOutputStream���ж������л�
		 */
		List<String> list=new ArrayList<String>();
		list.add("��һ��������Ϣ");
		list.add("��һ��������Ϣ");
		list.add("��һ��������Ϣ");
		Person2 person=new Person2("С��",23,0,"������Ϣ",list);
		FileOutputStream fos=new FileOutputStream("person2.obj");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		/*
		 * void writeObject(Object o)
		 */
		oos.writeObject(person);
		oos.close();
		//����ķ����л�����
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
