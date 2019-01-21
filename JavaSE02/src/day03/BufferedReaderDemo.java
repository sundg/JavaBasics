package day03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 缓冲字符输入流
 */
public class BufferedReaderDemo {
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("bw.txt");
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		BufferedReader br=new BufferedReader(isr);
		/*
		 * BufferedReader独有的方法
		 * String readLine()
		 * 一次读取一行字符串
		 * 连续读取若干个字符，知道读取到换行符为止
		 * 返回的字符串中不包含换行符
		 */
		String str=br.readLine();
		System.out.println(str);
//		int c=-1;
//		while((c=br.read())!=-1){
//			System.out.println((char)c);
//		}
		br.close();
	}
}
