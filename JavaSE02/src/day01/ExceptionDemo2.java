package day01;
/**
 * finally��Զ�ᱻִ��
 * NullPointerException��StringIndexOutOfBoundsException������RuntimeException
 * 
 * catch�쳣��˳���쳣��С���󣬷������ֱ������
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println(test(null)+","+test("0")+","+test(""));
	}
	public static int test(String str) {
		try{
			return str.charAt(0)-'0';
		}catch(NullPointerException e){
			e.printStackTrace();
			return 1; 
		}catch(RuntimeException e){
			e.printStackTrace();
			return 2;
		}catch(Exception e){
			return 3;
		}
		finally{
			/*
			 * finally�в�����(��Ӧ��)��дreturn���
			 */
			return 4;
		}
	}
}
