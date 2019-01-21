package util;

public class DAOFactory {
	public static Object getInstance(String type){
		Object obj=null;
		String className=ConfigUtil.getValue(type);
		try{
			//通过反射实例化对象即创建对象
			/*
			 * newInstance()调用className类的无参构造方法，
			 * 所以被newInstance()调用的类必须要有无参构造方法
			 * */
			obj=Class.forName(className).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		return obj;
	}
}
