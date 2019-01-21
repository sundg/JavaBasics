package day01.fileDemo;

import java.io.File;
import java.io.IOException;

//�ݹ��г�Ŀ¼������	listFile()	
public class FileDemo9 {
	public static void main(String[] args) {
		listFile(new File("src"));
	}
	public static void listFile(File file){
		if(!file.exists()||file==null){
			throw new RuntimeException("������");
		}
		try {
			if(file.isFile()){
				System.out.println("�ļ�����"+file.getName());
				return;
			}
			File[] files=file.listFiles();
			for(File sub:files){
				listFile(sub);
			}
			System.out.println("�ļ�������"+file.getName());
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
