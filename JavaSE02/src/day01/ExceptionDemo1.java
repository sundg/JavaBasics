package day01;
//java�쳣������ƣ�������ֻ�ܽ��Exception�����ܽ��Error
public class ExceptionDemo1 {
	public static void main(String[] args)  throws Exception{
		System.out.println("����ʼ");
		try{
			String str=null;
			/*
			 * JVM�������ǵ�����һ��null�ķ�����
			 * JVM�ᴴ��һ����ָ���쳣��ʵ���������������﷢�����쳣��
			 * ��ǰ���׳��쳣���׳���JVM�������ǵĴ���Ƭ�Σ��鿴�Ƿ����쳣�������
			 * �����ֵ�ǰ������û���쳣������ƣ��򽫸��쳣ʵ���׳�����ǰ�������ڵķ���֮��
			 * ���쳣���׳���main����֮�⣬��ôJVM��ɱ����ǰ����
			 */
		String str1="a";
//		System.out.println(str.length());
		System.out.println(str1.length());
		System.out.println(str1.charAt(1));
		int i=Integer.parseInt(str1);
		/*
		 * ������Ĵ���Ƭ�γ������쳣��������try���飬
		 * ��ô��try������ʣ��Ĵ���Ƭ�β��ܱ�ִ��
		 */
		System.out.println("����Ϊִ��");
		}catch(NullPointerException e){
			e.printStackTrace();
			System.out.println("��ָ���쳣");
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println("�ַ����±�Խ���쳣");
		}catch(Exception e){
			/*
			 * �쳣������Ƶ�����ϰ�ߣ������һ������Exception���Ա�֤
			 * ���Բ�������г��ֵ��쳣��ʹ�ó��򲻻��������
			 */
			System.out.println("�������˴�");
		}
		System.out.println("�������");
	}
}
