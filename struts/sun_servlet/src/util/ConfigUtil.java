package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	static Properties p=new Properties();
	static{
		//获取文件流方案一
		//FileInputStream fis=new FileInputStream(new File("文件路径"));
		
		//获取文件流方案二
		//通过类加载器获取流
		ClassLoader loader=ConfigUtil.class.getClassLoader();
		//类加载器默认查找文件的路径是src
		InputStream inStream=loader.getResourceAsStream("config.properties");
		try{
			p.load(inStream);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//根据key获取Properties对象中的value值
	public static String getValue(String key){
		return p.getProperty(key);
	}
}
