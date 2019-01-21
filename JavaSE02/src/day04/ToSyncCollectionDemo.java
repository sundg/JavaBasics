package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * ��Map��Collectionת��Ϊ�̰߳�ȫ
 */
public class ToSyncCollectionDemo {
	public static void main(String[] args) {
		//ת������
			List<String> list=new ArrayList<String>();
			list.add("one");
			list.add("two");
			list.add("three");
			/*
			 * ��ArrayListת��Ϊһ���̰߳�ȫ�ļ���
			 * ԭ�����е�Ԫ����Ȼ����
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
			map.put("1", "һ");
			map.put("2", "��");
			map.put("3", "��");
			map=Collections.synchronizedMap(map);
			System.out.println(map);
	}
}
