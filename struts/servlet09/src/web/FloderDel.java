package web;

import java.io.File;

public class FloderDel {
	
	public static void delFile(File file){
		if(file==null || !file.exists()){
			return;
		}
		if(file.isFile()){
			file.delete();
		}else{
			File[] files=file.listFiles();
			for(File f:files){
				delFile(f);
				boolean success=file.delete();
				System.out.println(success?"sunccess":"failer");
			}
		}
	}
}
