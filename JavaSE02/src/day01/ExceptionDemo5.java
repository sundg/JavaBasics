package day01;
/*
 * throws�ؼ��֣�
 * 	�ùؼ�����������������ʱ��ͬ�����÷��������׳����쳣���࣬
 * 	��֪ͨʹ�����ڵ��ø÷���ʱӦ��������Щ�쳣
 * 
 * �׻�����˵��ǰ��
 * 
 * ʲôʱ����׳��쳣��ʲôʱ�򲶻��쳣
 * �ܽ᣺�������ι�ϵ
 */
public class ExceptionDemo5 {
	public static void main(String[] args) {
		try {
			test(1,0,2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * ��ʹ��a/b��֮���ٽ��̼���c����
	 */
	public static int test(int a,int b,int c) throws Exception{
		/*
		 * �����ǵ��õķ�����ƽ�׳��쳣�������ǵķ���������
		 * ����쳣ʱ�����ǿ��Բ�ȡ�ڵ�ǰ����������throws��
		 * ���÷������쳣�׸�������
		 */
		return divide(a,b)+c;
	}
	
	
	
	//��������
	/*
	 * ���������׳�һ���쳣ʱ���÷�����������Ӧ����дthrows���������쳣���׳�
	 */
	public static int divide(int a,int b) throws Exception{
		if(b==0){
			throw new Exception("��������Ϊ0");
		}
		return a/b;
	}
}
