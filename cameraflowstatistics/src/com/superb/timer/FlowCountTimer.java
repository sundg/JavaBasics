package com.superb.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.superb.camera.flowstatistics.service.CameraFlowStatisticsService;
import com.superb.camera.util.ReadConfigUtil;

public class FlowCountTimer {
	private static final Logger log = Logger.getLogger(FlowCountTimer.class);
	public void CountTimer() throws Exception {
		final String  appKey=ReadConfigUtil.getKeyValue("appKey");
		final String appSecret=ReadConfigUtil.getKeyValue("appSecret");
		final String channelNo=ReadConfigUtil.getKeyValue("channelNo");
		//final String date=(new SimpleDateFormat("yyyy-MM-dd")).format(new Date()); 
		// 时间类
		Calendar startDate = Calendar.getInstance();
		// 设置开始执行的时间为 某年-某月-某月 00:00:00
		startDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.get(Calendar.DATE), 23, 59,
				0);
		final CameraFlowStatisticsService service =new CameraFlowStatisticsService();
		// 1小时的毫秒设定
		//long timeInterval = 1 * 1000 *60*60;
		 long timeInterval = 24*60* 60 * 1000;
		// 定时器实例
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				String date=(new SimpleDateFormat("yyyy-MM-dd")).format(new Date()); 
				// 定时器主要执行的代码块
				log.info("timer start  @"+new Date());
				service.save(appKey, appSecret, channelNo, date);
				log.info("timer end  @"+new Date());
			}
			// 设定的定时器在15:10分开始执行,每隔 1小时执行一次.
		}, startDate.getTime(), timeInterval); // timeInterval 是一天的毫秒数，也是执行间隔

	};
}
