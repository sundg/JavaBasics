package day01.fileDemo;

import java.io.File;

/*
 * ʹ��File���󴴽�Ŀ¼
 */
public class FileDemo2 {
	public static void main(String[] args) {
		/*
		 * �ڵ�ǰĿ¼��(��Ŀ�ĸ�Ŀ¼)����һ��demo
		 * ./demo    �����"./"���Ժ��ԣ�Ĭ�Ͼ����ڵ�ǰĿ¼
		 */
		File file=new File("demo");
		System.out.println("�Ƿ���ڣ�"+file.exists());
		if(!file.exists()){
			/*
			 * boolean mkdir()
			 * ������ǰFile����·������������Ŀ¼
			 */
			file.mkdir();
		}
		System.out.println("�Ƿ���ڣ�"+file.exists());
	}
}
