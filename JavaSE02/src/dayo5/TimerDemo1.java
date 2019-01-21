package dayo5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo1 {
	public static void main(String[] args) throws Exception {
		//1、创建定时器对象
		final Timer timer=new Timer();
		//2、计划任务     设置日期为2017年8月29日   10：08：00
		String str="2017-08-29 10:11:00";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf.parse(str);
		//添加计划任务，使用匿名内部类实现接口
		timer.schedule(new TimerTask(){
			public void run() {
				System.out.println("起床了");
			}
			
		}, date);
	}
}
