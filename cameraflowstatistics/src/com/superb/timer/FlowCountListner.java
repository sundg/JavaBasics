package com.superb.timer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class FlowCountListner implements ServletContextListener{
	private static final Logger log = Logger.getLogger(FlowCountTimer.class);
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//web项目启动时执行
		log.info("project start");
		FlowCountTimer timer = new FlowCountTimer();
		try {
			timer.CountTimer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("project Destroyed");
		// TODO Auto-generated method stub
		
	}
}
