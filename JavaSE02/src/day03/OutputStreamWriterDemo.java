package day03;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/*
 * �ַ������
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
		 * дһ���ַ�(char)��д������intֵ��"��16λ"
		 * 
		 * void write(char[] c)
		 * һ���Խ������ַ������е������ַ�д��
		 * 
		 * void write(char[] c,int start,int len)
		 * �������ַ������д�start����ʼ������len���ַ�д��
		 * start+len���ܳ��������length
		 * start����С��0���Ŵ��ڵ��������length
		 * len����С��
		 * 
		 * void write(String str)
		 * ���������ַ���ת��Ϊ�ַ���д��
		 * 
		 * void write(String str,int start,int len)
		 * ���������ַ����д�start����ʼ������len���ַ�д��
		 * 
		 */
		//Ĭ������£�write�����Ὣ��ǰ�ַ�������ϵͳĬ�ϵ��ַ���ת��Ϊ �ֽں�д��
		osw.write("��Һ�!");
		osw.write("123456", 3, 2);
		osw.write(123);
		osw.close();
	}
}
