package day01.fileDemo;

import java.io.File;
import java.io.IOException;

//�ݹ�ɾ��
public class FileDemo8 {
	public static void main(String[] args) {
		// ɾ����Ŀ¼�µ�gĿ¼
		delete(new File("g"));
	}

	// ��������file��������ʾ���ļ������ļ�ɾ��
	/*
	 * delete ������ɾ���ļ��л����ļ����� 1������Ƿ����ļ� a���������ļ���ֱ��ɾ�� b��������ļ��У��ҳ���������(�����ļ����ļ���)
	 * c��ɾ��ÿ�����ļ����ļ��У��ݹ���� d��ɾ����ǰ�ļ���
	 */
	public static void delete(File file) {
		if (file == null || !file.exists()) {
			throw new RuntimeException("������");
		}
		try {
			if (file.isFile()) {
				file.delete();
				System.out.println("ɾ����" + file.getCanonicalPath());
				return;
			}
			File[] file1 = file.listFiles();
			for (File dir : file1) {
				delete(dir);// �ݹ���ã�ɾ�����ļ����ļ���
				boolean success = file.delete();// ɾ����ǰĿ¼
				System.out.println(success ? "ɾ�����" : "ɾ��ʧ��");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ��ʧ��", e);
		}

	}
}
