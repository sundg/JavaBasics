package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	static Properties p=new Properties();
	static{
		//��ȡ�ļ�������һ
		//FileInputStream fis=new FileInputStream(new File("�ļ�·��"));
		
		//��ȡ�ļ���������
		//ͨ�����������ȡ��
		ClassLoader loader=ConfigUtil.class.getClassLoader();
		//�������Ĭ�ϲ����ļ���·����src
		InputStream inStream=loader.getResourceAsStream("config.properties");
		try{
			p.load(inStream);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//����key��ȡProperties�����е�valueֵ
	public static String getValue(String key){
		return p.getProperty(key);
	}
}
