package day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * ʹ���ַ��������ı��ļ�
 */
public class CopyDemo2 {
	public static void main(String[] args) throws Exception{
		/*
		 * ������ǰ�����Դ���뵽��Ŀ�ĸ�Ŀ¼
		 */
//		FileInputStream fis=new FileInputStream("src"+File.separator+"day03"+File.separator+"CopyDemo2.java");
		FileInputStream fis=new FileInputStream("D:\\Program Files\\Java\\jdk1.6.0\\bin\\appletviewer.exe");
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		FileOutputStream fos=new FileOutputStream("CopyDemo2.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		int len=-1;
		while((len=isr.read())!=-1){
			osw.write(len);
		}
		System.out.println("�������");
		isr.close();
		osw.close();
		
	}
}
