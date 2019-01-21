package day03;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/*
 * 缓存字节输出流
 */
public class BufferedOutputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("bos.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		String str="马上要过情人节了";
		byte[] data=str.getBytes("utf-8");
		bos.write(data);
		/*
		 * OutputStream中定义的一个方法
		 * void flush()
		 * 将缓存区的数据全部写出
		 */
		bos.flush();
		/*
		 * 当我们通过缓存字节流写出数据后，没有关闭流，
		 * 发现我们的数据并没有写入文件中，这时如果想
		 * 将缓存区的数据写入文件，要手动调用flush()
		 * 如果关闭流会自动调用flush()
		 * 
		 * 
		 * 在关闭流的时候，我们只需要关闭最外层的高级流即可，
		 * 因为高级流关闭自身前都会将其处理的流关闭后才关闭
		 * 自身
		 */
		bos.close();
	}
}
