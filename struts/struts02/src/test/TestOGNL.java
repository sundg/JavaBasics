package test;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

import org.junit.Test;

import entity.Emp;
import entity.Foo;

public class TestOGNL {
	@Test
	public void test1() throws OgnlException{
		Foo f=new Foo();
		//ͨ��ognl���ʽ��name���Ը�ֵ
		Ognl.setValue("name", f, "zhangsan");
		//ͨ��ognl���ʽȡֵ
		//���ʻ�����������(����String)
		Object obj= Ognl.getValue("name", f);
		System.out.println(obj);
		obj=Ognl.getValue("age", f);
		System.out.println(obj);
		
		//��ȡ���顢����   ������[�±�]
		obj=Ognl.getValue("arrs[1]", f);
		System.out.println(obj);
		obj=Ognl.getValue("list[1]", f);
		System.out.println(obj);
		//��ȡmap��������     ������.key  ����    ������['key']
		obj=Ognl.getValue("map.two", f);
		System.out.println(obj);
		obj=Ognl.getValue("map['two']", f);
		System.out.println(obj);
		
		//��ȡ������������
		obj=Ognl.getValue("emp.username", f);
		System.out.println(obj);
		
		//�������
		obj=Ognl.getValue("age+10", f);
		obj=Ognl.getValue("name+10", f);
		obj=Ognl.getValue("age>20", f);
		System.out.println(obj);
		
		//���÷���
		obj=Ognl.getValue("name.toUpperCase()", f);
		obj=Ognl.getValue("list.size()", f);
		System.out.println(obj);
		
		//���þ�̬����
		obj=Ognl.getValue("@java.util.Arrays@toString(arrs)", f);
		System.out.println(obj);
		
		//��������
		obj=Ognl.getValue("{1,'two',3}", null);
		System.out.println(obj.getClass().getName());
		System.out.println(obj);
		
		obj=Ognl.getValue("#{'one':1,'two':2}", null);
		System.out.println(obj.getClass().getName());
		System.out.println(obj);
	}
	@Test
	public void test02() throws OgnlException{
		//map�� ���һЩ��������Դ
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("username", "rose");
		Emp emp =new Emp();
		//root��  �����ҵ����صĶ���
		emp.setUsername("jack");
		Object obj=Ognl.getValue("#username", map,emp);
		System.out.println(obj);
	}
}
