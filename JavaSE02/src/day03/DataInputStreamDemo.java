package day03;

import java.io.DataInputStream;
import java.io.FileInputStream;

/*
 * DIS:���������Ķ��⹦���Ƿ����ȡ�����������ݵĸ߼���
 */
public class DataInputStreamDemo {
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("dos.txt");
		DataInputStream dis=new DataInputStream(fis);
		int i=dis.readInt();
		long l=dis.readLong();
		double d=dis.readDouble();
		String str=dis.readUTF();
		System.out.println(i);
		System.out.println(l);
		System.out.println(d);
		System.out.println(str);
		dis.close();
	}
}
