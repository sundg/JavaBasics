package day03;

import java.io.FileInputStream;
import java.io.InputStreamReader;


/*
 * �ַ�������
 */
public class InputStreamReaderDemo {
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("osw.txt");
		InputStreamReader isr=new InputStreamReader(fis);
		/*
		 * int read()
		 * ��ȡһ���ַ�����int��ʽ���أ���intֵ"��16λ"
		 * 
		 * int read(char[] c)
		 * һ����ೢ�Զ�ȡ���������length���ַ�
		 * ���������飬����ֵΪʵ�ʶ�ȡ�����ַ���
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
