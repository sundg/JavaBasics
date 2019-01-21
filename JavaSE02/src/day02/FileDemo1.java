package day02;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
	public static void main(String[] args) {
		File file=new File(".");
		listFile(file);
	}
	public static void listFile(File file){
		if(file==null||!file.exists()){
			throw new RuntimeException("û���ļ�");
		}
		try {
			if(file.isFile()){
				System.out.println(file.getCanonicalPath());
				return;
			}
			System.out.println("["+file.getCanonicalPath()+"]");
			File[] files=file.listFiles();
			for(File sub:files){
				listFile(sub);//�ݹ����
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
