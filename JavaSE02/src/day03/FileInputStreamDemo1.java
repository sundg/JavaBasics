package day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 * 文件字节输入流
 */
public class FileInputStreamDemo1 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		try {
			/*
			 * FileInputStream(String fileName)
			 * FileInputStream(File file)
			 */
			fis=new FileInputStream("fos.dat");
//			fis=new FileInputStream(new File("fos.dat"));
			
			/*
			 * int read()
			 * 读取一个字节，并以int值得形式返回，"低8位"
			 * 若返回-1，说明EOF
			 */
			char a=(char) fis.read();
			System.out.println(a);
			/*
			 * int read(byte[] b)
			 * 一次性尝试读取给定的数组长度的字节量，并存入给定的数组中，
			 * 返回值为实际读取到的字节量
			 */
			byte[] array=new byte[100];
			int len=fis.read(array);
			System.out.println(len);
			System.out.println(Arrays.toString(array));
			/*
			 * String(byte[] b,int start,int len,String charSetName)
			 */
			String str=new String(array,0,len,"utf-8");
			System.out.println(str);
			/*
			 * int read(byte[] b,int start,int len)
			 * 从该流中最多读取len个字节并从给定字节数组的start处开始存入
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(fis!=null){
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
