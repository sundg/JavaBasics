package day03;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * 使用文件的字节输入输出流复制文件
 */
public class CopyDemo1 {
	public static void main(String[] args) throws Exception {
		//读取文件流
		FileInputStream fis=new FileInputStream("tomcat-6.0.35.rar");
		//写文件
		FileOutputStream fos=new FileOutputStream("tomcatCopy11.rar");
		int len=-1;
		byte[] b=new byte[1024*10];
		long start=System.currentTimeMillis();
		while((len=fis.read(b))>0){
			fos.write(b,0,len);
		}
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		fis.close();
		fos.close();
	}
}
