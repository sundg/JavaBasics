package day03;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/*
 * �����ַ������
 */
public class BufferedWriterDemo {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream("bw.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		/*
		 * BufferedWriter(Writer writer)
		 * ���������ַ������ת��Ϊ�����ַ������
		 */
		BufferedWriter bw=new BufferedWriter(osw);
		bw.write("���");
		bw.close();
	}

}
