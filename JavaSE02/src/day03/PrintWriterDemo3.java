package day03;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//ʹ���Զ���ˢ�£����ƶ��ַ���д�ı��ļ�
public class PrintWriterDemo3 {
	public static void main(String[] args) throws Exception{
		/*
		 * PrintWriter(Writer writer)
		 * PrintWriter(OutputStream out,boolean autoFlush)
		 * ����һ�������Զ���ˢ�µĻ����ַ������
		 */
		//����д�ļ�
		FileOutputStream fos=new FileOutputStream("pw3.txt");
		//����ָ���ַ���
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		//�����Զ���ˢ�²�д�ַ���
		PrintWriter writer=new PrintWriter(osw,true);
		writer.println("����");
		writer.close();
	}
}
