package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 将Map和Collection转换为线程安全
 */
public class ToSyncCollectionDemo {
	public static void main(String[] args) {
		//转换集合
			List<String> list=new ArrayList<String>();
			list.add("one");
			list.add("two");
			list.add("three");
			/*
			 * 将ArrayList转换为一个线程安全的集合
			 * 原集合中的元素依然保留
			 */
			list=Collections.synchronizedList(list);
			System.out.println(list);
			Set<String> set=new HashSet<String>();
			set.add("one");
			set.add("two");
			set.add("three");
			set=Collections.synchronizedSet(set);
			System.out.println("set"+set);
			
			Map<String,String> map=new HashMap<String,String>();
			map.put("1", "一");
			map.put("2", "二");
			map.put("3", "三");
			map=Collections.synchronizedMap(map);
			System.out.println(map);
	}
}
