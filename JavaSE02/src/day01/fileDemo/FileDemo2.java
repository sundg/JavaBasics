package day01.fileDemo;

import java.io.File;

/*
 * 使用File对象创建目录
 */
public class FileDemo2 {
	public static void main(String[] args) {
		/*
		 * 在当前目录下(项目的根目录)创建一个demo
		 * ./demo    这里的"./"可以忽略，默认就是在当前目录
		 */
		File file=new File("demo");
		System.out.println("是否存在："+file.exists());
		if(!file.exists()){
			/*
			 * boolean mkdir()
			 * 创建当前File对象路径中所描述的目录
			 */
			file.mkdir();
		}
		System.out.println("是否存在："+file.exists());
	}
}
