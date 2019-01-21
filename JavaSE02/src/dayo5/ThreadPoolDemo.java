package dayo5;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//�̳߳�
public class ThreadPoolDemo {
	public static void main(String[] args) {
		//�����̳߳ض��������̳߳�����Ϊ2
		Executor threadPool=Executors.newFixedThreadPool(2);
		
		Process p1=new Process();
		Process p2=new Process();
		Process p3=new Process();
		
		threadPool.execute(p1);//��p1�ύ���̳߳�ִ��
		threadPool.execute(p2);
		threadPool.execute(p3);
		
	}
}

class Process implements Runnable{
	static int index=1;
	int id;
	public Process(){
		id=index++;
	}

	public void run() {
		System.out.println(id+"��ʼ...");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(id+"������");
	}
	
}
