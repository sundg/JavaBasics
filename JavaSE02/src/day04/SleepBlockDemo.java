package day04;

import java.text.SimpleDateFormat;
import java.util.Date;

//睡眠阻塞
public class SleepBlockDemo {
	public static void main(String[] args) {
		SleepBlock runnable=new SleepBlock();
		Thread t=new Thread(runnable);
		t.start();
		
	}
}
/*
 * 当阻塞一秒来控制每秒输出一次系统时间
 * 
 * 可能出现"跳秒"现象
 * 类似：
 * 	12:0:22
 *	12:0:23
 *	12:0:25
 *	12:0:26
 *	12:0:27
 */
class SleepBlock implements Runnable{

	
	public void run() {
		//输出系统时间的时分秒
		SimpleDateFormat sdf=new SimpleDateFormat("H:m:s");
		while(true){
			System.out.println(sdf.format(new Date()));
			/*
			 * 每当输出一次系统时间后停止1秒
			 */
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
