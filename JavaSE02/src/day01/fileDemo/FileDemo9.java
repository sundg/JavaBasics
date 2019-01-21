package day01.fileDemo;

import java.io.File;
import java.io.IOException;

//递归列出目录的内容	listFile()	
public class FileDemo9 {
	public static void main(String[] args) {
		listFile(new File("src"));
	}
	public static void listFile(File file){
		if(!file.exists()||file==null){
			throw new RuntimeException("不存在");
		}
		try {
			if(file.isFile()){
				System.out.println("文件名："+file.getName());
				return;
			}
			File[] files=file.listFiles();
			for(File sub:files){
				listFile(sub);
			}
			System.out.println("文件夹名："+file.getName());
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
