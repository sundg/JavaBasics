package day01.fileDemo;

import java.io.File;

/*
 * ����Ŀ¼
 * a/b/c/d/e/f
 */
public class FileDemo3 {
	public static void main(String[] args) {
		File dir=new File("a"+File.separator+"b"+File.separator+"c"+File.separator+"d"+File.separator+"e"+File.separator+"f");
		System.out.println("�Ƿ���ڣ�"+dir.exists());
		if(!dir.exists()){
			/*
			 * boolean mkdirs()
			 * ������ǰĿ¼ʱ����ͬ�������в����ڵĸ�Ŀ¼
			 */
			dir.mkdirs();
			System.out.println("�������");
		}
		System.out.println("�Ƿ���ڣ�"+dir.exists());
	}
}
