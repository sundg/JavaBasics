package day04;
/*
 * �̵߳����ȼ�
 */
public class ThreadPriorityDemo {
	public static void main(String[] args) {
		//������ȼ����߳�
		Thread max=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("max");
				}
			}
		};
		//������ȼ����߳�
		Thread min=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("min");
				}
			}
		};
		//Ĭ�����ȼ����߳�
		Thread norm=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("normal");
				}
			}
		};
		/*
		 * void setPriortity(int p)
		 * ���õ�ǰ�̵߳����ȼ�
		 * ��ߡ���͡�Ĭ�϶��г�����Ӧ
		 */
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		//�������ÿ���ʡ�ԣ�Ĭ������¾������ֵ
		norm.setPriority(Thread.NORM_PRIORITY);
		/*
		 * ���������ȼ�Ҳ����100%�����̵߳��ȣ�ֻ�����̶ȵĸ����̵߳�
		 * ���Ը���ļ��ʷ���ʱ��Ƭ�θ��߳����ȼ��ߵ��߳�
		 */
		min.start();
		norm.start();
		max.start();
	}
}
