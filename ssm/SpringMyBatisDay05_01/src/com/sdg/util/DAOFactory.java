package com.sdg.util;

//if�ļ��ذ�:import dao.EmpDAOImpl;

/**
 *���ɲ�Ʒ:-->����
 *����EmpDAO�ӿ�Ҫ��Ķ���
 */
public class DAOFactory {
	public static Object getInstance(String type){
		Object obj=null;
		//��ȡ�ӿڶ�Ӧ��ʵ����
		//dao.EmpDAOImpl
		String className=ConfigUtil.getValue(type);
		try {
			obj=Class.forName(className).newInstance();//ͨ������ʵ�������󼴴�������
			                                          /*newInstance()����className����޲ι��췽��,
			                                           *���Ա�newInstance()���õ������Ҫ���޲ι��췽��*/
		} catch (Exception e) {
			e.printStackTrace();
		}
//		if("EmpDAO".equals(type)){
//			obj=new EmpDAOImpl();
//		}
		return obj;
	}
}
