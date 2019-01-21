package day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 * �ļ��ֽ�������
 */
public class FileInputStreamDemo1 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		try {
			/*
			 * FileInputStream(String fileName)
			 * FileInputStream(File file)
			 */
			fis=new FileInputStream("fos.dat");
//			fis=new FileInputStream(new File("fos.dat"));
			
			/*
			 * int read()
			 * ��ȡһ���ֽڣ�����intֵ����ʽ���أ�"��8λ"
			 * ������-1��˵��EOF
			 */
			char a=(char) fis.read();
			System.out.println(a);
			/*
			 * int read(byte[] b)
			 * һ���Գ��Զ�ȡ���������鳤�ȵ��ֽ���������������������У�
			 * ����ֵΪʵ�ʶ�ȡ�����ֽ���
			 */
			byte[] array=new byte[100];
			int len=fis.read(array);
			System.out.println(len);
			System.out.println(Arrays.toString(array));
			/*
			 * String(byte[] b,int start,int len,String charSetName)
			 */
			String str=new String(array,0,len,"utf-8");
			System.out.println(str);
			/*
			 * int read(byte[] b,int start,int len)
			 * �Ӹ���������ȡlen���ֽڲ��Ӹ����ֽ������start����ʼ����
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(fis!=null){
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
