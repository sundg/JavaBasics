package day04;

import java.text.SimpleDateFormat;
import java.util.Date;

//˯������
public class SleepBlockDemo {
	public static void main(String[] args) {
		SleepBlock runnable=new SleepBlock();
		Thread t=new Thread(runnable);
		t.start();
		
	}
}
/*
 * ������һ��������ÿ�����һ��ϵͳʱ��
 * 
 * ���ܳ���"����"����
 * ���ƣ�
 * 	12:0:22
 *	12:0:23
 *	12:0:25
 *	12:0:26
 *	12:0:27
 */
class SleepBlock implements Runnable{

	
	public void run() {
		//���ϵͳʱ���ʱ����
		SimpleDateFormat sdf=new SimpleDateFormat("H:m:s");
		while(true){
			System.out.println(sdf.format(new Date()));
			/*
			 * ÿ�����һ��ϵͳʱ���ֹͣ1��
			 */
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
