package com.sdg.util;

//方案一的加载包:import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * 读取config.properties文件的数据
 * 并将其封装到Properties对象中
 */
public class ConfigUtil {
	static Properties p=new Properties();
	static{
		//获取文件流方案一:
		//FileInputStream instream = new FileInputStream(new File("文件路径"));
		//获取文件流方案二:
		//通过类加载器获取流
		ClassLoader loder=ConfigUtil.class.getClassLoader();
		//类加载器默认查找文件的路径是src
		InputStream inStream=loder.getResourceAsStream("config.properties");
		try {
			p.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//根据key获取Properties对象中的value值
	public static String getValue(String key){
		return p.getProperty(key);
	}
	
	//测试getValue方法:
	public static void main(String[] args) {
		System.out.println(getValue("name2"));
	}
}
