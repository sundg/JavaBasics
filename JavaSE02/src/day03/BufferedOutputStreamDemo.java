package day03;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/*
 * �����ֽ������
 */
public class BufferedOutputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("bos.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		String str="����Ҫ�����˽���";
		byte[] data=str.getBytes("utf-8");
		bos.write(data);
		/*
		 * OutputStream�ж����һ������
		 * void flush()
		 * ��������������ȫ��д��
		 */
		bos.flush();
		/*
		 * ������ͨ�������ֽ���д�����ݺ�û�йر�����
		 * �������ǵ����ݲ�û��д���ļ��У���ʱ�����
		 * ��������������д���ļ���Ҫ�ֶ�����flush()
		 * ����ر������Զ�����flush()
		 * 
		 * 
		 * �ڹر�����ʱ������ֻ��Ҫ�ر������ĸ߼������ɣ�
		 * ��Ϊ�߼����ر�����ǰ���Ὣ�䴦������رպ�Źر�
		 * ����
		 */
		bos.close();
	}
}
