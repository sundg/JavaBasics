package day03;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/*
 * 字符输出流
 */
public class OutputStreamWriterDemo {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream("osw.txt");
		/*
		 * OutputStreamWriter(outputstream out)
		 */
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		/*
		 * void write(int d)
		 * 写一个字符(char)，写给定的int值的"低16位"
		 * 
		 * void write(char[] c)
		 * 一次性将给定字符数组中的所有字符写出
		 * 
		 * void write(char[] c,int start,int len)
		 * 将给定字符数组中从start处开始连续将len个字符写出
		 * start+len不能超过数组的length
		 * start不能小于0挥着大于等于数组的length
		 * len不能小于
		 * 
		 * void write(String str)
		 * 将给定的字符串转换为字符后写出
		 * 
		 * void write(String str,int start,int len)
		 * 将给定的字符串中从start处开始连续将len个字符写出
		 * 
		 */
		//默认情况下，write方法会将当前字符串按照系统默认的字符集转换为 字节后写出
		osw.write("大家好!");
		osw.write("123456", 3, 2);
		osw.write(123);
		osw.close();
	}
}
