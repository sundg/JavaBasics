package day03;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/*
 * 带自动上刷新的缓冲字符输出流
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream("pw2.txt");
		/*
		 * 	PrintWriter(OutputStream out)	
		 * 	PrintWriter(OutputStream out,boolean autoFlush)
		 * 创建一个带有自动行刷新的缓冲字符输出流
		 * 每当调用println()，注意是带有的方法
		 * 就会在写操作之后自动调用flush()		
		 */
		PrintWriter writer=new PrintWriter(fos,true);
		writer.print("呵呵呵");//这里在写出后，会自动调用flush()进行行刷新
		writer.close();
	}
}
