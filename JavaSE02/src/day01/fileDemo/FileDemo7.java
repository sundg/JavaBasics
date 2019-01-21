package day01.fileDemo;

import java.io.File;

//删除文件或者目录
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * 删除项目根目录下的demo.txt
		 */
		File file =new File("demo.txt");
		file.delete();
		System.out.println("删除文件");
		/*
		 * 删除项目根目录下的目录demo
		 * 删除目录有一个前提条件：
		 * 		必须保证该目录是空目录(不好任何子项)，才可以删除成功
		 */
		File dir =new File("demo");
		dir.delete();
		System.out.println("目录删除完毕");
	}
}
