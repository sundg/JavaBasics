package day02.randomAccessFiledemo;

import java.io.IOException;
import java.io.RandomAccessFile;

//��ȡ�ļ�
public class RandomAccessFileDemo2 {
	//
	public static void main(String[] args) {
		RandomAccessFile raf=null;
		try {
			raf=new RandomAccessFile("raf.dat","r");
			/*
			 * int read()
			 * ���ļ��ж�ȡһ���ֽڣ�����intֵ����ʽ����
			 * ��intֵֻ�е�8λ��Ч
			 * ������ֵΪ-1����˵��EOF
			 * end of file���ļ�����ĩβ
			 */
			char a=(char) raf.read();
			System.out.println(a);
			char b=(char) raf.read();
			System.out.println(b);
			//��ȡ"��Һ�ѽ!"��������ȡ13���ֽڣ��ȶ�ȡһ��intֵ
			//�ѵ�֪���ַ���ռ�õ��ֽ���
			int len=raf.readInt();
			//�����ַ���ռ�õ��ֽ��������ֽ�����
			byte[] strData=new byte[len];
//			for(int i=0;i<len;i++){
//				strData[i]=(byte) raf.read();
//			}
			/*
			 * int read(byte[] b)
			 * һ���Գ�������ȡ�������ֽ�������ֽڣ������뵽�������ֽ������У�
			 * ����Ϊʵ�ʶ�ȡ�����ֽ���
			 */
			raf.read(strData);
			String str=new String(strData,"utf-8");
			System.out.println(str);
			
			/*
			 * readInt()
			 * readLong()
			 * readChar()
			 * readDouble()
			 */
			int i=raf.readInt();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(raf!=null){
					raf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
