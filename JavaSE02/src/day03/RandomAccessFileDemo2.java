package day03;

import java.io.RandomAccessFile;
/*
 * ���ڻ����������ļ�
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws Exception {
		//��ȡԴ�ļ�
		RandomAccessFile src=new RandomAccessFile("tomcat-6.0.35.rar","r");
		//����д�ļ�
		RandomAccessFile des=new RandomAccessFile("tomcatCopy.rar","rw");
		//����һ���ֽ�����
		byte[] buffer=new byte[1024*20];
		//����һ������ʵ�ʶ�ȡ�����ֽ���
		int len=-1;
		long start=System.currentTimeMillis();
		while((len=src.read(buffer))>0){
			/*
			 * void write(byte[] b,int start,int len)
			 * ���������ַ������д�start����ʼ������len���ֽ�д��
			 */
			des.write(buffer, 0, len);
		}
		long end=System.currentTimeMillis();
		System.out.println("��ʱ"+(end-start)+"����");
		System.out.println("�������");
		src.close();
		des.close();
	}
}
