package day03;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * ʹ��ָ�����ַ�����ȡ�ַ�
 */
public class InputStreamReaderDemo2 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("osw2.txt");
		/*
		 * InputStreamReader(InputStream input,String charset)
		 * 
		 */
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");
		int c=-1;
		while((c=isr.read())!=-1){
			System.out.println((char)c);
		}
		isr.close();
	}
}
