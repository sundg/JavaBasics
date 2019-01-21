package day03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/*
 * 使用FileWriter写文本文件
 */
public class FileWriterDemo {
	public static void main(String[] args) throws Exception {
//		FileWriter writer=new FileWriter(new File("fw.txt"));
		/*
		 * 可以直接对文件写字符
		 * 使用FileWriter或者FileReader
		 * 就默认许可了使用当前系统默认的字符集进行读写
		 */
		FileWriter writer=new FileWriter("fw.txt");
		BufferedWriter bw=new BufferedWriter(writer);
		bw.write("呵呵呵");
		bw.close();
	}
}
