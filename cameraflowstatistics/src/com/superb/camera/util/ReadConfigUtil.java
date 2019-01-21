package com.superb.camera.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;


public class ReadConfigUtil {

	private static HashMap<String,String> appMap;

	static {
		try {
			Properties properties = new Properties();
			
			properties.load(ReadConfigUtil.class.getResource("/config.properties").openStream());
			Enumeration<Object> enums = properties.keys();
			appMap = new HashMap<String,String>();
			while (enums.hasMoreElements()) {
				String key = (String) enums.nextElement();
				String name = properties.getProperty(key);
				appMap.put(key, name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	public static String getKeyValue(String key){	
		return (String) appMap.get(key);
	}
}
