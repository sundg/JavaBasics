package day03;

import java.io.RandomAccessFile;

/*
 * �����ļ�
 * һ���ֽ�һ���ֽڵĶ�
 * */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws Exception {
		//��ȡԴ�ļ�
		RandomAccessFile src=new RandomAccessFile("tomcat-6.0.35.rar","r");
		//����д�ļ�
		RandomAccessFile des=new RandomAccessFile("tomcatCopy.rar","rw");
		int d=-1;
		long start=System.currentTimeMillis();
		while((d=src.read())!=-1){
			des.write(d);
		}
		long end=System.currentTimeMillis();
		System.out.println("��ʱ"+(end-start)+"����");
		System.out.println("�������");
		src.close();
		des.close();
	}
}
