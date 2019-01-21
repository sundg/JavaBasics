package dayo5;
//ʹ��wait()��notify()�������Эͬ����
public class WaitAndNotifyDemo {
		//��ʾͼƬ�Ƿ��������
		public static boolean isFinish=false;
		
		public static Object object=new Object();
		public static void main(String[] args) {
			//����ͼƬ�߳�
			final Thread download=new Thread(){
				public void run(){
					System.out.println("download:��ʼ����ͼƬ");
					for(int i=0;i<=100;i++){
						System.out.println("download:�����"+i+"%");
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("ͼƬ�������");
					isFinish=true;//��ʾͼƬ�������
					synchronized(object){
						//֪ͨobject���ϵĵȴ����߳̽������
						object.notify();
					}
					System.out.println("download:��ʼ���ظ���");
					for(int i=0;i<=100;i++){
						System.out.println("download:�����"+i+"%");
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("�����������");
				}
			};
			//��ʾͼƬ���߳�
			Thread showImage=new Thread(){
				public void run(){
					System.out.println("show:׼����ʾͼƬ");
					//�ȴ������̹߳�����������ִ������Ĵ���
					try {
						/*
						 * wait()��������������������±����
						 * 1����download�߳̽���
						 * 2����������download��notify()
						 */
						synchronized(object){
							object.wait();
						}
						download.join();//��ִ��download
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(!isFinish){
						throw new RuntimeException("download:ͼƬδ�������");
					}
					System.out.println("show:ͼƬ�Ѿ���ʾ��");
				}
			};
			download.start();
			showImage.start();
	}
}
