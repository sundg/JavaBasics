package day02.randomAccessFiledemo;

import java.io.RandomAccessFile;

/*
 * ֧�ֶ�д������������
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf=new RandomAccessFile("raf2.dat", "rw");
		//�����α굱ǰ��λ��
		long position=raf.getFilePointer();
		System.out.println(position);//0
		/*
		 * ��һ��intֵת��Ϊ�ֽں�д���ļ�
		 * 1����intֵת��Ϊ��4���ֽ�
		 * 	    ������ת��Ϊ�˶�Ӧ���ֽ����еĹ��̳�֮Ϊ"���л�"
		 * 	    �����������͵����л�
		 * 2����4���ֽ�д�����
		 *    ���ֽ�д����������ñ���Ĺ��̳�֮Ϊ"�־û�"
		 */
		raf.writeInt(123);
		position=raf.getFilePointer();
		System.out.println(position);
		
		/*
		 * RandomAccessFile�Ķ�д����ʱ�����α�ָ��ĵ�ǰλ�ý��еģ�
		 * ����������д�����ݺ����ͷ��ȡ���ݣ�Ҫ���α�"����"���ļ�����ʼλ��
		 * 
		 * void seek(long pos)
		 * ���α껬����ָ��λ��
		 */
		raf.seek(0);//���α껬������ʼλ��
		//���ֽ�����ת��Ϊ��Ӧ�����ݵĹ��̳�֮Ϊ"�����л�"
		int i=raf.readInt();
		System.out.println(i);
		raf.close();
		
		
		
		
		
		
		
		
		
		
		
	}
}
