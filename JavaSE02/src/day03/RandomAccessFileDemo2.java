package day03;

import java.io.RandomAccessFile;
/*
 * 基于缓存来复制文件
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws Exception {
		//读取源文件
		RandomAccessFile src=new RandomAccessFile("tomcat-6.0.35.rar","r");
		//用于写文件
		RandomAccessFile des=new RandomAccessFile("tomcatCopy.rar","rw");
		//创建一个字节数组
		byte[] buffer=new byte[1024*20];
		//创建一个保存实际读取到的字节数
		int len=-1;
		long start=System.currentTimeMillis();
		while((len=src.read(buffer))>0){
			/*
			 * void write(byte[] b,int start,int len)
			 * 将给定的字符数组中从start处开始连续将len个字节写出
			 */
			des.write(buffer, 0, len);
		}
		long end=System.currentTimeMillis();
		System.out.println("用时"+(end-start)+"毫秒");
		System.out.println("复制完毕");
		src.close();
		des.close();
	}
}
