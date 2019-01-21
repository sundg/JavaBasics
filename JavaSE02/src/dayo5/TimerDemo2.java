package dayo5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//计时器
public class TimerDemo2 {
	public static void main(String[] args) {
		int min=1;
		//表示开始时间
		long start=System.currentTimeMillis();
		//表示结束时间
		final long end=start+min*1000*60;
		final Timer timer=new Timer();
		timer.schedule(new TimerTask(){
			public void run() {
				//表示剩余时间
				long show=end-System.currentTimeMillis();
				//方式一：
				Date date=new Date(show);
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
				String dateStr=sdf.format(date);
				System.out.println(dateStr);
				//方式二：
//				long h=show/1000/60/60;
//				long m=show/1000/60%60;
//				long s=show/1000%60;
//				System.out.println(h+"时"+m+"分"+s+"秒");
			}
		}, 0,1000);
		//计时结束的时候，停止全部的计划任务
		timer.schedule(new TimerTask(){
			public void run() {
				timer.cancel();
			}
		}, new Date(end));
	}
}
