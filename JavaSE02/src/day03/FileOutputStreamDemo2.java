package day03;

import java.io.FileOutputStream;

/*
 * �ļ��ֽ������
 */
public class FileOutputStreamDemo2 {
	public static void main(String[] args) throws Exception {
//		FileOutputStream fos=new FileOutputStream("fos.dat");
		//������д�����ݣ����ļ�ԭ��������ȫ��������
//		fos.write('B');
//		fos.close();
		/*
		 * FileOutputStream(String fileName,boolean append)
		 * FileOutputStream(File file,boolean append)
		 * �ڵ�ǰ�ļ���׷��д����
		 */
		FileOutputStream fos=new FileOutputStream("fos.dat",true);
		fos.write('C');
		fos.close();
	}
}
