package day03;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

/*
 * 高级流的功能可以叠加使用
 * 我们既可以方便的写出基本数据类型，又要写的效率高，
 * 那么我们可以联合DOS和BOS使用
 */
public class FilterOutputStreamDemo {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream("data.dat");
		/*
		 * 首先为了提高效率，包装为缓存流
		 */
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		/*
		 * 为了方便的写出基本数据类型，包装为DOS
		 */
		DataOutputStream dos=new DataOutputStream(bos);
		dos.writeInt(12345);
		dos.close();
	}
}
