package day03;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/*
 * DOS:���������Ķ��⹦���Ƿ���д��������������
 */
public class DataOutputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("dos.txt");
		DataOutputStream dos=new DataOutputStream(fos);
		int num=1234567;
		dos.writeInt(num);
		dos.writeLong(123L);
		dos.writeDouble(123.213);
		dos.writeUTF("��ð�");
		dos.close();
	}
}
