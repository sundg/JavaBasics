package day03;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

//
public class OutputStreamWriteDemo2 {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("osw2.txt");
		/*
		 * OutputStreamWriter(outputstream output,String charset)
		 * 
		 */
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		osw.write("´ó¼ÒºÃ!");
		osw.close();
	}
}
