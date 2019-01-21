package day04;

//�ж��쳣
public class InterruptedExceptionDemo {
	public static void main(String[] args) {
		/*
		 * С����ʦ �����ߣ�����˯���������߳�
		 * 
		 * ��һ�������еľֲ��ڲ�������Ҫ���ø÷����������ֲ���������ô�������������final���ε�
		 */
		final Thread xiaoZe = new Thread() {
			public void run() {
				System.out.println("С�󣺸���������˯����");
				try {
					/*
					 * ��һ���̴߳���˯������ʱ�����������̵߳���interrupt()�����жϣ�
					 * ��sleep()�������׳�InterruptedException�쳣
					 */
					Thread.sleep(1000000);
				} catch (InterruptedException e) {
					System.out.println("С�󣺸����أ������أ�����");
				}
			}
		};
		/*
		 * ����ʦ �����ߣ��ж�˯���������߳�
		 */
		Thread zhou = new Thread() {
			public void run() {
				System.out.println("�ܣ���ʼ��ǽ~~~");
				for (int i = 0; i < 5; i++) {
					System.out.println("�ܣ�ž��");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("žžž");
				System.out.println("�ܣ��㶨");
				xiaoZe.interrupt();//�ж�С���˯������
			}
		};
		xiaoZe.start();
		zhou.start();
	}
}
