package day02.randomAccessFiledemo;

import java.io.RandomAccessFile;

//��д�ַ���
public class RandomAccessFileDemo4 {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf=new RandomAccessFile("raf3.dat", "rw");
		String str="����һ���ַ���";
		/*
		byte[] data=str.getBytes("utf-8");
		raf.writeInt(data.length);
		raf.write(data);
		raf.seek(0);
		int len =raf.readInt();
		byte[] strData=new byte[len];
		raf.read(strData);
		String str2=new String(strData,"utf-8");
		System.out.println(str2);
		*/
		
		/*
		 * ��д�ַ���
		 */
		raf.writeUTF(str);
		raf.seek(0);
		String str2=raf.readUTF();
		System.out.println(str2);
		raf.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
