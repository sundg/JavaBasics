package day02.randomAccessFiledemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

//用于读写文件的类
public class RandomAccessFileDemo1 {
	public static void main(String[] args) {
		RandomAccessFile raf=null;
		try {
//			File file=new File("raf.dat");
			//之前创建过file对象，可以用此构造方法
//			raf=new RandomAccessFile(file,"rw");
			
			//之前没有创建过file对象，可以用此构造方法
			raf=new RandomAccessFile("raf.dat","rw");
			/*
			 * write(int d)
			 * 写入该int值得"低8位"
			 */
			//英文字母可以直接使用write方法写出，因为一个字节就可以描述
			raf.write('A');
			raf.write('B');
			//但是中文不行，因为中文要满2个字节
//			raf.write('中');
//			raf.seek(2);
//			System.out.println(raf.read());
			
			String str="大家好呀!";
			/*
			 * 要想写字符串，要先将字符串按照某个字符集转换为字节后再写出
			 */
			byte[] strData=str.getBytes("utf-8");
			System.out.println(strData.length);
//			for(byte b:strData){
//				raf.write(b);
//			}
			//写字符串之前，先写一个整数，记录该字符串占用了多少个字节，以便日后读取
			raf.writeInt(strData.length);
			/*
			 * write(byte[] b)
			 * 将给定的字节数组中所有的字节一次性写出
			 */
			raf.write(strData);
			//int最大值
			int max=Integer.MAX_VALUE;
			//如何写int值
			//位移符号">>>"
			raf.write(max>>>24);//写出int的高8位
			raf.write(max>>>16);
			raf.write(max>>>8);
			raf.write(max);
			/*
			 * writeInt(int d)
			 * 连续写4个字节，将给定的int值写出
			 */
			int min=Integer.MIN_VALUE;
			raf.writeInt(min);
			
			long l=123456l;
			raf.writeLong(l);
			raf.writeChar('中');
			double d=123.456;
			
			raf.writeDouble(d);
			float fl=123.123f;
			raf.writeFloat(fl);
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
