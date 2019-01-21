package day03;

import java.io.FileReader;

/*
 * 使用FileReader读取文本文件
 */
public class FileReaderDemo {
	public static void main(String[] args) throws Exception {
		FileReader reader=new FileReader("fw.txt");
		int c=-1;
		while((c=reader.read())!=-1){
			System.out.println((char)c);
		}
		reader.close();
	}
}
