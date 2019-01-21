package day01.fileDemo;

import java.io.File;
import java.io.IOException;

//创建文件
public class FileDemo5 {
	public static void main(String[] args) throws IOException {
		/*
		 * 创建g/h/j/k/l/mm.txt
		 */
		File file=new File("g"+File.separator+
							"h"+File.separator+
							"j"+File.separator+
							"k"+File.separator+
							"l"+File.separator+
							"mm.txt");
		if(!file.exists()){
			/*
			 * File getParentFile()
			 * 获取当前file对象所描述的文件或目录的父目录
			 * 这个例子中就是l目录
			 */
			File dir=file.getParentFile();
			if(!dir.exists()){
				dir.mkdirs();
			}
			file.createNewFile();
			System.out.println("创建完毕");
		}
 		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
