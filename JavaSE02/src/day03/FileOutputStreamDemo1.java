package day03;

import java.io.File;
import java.io.FileOutputStream;

/*
 * 文件字节输出流
 * write方法的3个重载方法
 */
public class FileOutputStreamDemo1 {
	public static void main(String[] args) throws Exception {
		/*
		 * FileOutputStream(String fileName)
		 * 基于给定的文件名，创建用于写该文件的输出流
		 */
		FileOutputStream fos=new FileOutputStream("fos.dat",true);
		/*
		 * FileOutputStream(File file)
		 * 
		 */
//		fos=new FileOutputStream(new File("fos.dat"));
		/*
		 * void write(int d)
		 * 写出一个字节，写的是给定的int值得低8位
		 */
		fos.write('A');
		/*
		 * void write(byte[] b)
		 * 将给定的字节数组中所有字节一次性写出
		 */
		String str="学码思";
		byte[] data=str.getBytes("utf-8");
		fos.write(data);
		/*
		 * void write(byte[] d,int start,int len)
		 * 
		 */
		fos.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
