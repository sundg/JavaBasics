package day01.fileDemo;

import java.io.File;

//ɾ���ļ�����Ŀ¼
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * ɾ����Ŀ��Ŀ¼�µ�demo.txt
		 */
		File file =new File("demo.txt");
		file.delete();
		System.out.println("ɾ���ļ�");
		/*
		 * ɾ����Ŀ��Ŀ¼�µ�Ŀ¼demo
		 * ɾ��Ŀ¼��һ��ǰ��������
		 * 		���뱣֤��Ŀ¼�ǿ�Ŀ¼(�����κ�����)���ſ���ɾ���ɹ�
		 */
		File dir =new File("demo");
		dir.delete();
		System.out.println("Ŀ¼ɾ�����");
	}
}
