package day01;
/**
 * java�е��쳣��Ϊ����쳣�ͷǼ���쳣
 * 	�Ǽ���쳣��RuntimeException��������
 * 		RuntimeException��Exception������
 * 		���������׳�(throw)��һ��RuntimeException����ȡ����ʱ��������
 * 		���ڱ���ʱ���������쳣�Ƿ񱻴���(����try catch��throws)
 * 	����쳣��
 * 		����RuntimeException��������
 * 		��Щ�쳣���ڳ����б��׳�������ʱ��������쳣�Ƿ��д�����룬û������벻ͨ��
 * 
 * RuntimeException�ĳ�������
 * 		1��NullPointerException
 * 		2��ArrayIndexOutOfBoundsException
 * 		3��StringIndexOutOfBoundsException
 * 		4��ClassCastException
 * 		5��NumberFormatException
 * 		....
 * @author Administrator
 *
 */
public class ExceptionDemo6 {
	public static void main(String[] args) {
		try {
			Object o="123";
			Integer i=(Integer)o;
			System.out.println(i);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}
	public static void test(int a){
		if(a>100){
			throw new RuntimeException("���ֳ���100");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
