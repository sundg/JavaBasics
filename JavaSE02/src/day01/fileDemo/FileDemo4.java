package day01.fileDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageOutputStream;

/*
 * �����ļ�
 */
public class FileDemo4 {
	public static void main(String[] args) throws IOException {
		/*
		 * �ڵ�ǰĿ¼�´���demo.txt
		 */
		File file=new File("demo.txt");
		if(!file.exists()){
			/*
			 * ����File�������������ļ�
			 */
			file.createNewFile();
			System.out.println("�������");
		}
		
		/*
		 * ��demoĿ¼�£�����demo.txt
		 */
		File dir=new File("demo");
		if(!dir.exists()){
			dir.mkdir();
			System.out.println("�������");
		}
		/*
		 * File(File dir,String fileName)
		 * �ڸ�����File������������Ŀ¼�б�ʾ�������ֵ��ļ���Ŀ¼
		 */
		File file1=new File(dir,"demo.txt");
		if(!file1.exists()){
			file1.createNewFile();
			System.out.println("�������");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
