package day02.randomAccessFiledemo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * 将控制台输入的内容写入文件
 */
public class RandomAccessFileDemo5 {
	public static void main(String[] args) throws Exception {
		/*
		 * 1、创建Scanner
		 * 2、创建RandonAccessFile用于将数据写入文件
		 * 3、设置循环
		 * 		3.1、从Scanner中读取一个字符串(控制台输入的内容)
		 * 		3.2、通过RandomAccessFile将文件写入
		 */
		Scanner sc=new Scanner(System.in);
		RandomAccessFile raf=new RandomAccessFile("aaa.txt","rw");
		/*
		 * 若一上来就将RandomAccessFile的游标一定到文件的末尾，则是追加内容
		 * 否则新写入的内容将覆盖前面的内容
		 */
		String str=null;
		try {
			while(true){
				System.out.println("请输入将要存入的内容：");
				str=sc.nextLine();
				if("exit".equals(str))
					break;
				raf.seek(raf.length());
				raf.writeUTF(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(raf!=null){
					raf.close();
					System.out.println("感谢使用，再见");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
