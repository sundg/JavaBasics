package day03;

import java.io.FileInputStream;
import java.io.InputStreamReader;


/*
 * 字符输入流
 */
public class InputStreamReaderDemo {
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("osw.txt");
		InputStreamReader isr=new InputStreamReader(fis);
		/*
		 * int read()
		 * 读取一个字符，以int形式返回，该int值"低16位"
		 * 
		 * int read(char[] c)
		 * 一次最多尝试读取给定数组的length个字符
		 * 并存入数组，返回值为实际读取到的字符量
		 * 
		 * int read(char[] c,int start,int len)
		 */
		int c=-1;
		while((c=isr.read())!=-1){
			char chs=(char) c;
			System.out.println(chs);
		}
		isr.close();
	}
}
