package day03;

import java.io.FileOutputStream;

/*
 * 文件字节输出流
 */
public class FileOutputStreamDemo2 {
	public static void main(String[] args) throws Exception {
//		FileOutputStream fos=new FileOutputStream("fos.dat");
		//当重新写入内容，该文件原来的内容全部被废弃
//		fos.write('B');
//		fos.close();
		/*
		 * FileOutputStream(String fileName,boolean append)
		 * FileOutputStream(File file,boolean append)
		 * 在当前文件上追加写操作
		 */
		FileOutputStream fos=new FileOutputStream("fos.dat",true);
		fos.write('C');
		fos.close();
	}
}
