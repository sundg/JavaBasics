package day02.randomAccessFiledemo;

import java.io.IOException;
import java.io.RandomAccessFile;

//读取文件
public class RandomAccessFileDemo2 {
	//
	public static void main(String[] args) {
		RandomAccessFile raf=null;
		try {
			raf=new RandomAccessFile("raf.dat","r");
			/*
			 * int read()
			 * 从文件中读取一个字节，并以int值得形式返回
			 * 该int值只有低8位有效
			 * 若返回值为-1，则说明EOF
			 * end of file：文件读到末尾
			 */
			char a=(char) raf.read();
			System.out.println(a);
			char b=(char) raf.read();
			System.out.println(b);
			//读取"大家好呀!"，连续读取13个字节，先读取一个int值
			//已得知该字符串占用的字节量
			int len=raf.readInt();
			//根据字符串占用的字节量创建字节数组
			byte[] strData=new byte[len];
//			for(int i=0;i<len;i++){
//				strData[i]=(byte) raf.read();
//			}
			/*
			 * int read(byte[] b)
			 * 一次性尝试最多读取给定的字节数组的字节，并存入到给定的字节数组中，
			 * 返回为实际读取到的字节量
			 */
			raf.read(strData);
			String str=new String(strData,"utf-8");
			System.out.println(str);
			
			/*
			 * readInt()
			 * readLong()
			 * readChar()
			 * readDouble()
			 */
			int i=raf.readInt();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(raf!=null){
					raf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
