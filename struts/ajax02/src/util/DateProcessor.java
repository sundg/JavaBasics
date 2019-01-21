package util;

import java.text.SimpleDateFormat;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateProcessor implements JsonValueProcessor {
	//�������
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(arg0);
	}
	//��������
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(arg1);
	}

}
