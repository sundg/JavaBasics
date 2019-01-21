package day03;

import java.io.File;
import java.io.PrintWriter;

public class PrintWriterDemo1 {
	public static void main(String[] args) throws Exception {
		/*
		 * PrintWriter(File file)
		 * 
		 * PrintWriter(File file,String charset)
		 */
//		PrintWriter writer=new PrintWriter(new File("px.txt"),"utf-8");
		/*
		 * PrintWriter(String fileName)
		 * 
		 * PrintWriter(String fileName,String charset)
		 * 在写文件时，还可以指定字符集
		 */
		PrintWriter writer=new PrintWriter("px.txt","utf-8");
		
		writer.println("呵呵");
		writer.print("呵呵");
		writer.print("呵呵");
		writer.close();
	}
}
