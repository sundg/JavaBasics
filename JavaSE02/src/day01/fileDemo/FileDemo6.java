package day01.fileDemo;

import java.io.File;
import java.io.IOException;

//�鿴��ǰĿ¼�µ���������
public class FileDemo6 {
	public static void main(String[] args) throws IOException {
		/*
		 *�鿴��ǰĿ¼���������� 
		 */
		File dir=new File(".");
		System.out.println(dir.getCanonicalPath());
		//���жϵ�ǰFile�������Ƿ���һ��Ŀ¼
		if(dir.isDirectory()){
			/*
			 * String list()
			 * ��ȡ��ǰĿ¼���������������
			 */
//			String[] subNames=dir.list();
//			for(String sub:subNames){
//				System.out.println(sub);
//			}
			/*
			 * File[] listFiles()
			 * ��ȡ��ǰĿ¼�µ���������
			 */
			File[] subs=dir.listFiles();
			for(File file:subs){
				System.out.println(file.isFile()?"�ļ�":"Ŀ¼");
				System.out.println(file.getName());
				System.out.println(file.length());
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
