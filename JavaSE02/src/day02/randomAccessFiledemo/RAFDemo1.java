package day02.randomAccessFiledemo;

import java.io.File;
import java.io.RandomAccessFile;

public class RAFDemo1 {
	public static void main(String[] args) throws Exception {
		File file=new File("sdf.fg");
		/*
		 * ���ļ����Զ������ļ���ָ����0
		 */
		RandomAccessFile sdf=new RandomAccessFile(file, "rw");
		System.out.println(sdf.getFilePointer());
		int i=100;
		System.out.println(Integer.toBinaryString(i));
		sdf.write(i);
		i=0x121A;
		System.out.println(Integer.toBinaryString(i));
		sdf.write(i);
		
		//��ȡ
		sdf.seek(0);//�ƶ��ļ�ָ��
		i=sdf.read();
		System.out.println(Integer.toBinaryString(i));
		i=sdf.read();
		System.out.println(Integer.toBinaryString(i));
		i=sdf.read();//����32��1����ʾ���ļ���ĩβ
		System.out.println(Integer.toBinaryString(i));
		sdf.close();
	}
}
