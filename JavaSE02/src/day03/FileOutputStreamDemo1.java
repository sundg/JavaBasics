package day03;

import java.io.File;
import java.io.FileOutputStream;

/*
 * �ļ��ֽ������
 * write������3�����ط���
 */
public class FileOutputStreamDemo1 {
	public static void main(String[] args) throws Exception {
		/*
		 * FileOutputStream(String fileName)
		 * ���ڸ������ļ�������������д���ļ��������
		 */
		FileOutputStream fos=new FileOutputStream("fos.dat",true);
		/*
		 * FileOutputStream(File file)
		 * 
		 */
//		fos=new FileOutputStream(new File("fos.dat"));
		/*
		 * void write(int d)
		 * д��һ���ֽڣ�д���Ǹ�����intֵ�õ�8λ
		 */
		fos.write('A');
		/*
		 * void write(byte[] b)
		 * ���������ֽ������������ֽ�һ����д��
		 */
		String str="ѧ��˼";
		byte[] data=str.getBytes("utf-8");
		fos.write(data);
		/*
		 * void write(byte[] d,int start,int len)
		 * 
		 */
		fos.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
