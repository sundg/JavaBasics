package util;

public class DAOFactory {
	public static Object getInstance(String type){
		Object obj=null;
		String className=ConfigUtil.getValue(type);
		try{
			//ͨ������ʵ�������󼴴�������
			/*
			 * newInstance()����className����޲ι��췽����
			 * ���Ա�newInstance()���õ������Ҫ���޲ι��췽��
			 * */
			obj=Class.forName(className).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		return obj;
	}
}
