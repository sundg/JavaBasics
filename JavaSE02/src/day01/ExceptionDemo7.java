package day01;
/*
 * finally�ؼ���
 * 	finally���飺
 * 		�����������try�������һ��catch����֮��
 * 		ԭ��finally�������۳����Ƿ������Ȼִ�����ڲ����룬
 * 			  ͨ�����ǻ�ʹ��finally������Ϊ�������β����
 */
public class ExceptionDemo7 {
	public static void main(String[] args) {
		System.out.println(test(""));
	}
	
	public static int test(String str){
		try {
			if(str.length()>0){
				return str.length();
			}else{
				throw new RuntimeException();
			}
		} catch (Exception e) {
		}finally{
			System.out.println("���������");
		}
		return -1;
	}
}
