package day02.randomAccessFiledemo;

import java.io.File;
import java.io.RandomAccessFile;

public class RAFDemo1 {
	public static void main(String[] args) throws Exception {
		File file=new File("sdf.fg");
		/*
		 * 打开文件，自动创建文件，指针在0
		 */
		RandomAccessFile sdf=new RandomAccessFile(file, "rw");
		System.out.println(sdf.getFilePointer());
		int i=100;
		System.out.println(Integer.toBinaryString(i));
		sdf.write(i);
		i=0x121A;
		System.out.println(Integer.toBinaryString(i));
		sdf.write(i);
		
		//读取
		sdf.seek(0);//移动文件指针
		i=sdf.read();
		System.out.println(Integer.toBinaryString(i));
		i=sdf.read();
		System.out.println(Integer.toBinaryString(i));
		i=sdf.read();//返回32个1，表示到文件的末尾
		System.out.println(Integer.toBinaryString(i));
		sdf.close();
	}
}
