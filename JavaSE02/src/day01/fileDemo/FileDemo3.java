package day01.fileDemo;

import java.io.File;

/*
 * 创建目录
 * a/b/c/d/e/f
 */
public class FileDemo3 {
	public static void main(String[] args) {
		File dir=new File("a"+File.separator+"b"+File.separator+"c"+File.separator+"d"+File.separator+"e"+File.separator+"f");
		System.out.println("是否存在："+dir.exists());
		if(!dir.exists()){
			/*
			 * boolean mkdirs()
			 * 创建当前目录时会连同创建所有不存在的父目录
			 */
			dir.mkdirs();
			System.out.println("创建完毕");
		}
		System.out.println("是否存在："+dir.exists());
	}
}
