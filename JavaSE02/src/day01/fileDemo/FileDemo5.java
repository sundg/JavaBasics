package day01.fileDemo;

import java.io.File;
import java.io.IOException;

//�����ļ�
public class FileDemo5 {
	public static void main(String[] args) throws IOException {
		/*
		 * ����g/h/j/k/l/mm.txt
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
			 * ��ȡ��ǰfile�������������ļ���Ŀ¼�ĸ�Ŀ¼
			 * ��������о���lĿ¼
			 */
			File dir=file.getParentFile();
			if(!dir.exists()){
				dir.mkdirs();
			}
			file.createNewFile();
			System.out.println("�������");
		}
 		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
