package dayo5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo1 {
	public static void main(String[] args) throws Exception {
		//1��������ʱ������
		final Timer timer=new Timer();
		//2���ƻ�����     ��������Ϊ2017��8��29��   10��08��00
		String str="2017-08-29 10:11:00";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=sdf.parse(str);
		//��Ӽƻ�����ʹ�������ڲ���ʵ�ֽӿ�
		timer.schedule(new TimerTask(){
			public void run() {
				System.out.println("����");
			}
			
		}, date);
	}
}
