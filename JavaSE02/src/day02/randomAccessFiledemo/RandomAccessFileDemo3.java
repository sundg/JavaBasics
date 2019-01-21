package day02.randomAccessFiledemo;

import java.io.RandomAccessFile;

/*
 * 支持读写基本数据类型
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf=new RandomAccessFile("raf2.dat", "rw");
		//返回游标当前的位置
		long position=raf.getFilePointer();
		System.out.println(position);//0
		/*
		 * 将一个int值转换为字节后写入文件
		 * 1、将int值转换为了4个字节
		 * 	    将数据转换为了对应的字节序列的过程称之为"序列化"
		 * 	    基本数据类型的序列化
		 * 2、将4个字节写入磁盘
		 *    将字节写入磁盘做长久保存的过程称之为"持久化"
		 */
		raf.writeInt(123);
		position=raf.getFilePointer();
		System.out.println(position);
		
		/*
		 * RandomAccessFile的读写操作时基于游标指向的当前位置进行的，
		 * 所以我们在写完数据后想从头读取数据，要将游标"滑动"到文件的起始位置
		 * 
		 * void seek(long pos)
		 * 将游标滑动到指定位置
		 */
		raf.seek(0);//将游标滑动到起始位置
		//将字节序列转换为对应的数据的过程称之为"反序列化"
		int i=raf.readInt();
		System.out.println(i);
		raf.close();
		
		
		
		
		
		
		
		
		
		
		
	}
}
