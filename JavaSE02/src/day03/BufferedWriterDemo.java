package day03;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/*
 * 缓冲字符输出流
 */
public class BufferedWriterDemo {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream("bw.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		/*
		 * BufferedWriter(Writer writer)
		 * 将给定的字符输出流转换为缓冲字符输出流
		 */
		BufferedWriter bw=new BufferedWriter(osw);
		bw.write("你好");
		bw.close();
	}

}
