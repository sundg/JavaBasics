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
		//通过ognl表达式给name属性赋值
		Ognl.setValue("name", f, "zhangsan");
		//通过ognl表达式取值
		//访问基本类型数据(包括String)
		Object obj= Ognl.getValue("name", f);
		System.out.println(obj);
		obj=Ognl.getValue("age", f);
		System.out.println(obj);
		
		//获取数组、集合   属性名[下标]
		obj=Ognl.getValue("arrs[1]", f);
		System.out.println(obj);
		obj=Ognl.getValue("list[1]", f);
		System.out.println(obj);
		//获取map类型数据     属性名.key  或者    属性名['key']
		obj=Ognl.getValue("map.two", f);
		System.out.println(obj);
		obj=Ognl.getValue("map['two']", f);
		System.out.println(obj);
		
		//获取引用类型数据
		obj=Ognl.getValue("emp.username", f);
		System.out.println(obj);
		
		//常规计算
		obj=Ognl.getValue("age+10", f);
		obj=Ognl.getValue("name+10", f);
		obj=Ognl.getValue("age>20", f);
		System.out.println(obj);
		
		//调用方法
		obj=Ognl.getValue("name.toUpperCase()", f);
		obj=Ognl.getValue("list.size()", f);
		System.out.println(obj);
		
		//调用静态方法
		obj=Ognl.getValue("@java.util.Arrays@toString(arrs)", f);
		System.out.println(obj);
		
		//创建对象
		obj=Ognl.getValue("{1,'two',3}", null);
		System.out.println(obj.getClass().getName());
		System.out.println(obj);
		
		obj=Ognl.getValue("#{'one':1,'two':2}", null);
		System.out.println(obj.getClass().getName());
		System.out.println(obj);
	}
	@Test
	public void test02() throws OgnlException{
		//map区 存放一些公共的资源
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("username", "rose");
		Emp emp =new Emp();
		//root区  存放与业务相关的对象
		emp.setUsername("jack");
		Object obj=Ognl.getValue("#username", map,emp);
		System.out.println(obj);
	}
}
