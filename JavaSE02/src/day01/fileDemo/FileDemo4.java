package day01.fileDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageOutputStream;

/*
 * 创建文件
 */
public class FileDemo4 {
	public static void main(String[] args) throws IOException {
		/*
		 * 在当前目录下创建demo.txt
		 */
		File file=new File("demo.txt");
		if(!file.exists()){
			/*
			 * 创建File对象所描述的文件
			 */
			file.createNewFile();
			System.out.println("创建完毕");
		}
		
		/*
		 * 在demo目录下，创建demo.txt
		 */
		File dir=new File("demo");
		if(!dir.exists()){
			dir.mkdir();
			System.out.println("创建完毕");
		}
		/*
		 * File(File dir,String fileName)
		 * 在给定的File对象所描述的目录中表示给定名字的文件或目录
		 */
		File file1=new File(dir,"demo.txt");
		if(!file1.exists()){
			file1.createNewFile();
			System.out.println("创建完毕");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
