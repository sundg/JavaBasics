package day02.randomAccessFiledemo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * ������̨���������д���ļ�
 */
public class RandomAccessFileDemo5 {
	public static void main(String[] args) throws Exception {
		/*
		 * 1������Scanner
		 * 2������RandonAccessFile���ڽ�����д���ļ�
		 * 3������ѭ��
		 * 		3.1����Scanner�ж�ȡһ���ַ���(����̨���������)
		 * 		3.2��ͨ��RandomAccessFile���ļ�д��
		 */
		Scanner sc=new Scanner(System.in);
		RandomAccessFile raf=new RandomAccessFile("aaa.txt","rw");
		/*
		 * ��һ�����ͽ�RandomAccessFile���α�һ�����ļ���ĩβ������׷������
		 * ������д������ݽ�����ǰ�������
		 */
		String str=null;
		try {
			while(true){
				System.out.println("�����뽫Ҫ��������ݣ�");
				str=sc.nextLine();
				if("exit".equals(str))
					break;
				raf.seek(raf.length());
				raf.writeUTF(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(raf!=null){
					raf.close();
					System.out.println("��лʹ�ã��ټ�");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
