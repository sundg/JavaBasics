package day02.randomAccessFiledemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

//���ڶ�д�ļ�����
public class RandomAccessFileDemo1 {
	public static void main(String[] args) {
		RandomAccessFile raf=null;
		try {
//			File file=new File("raf.dat");
			//֮ǰ������file���󣬿����ô˹��췽��
//			raf=new RandomAccessFile(file,"rw");
			
			//֮ǰû�д�����file���󣬿����ô˹��췽��
			raf=new RandomAccessFile("raf.dat","rw");
			/*
			 * write(int d)
			 * д���intֵ��"��8λ"
			 */
			//Ӣ����ĸ����ֱ��ʹ��write����д������Ϊһ���ֽھͿ�������
			raf.write('A');
			raf.write('B');
			//�������Ĳ��У���Ϊ����Ҫ��2���ֽ�
//			raf.write('��');
//			raf.seek(2);
//			System.out.println(raf.read());
			
			String str="��Һ�ѽ!";
			/*
			 * Ҫ��д�ַ�����Ҫ�Ƚ��ַ�������ĳ���ַ���ת��Ϊ�ֽں���д��
			 */
			byte[] strData=str.getBytes("utf-8");
			System.out.println(strData.length);
//			for(byte b:strData){
//				raf.write(b);
//			}
			//д�ַ���֮ǰ����дһ����������¼���ַ���ռ���˶��ٸ��ֽڣ��Ա��պ��ȡ
			raf.writeInt(strData.length);
			/*
			 * write(byte[] b)
			 * ���������ֽ����������е��ֽ�һ����д��
			 */
			raf.write(strData);
			//int���ֵ
			int max=Integer.MAX_VALUE;
			//���дintֵ
			//λ�Ʒ���">>>"
			raf.write(max>>>24);//д��int�ĸ�8λ
			raf.write(max>>>16);
			raf.write(max>>>8);
			raf.write(max);
			/*
			 * writeInt(int d)
			 * ����д4���ֽڣ���������intֵд��
			 */
			int min=Integer.MIN_VALUE;
			raf.writeInt(min);
			
			long l=123456l;
			raf.writeLong(l);
			raf.writeChar('��');
			double d=123.456;
			
			raf.writeDouble(d);
			float fl=123.123f;
			raf.writeFloat(fl);
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
