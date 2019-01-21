package day03;

import java.io.RandomAccessFile;

/*
 * 复制文件
 * 一个字节一个字节的读
 * */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws Exception {
		//读取源文件
		RandomAccessFile src=new RandomAccessFile("tomcat-6.0.35.rar","r");
		//用于写文件
		RandomAccessFile des=new RandomAccessFile("tomcatCopy.rar","rw");
		int d=-1;
		long start=System.currentTimeMillis();
		while((d=src.read())!=-1){
			des.write(d);
		}
		long end=System.currentTimeMillis();
		System.out.println("用时"+(end-start)+"毫秒");
		System.out.println("复制完毕");
		src.close();
		des.close();
	}
}
