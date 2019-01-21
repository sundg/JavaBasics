package day02.randomAccessFiledemo;

import java.io.File;
import java.io.RandomAccessFile;

public class RAFDemo2 {
	public static void main(String[] args) throws Exception {
		File file=new File("demo3.dat");
		RandomAccessFile raf=new RandomAccessFile(file, "rw");
		raf.writeInt(0x121A);//��������д��4��byte
		raf.close();
		raf=new RandomAccessFile(file, "r");
//		raf.writeInt(0x121A);
		int i=raf.readInt();//����������ȡ4��byte��ƴ��Ϊint
		System.out.println(Integer.toHexString(i));
		raf.close();
	}
}
