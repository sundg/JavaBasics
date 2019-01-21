package day01.fileDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * java.io.File
 * File类的每一个实例是用于描述一个文件或目录的信息
 */
public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		//绝对路径不可取，不易于程序的跨平台
		//File file=new File("D:\\Program Files\\Workspaces\\MyEclipse 8.6\\JavaSE02\\test.txt");
		
		/*
		 * 使用相对路径
		 * "."表示当前目录，这里的当前目录指的是当前程序所在的项目的根目录
		 * 
		 * File的常量separator:表示目录的层级分隔符
		 * 		在Windows操作系统下，该常量的值为字符串"\"
		 * 		在Linux操作系统下，该常量的值为字符串"/"
		 */
		File file=new File("."+File.separator+"test.txt");
		
		/*
		 * String getName()   
		 * 获取文件或目录的名字
		 */
		System.out.println(file.getName());
		
		/*
		 * long length()
		 * 当前文件的大小(字节量)
		 */
		long length=file.length();
		System.out.println("文件的大小："+length);
		
		/*
		 * long lastModifiled()
		 * 获取当前文件最后修改的时间
		 * long为1970年元旦到修改那一刻的毫秒值
		 */
		long lastModifiled=file.lastModified();
		System.out.println(lastModifiled);
		
		/*
		 * 2017年8月24日14：30：00
		 */
		Date date=new Date();
		System.out.println("date"+date);
		date.setTime(lastModifiled);
		SimpleDateFormat sdf=new SimpleDateFormat("y-M-d H:m:s");
		String lastDate=sdf.format(date);
		System.out.println(lastDate);
		
		/*
		 * String getPath()
		 * 获取当前文件或目录的路径(相对路径)
		 */
		System.out.println("path:"+file.getPath());
		/*
		 * String getAbsolutePath()
		 * 获取绝对路径
		 */
		System.out.println("path:"+file.getAbsolutePath());
		
		/*
		 * String getCanonicalPath()
		 * 获取系统标准的绝对路径，该方法要求捕获异常
		 */
		System.out.println("canonical:"+file.getCanonicalPath());
		
		/*
		 * boolean exists()
		 * 查看当前File对象描述的文件是否真实存在
		 */
		if(file.exists()){
			System.out.println("存在");
		}else{
			System.out.println("不存在");
		}
		
		/*
		 * boolean isFile()
		 * 查看当前file对象描述的是否为一个文件
		 */
		if(file.isFile()){
			System.out.println("是一个文件");
		}else{
			System.out.println("不是一个文件");
		}
		
		/*
		 * boolean isDirectory()
		 * 查看当前对象描述的是否为一个目录
		 */
		if(file.isDirectory()){
			System.out.println("是一个目录");
		}else{
			System.out.println("不是一个目录");
		}
		
		/*
		 * boolean canRead()
		 * 是否可读
		 */
		if(file.canRead()){
			System.out.println("可读");
		}else{
			System.out.println("不可读");
		}
		/*
		 * boolean canWrite()
		 * 是否可写
		 */
		if(file.canWrite()){
			System.out.println("可写");
		}else{
			System.out.println("不可写");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
