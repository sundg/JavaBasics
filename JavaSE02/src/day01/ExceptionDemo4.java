package day01;

//�׳��쳣�ĵڶ������
public class ExceptionDemo4 {
	public static void main(String[] args) {
		String data="������Ϣ";
		connectDB("admin", "1231", data);
		System.out.println("ע��ɹ�");
	}

	public static void connectDB(String user, String pwd, String data) {
		if ("admin".equals(user) && "123".equals(pwd)) {
			System.out.println("��������" + data + "�ɹ�");
		} else {
			// ģ��ϵͳ�׳�һ���������ݿ�ʧ�ܵ��쳣
			throw new RuntimeException("���ݿ�����ʧ��");
		}
	}
}
