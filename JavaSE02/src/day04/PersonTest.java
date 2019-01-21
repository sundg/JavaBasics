package day04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//FilterInputStream �߼����ĸ���
public class PersonTest {
	public static void main(String[] args) throws Exception {
		//���л�����
		Person p=new Person("С��",23,1);
		FileOutputStream fos=new FileOutputStream("person.obj");
		DataOutputStream dos=new DataOutputStream(fos);
		dos.writeUTF(p.getName());
		dos.writeInt(p.getAge());
		dos.writeInt(p.getSex());
		dos.close();
		
		//�����л�����
		FileInputStream fis=new FileInputStream("person.obj");
		DataInputStream dis=new DataInputStream(fis);
		String name=dis.readUTF();
		int age=dis.readInt();
		int sex=dis.readInt();
		Person person=new Person(name,age,sex);
		System.out.println(person);
	}
}
