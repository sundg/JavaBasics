package day03;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

/*
 * �߼����Ĺ��ܿ��Ե���ʹ��
 * ���Ǽȿ��Է����д�������������ͣ���Ҫд��Ч�ʸߣ�
 * ��ô���ǿ�������DOS��BOSʹ��
 */
public class FilterOutputStreamDemo {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream("data.dat");
		/*
		 * ����Ϊ�����Ч�ʣ���װΪ������
		 */
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		/*
		 * Ϊ�˷����д�������������ͣ���װΪDOS
		 */
		DataOutputStream dos=new DataOutputStream(bos);
		dos.writeInt(12345);
		dos.close();
	}
}
