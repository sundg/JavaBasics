package day04;
/*
 * ��һ�ִ����̵߳ķ�ʽ���̳�Thread��
 */
public class ThreadDemo1  {
	public static void main(String[] args) {
		Thread t1=new Person1();
		Thread t2=new Person3();
		//�����߳�Ҫ����start()������������run()����
		t1.start();
		t2.start();
		/*
		 * ʹ�ö��̲߳�Ӧ���ٿ���ִ�е��Ⱥ�˳��
		 * 
		 * ִ�����Ⱥ�˳�����ͬ������
		 * ִ��û���Ⱥ�˳������첽����(��������)
		 */
	}
}
//��һ�ִ����̵߳ķ�ʽ����һ���׶ˣ�
//�߳����߳�֮��Ҫ�ɵ����������һ��
class Person1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("����˭��");
		}
	}
}
class Person3 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("�����յ�ѵ�");
		}
	}
}
