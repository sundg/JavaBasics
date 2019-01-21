package day01.fileDemo;

import java.io.File;
import java.io.IOException;

//查看当前目录下的所有子项
public class FileDemo6 {
	public static void main(String[] args) throws IOException {
		/*
		 *查看当前目录下所有子项 
		 */
		File dir=new File(".");
		System.out.println(dir.getCanonicalPath());
		//先判断当前File描述的是否是一个目录
		if(dir.isDirectory()){
			/*
			 * String list()
			 * 获取当前目录下所有子项的名字
			 */
//			String[] subNames=dir.list();
//			for(String sub:subNames){
//				System.out.println(sub);
//			}
			/*
			 * File[] listFiles()
			 * 获取当前目录下的所有子项
			 */
			File[] subs=dir.listFiles();
			for(File file:subs){
				System.out.println(file.isFile()?"文件":"目录");
				System.out.println(file.getName());
				System.out.println(file.length());
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
