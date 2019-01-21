package day03;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//使用自动行刷新，并制定字符集写文本文件
public class PrintWriterDemo3 {
	public static void main(String[] args) throws Exception{
		/*
		 * PrintWriter(Writer writer)
		 * PrintWriter(OutputStream out,boolean autoFlush)
		 * 创建一个带有自动行刷新的缓冲字符输出流
		 */
		//用于写文件
		FileOutputStream fos=new FileOutputStream("pw3.txt");
		//用于指定字符集
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		//用于自动行刷新并写字符串
		PrintWriter writer=new PrintWriter(osw,true);
		writer.println("哈哈");
		writer.close();
	}
}
