package day04;

/*
 * ��̨�߳�
 */
public class DaemonThreadDemo {
	public static void main(String[] args) {
		/*
		 * ������ʦ��ǰ̨�߳�
		 */
		String str=new String();
		Thread boDuo = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("boDuo:let me jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("boDuo:��������������");
				System.out.println("��ͨ");
			}
		};
		/*
		 * ����ʦ����̨�߳�
		 */
		Thread zhou = new Thread() {
			public void run() {
				while (true) {
					System.out.println("zhou:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//���ú�̨�߳�:����Ҫ�ڸ��̱߳�����start()֮ǰ����
		zhou.setDaemon(true);
		boDuo.start();
		zhou.start();
	}
}
