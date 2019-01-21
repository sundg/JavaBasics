package day03;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/*
 * DOS:该流带来的额外功能是方便写出基本类型数据
 */
public class DataOutputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("dos.txt");
		DataOutputStream dos=new DataOutputStream(fos);
		int num=1234567;
		dos.writeInt(num);
		dos.writeLong(123L);
		dos.writeDouble(123.213);
		dos.writeUTF("你好啊");
		dos.close();
	}
}
