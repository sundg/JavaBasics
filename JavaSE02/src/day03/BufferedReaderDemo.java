package day03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * �����ַ�������
 */
public class BufferedReaderDemo {
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("bw.txt");
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		BufferedReader br=new BufferedReader(isr);
		/*
		 * BufferedReader���еķ���
		 * String readLine()
		 * һ�ζ�ȡһ���ַ���
		 * ������ȡ���ɸ��ַ���֪����ȡ�����з�Ϊֹ
		 * ���ص��ַ����в��������з�
		 */
		String str=br.readLine();
		System.out.println(str);
//		int c=-1;
//		while((c=br.read())!=-1){
//			System.out.println((char)c);
//		}
		br.close();
	}
}
