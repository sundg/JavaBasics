package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * ʹ�û����ַ���������������ı��ļ�
 */
public class CopyDemo3 {
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("src"+File.separator+"day03"+File.separator+"CopyDemo3.java");
		InputStreamReader isr=new InputStreamReader(fis,"gbk");
		BufferedReader br=new BufferedReader(isr);
		FileOutputStream fos=new FileOutputStream("CopyDemo3.java");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
		BufferedWriter bw=new BufferedWriter(osw);
		/*
		 * �����ַ�������readLine()����������null
		 * ��ʾEOF
		 */
		String line=null;
		while((line=br.readLine())!=null){
			bw.write(line);
			/*
			 * BufferedWriter��һ������
			 * void newLine()
			 * ���һ����ǰϵͳ֧�ֵĻ��з�
			 */
			bw.newLine();
		}
//		int c=-1;
//		while((c=br.read())!=-1){
//			bw.write(c);
//		}
		System.out.println("�������");
		br.close();
		bw.close();
	}
}
