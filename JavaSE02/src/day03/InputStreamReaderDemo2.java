package day03;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 使用指定的字符集读取字符
 */
public class InputStreamReaderDemo2 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("osw2.txt");
		/*
		 * InputStreamReader(InputStream input,String charset)
		 * 
		 */
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		int c=-1;
		while((c=isr.read())!=-1){
			System.out.println((char)c);
		}
		isr.close();
	}
}
