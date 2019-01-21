package com.sdg.util;

//����һ�ļ��ذ�:import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * ��ȡconfig.properties�ļ�������
 * �������װ��Properties������
 */
public class ConfigUtil {
	static Properties p=new Properties();
	static{
		//��ȡ�ļ�������һ:
		//FileInputStream instream = new FileInputStream(new File("�ļ�·��"));
		//��ȡ�ļ���������:
		//ͨ�����������ȡ��
		ClassLoader loder=ConfigUtil.class.getClassLoader();
		//�������Ĭ�ϲ����ļ���·����src
		InputStream inStream=loder.getResourceAsStream("config.properties");
		try {
			p.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//����key��ȡProperties�����е�valueֵ
	public static String getValue(String key){
		return p.getProperty(key);
	}
	
	//����getValue����:
	public static void main(String[] args) {
		System.out.println(getValue("name2"));
	}
}
