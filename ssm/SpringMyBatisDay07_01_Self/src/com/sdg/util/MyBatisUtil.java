package com.sdg.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MyBatisUtil {
	private static SqlSessionFactory ssf;
	
	static{
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		ssf=ssfb.build(MyBatisUtil.class.getClassLoader().getResourceAsStream("iBatis.xml"));
	}
	public static SqlSession getSession(){
		return ssf.openSession();
	}
}
