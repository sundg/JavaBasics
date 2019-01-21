package dayo5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//��ʱ��
public class TimerDemo2 {
	public static void main(String[] args) {
		int min=1;
		//��ʾ��ʼʱ��
		long start=System.currentTimeMillis();
		//��ʾ����ʱ��
		final long end=start+min*1000*60;
		final Timer timer=new Timer();
		timer.schedule(new TimerTask(){
			public void run() {
				//��ʾʣ��ʱ��
				long show=end-System.currentTimeMillis();
				//��ʽһ��
				Date date=new Date(show);
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
				String dateStr=sdf.format(date);
				System.out.println(dateStr);
				//��ʽ����
//				long h=show/1000/60/60;
//				long m=show/1000/60%60;
//				long s=show/1000%60;
//				System.out.println(h+"ʱ"+m+"��"+s+"��");
			}
		}, 0,1000);
		//��ʱ������ʱ��ֹͣȫ���ļƻ�����
		timer.schedule(new TimerTask(){
			public void run() {
				timer.cancel();
			}
		}, new Date(end));
	}
}
