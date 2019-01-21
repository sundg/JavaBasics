package com.sdg.util;

//if的加载包:import dao.EmpDAOImpl;

/**
 *生成产品:-->对象
 *返回EmpDAO接口要求的对象
 */
public class DAOFactory {
	public static Object getInstance(String type){
		Object obj=null;
		//获取接口对应的实现类
		//dao.EmpDAOImpl
		String className=ConfigUtil.getValue(type);
		try {
			obj=Class.forName(className).newInstance();//通过反射实例化对象即创建对象
			                                          /*newInstance()调用className类的无参构造方法,
			                                           *所以被newInstance()调用的类必须要有无参构造方法*/
		} catch (Exception e) {
			e.printStackTrace();
		}
//		if("EmpDAO".equals(type)){
//			obj=new EmpDAOImpl();
//		}
		return obj;
	}
}
