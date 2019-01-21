package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 使用缓冲字符输入输出流复制文本文件
 */
public class CopyDemo3 {
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("src"+File.separator+"day03"+File.separator+"CopyDemo3.java");
		InputStreamReader isr=new InputStreamReader(fis,"gbk");
		BufferedReader br=new BufferedReader(isr);
		FileOutputStream fos=new FileOutputStream("CopyDemo3.java");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
		BufferedWriter bw=new BufferedWriter(osw);
		/*
		 * 缓冲字符输入流readLine()方法若返回null
		 * 表示EOF
		 */
		String line=null;
		while((line=br.readLine())!=null){
			bw.write(line);
			/*
			 * BufferedWriter有一个方法
			 * void newLine()
			 * 输出一个当前系统支持的换行符
			 */
			bw.newLine();
		}
//		int c=-1;
//		while((c=br.read())!=-1){
//			bw.write(c);
//		}
		System.out.println("复制完毕");
		br.close();
		bw.close();
	}
}
