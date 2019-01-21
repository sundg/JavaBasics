package day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 使用字符流复制文本文件
 */
public class CopyDemo2 {
	public static void main(String[] args) throws Exception{
		/*
		 * 拷贝当前程序的源代码到项目的根目录
		 */
//		FileInputStream fis=new FileInputStream("src"+File.separator+"day03"+File.separator+"CopyDemo2.java");
		FileInputStream fis=new FileInputStream("D:\\Program Files\\Java\\jdk1.6.0\\bin\\appletviewer.exe");
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		FileOutputStream fos=new FileOutputStream("CopyDemo2.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		int len=-1;
		while((len=isr.read())!=-1){
			osw.write(len);
		}
		System.out.println("复制完毕");
		isr.close();
		osw.close();
		
	}
}
