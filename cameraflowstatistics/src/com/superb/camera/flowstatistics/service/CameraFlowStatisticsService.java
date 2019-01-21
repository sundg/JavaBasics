package com.superb.camera.flowstatistics.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.superb.camera.flowstatistics.dao.CameraFlowStatisticsDao;
import com.superb.camera.flowstatistics.entity.DailyFlowStatistics;
import com.superb.camera.flowstatistics.entity.HiKAccountResponseData;


public class CameraFlowStatisticsService {
	
	private static final Logger log = Logger.getLogger(CameraFlowStatisticsService.class);
	
	public CameraFlowStatisticsDao cameraFlowStatisticsDao;
	
	/**
	 * 查询所有商铺宝摄像头
	 * @return
	 */
	public List<String> findAllShopCameras(){
		cameraFlowStatisticsDao = new CameraFlowStatisticsDao();
		return cameraFlowStatisticsDao.findAllCamera();
	}
	
	/**
	 * 根据摄像头序列号查询对应的accountId
	 * @param deviceSerial
	 * @return
	 */
	public String findAccountIdByCamera(String deviceSerial){
		cameraFlowStatisticsDao = new CameraFlowStatisticsDao();
		return cameraFlowStatisticsDao.findAccountIdByDeviceSerial(deviceSerial);
	}
	
	/**
	 * 根据key与secret获取accessToken
	 * @param appKey
	 * @param appSecret
	 * @return
	 */
	public String getAccessToken(String appKey,String appSecret){
		cameraFlowStatisticsDao = new CameraFlowStatisticsDao();
		return cameraFlowStatisticsDao.getAccessToken(appKey, appSecret);
	}
	
	/**
	 * 获取子账户accessToken
	 * @param accountId
	 * @return
	 */
    public String getSonAccessToken(String deviceSerial,String appKey,String appSecret) {
    	cameraFlowStatisticsDao = new CameraFlowStatisticsDao();
    	String accountId = findAccountIdByCamera(deviceSerial);
    	String accessToken = getAccessToken(appKey,appSecret);
    	return cameraFlowStatisticsDao.getSonAccessToken(accessToken, accountId);
    }
    
    /**
     * 统计单日客流量并存入数据库
     * @param deviceSerial
     * @param accessToken
     * @param channelNo
     * @param date
     */
    public void save(String appKey,String appSecret,String channelNo,String date){
    	log.info(date + "开始进入统计单日客流量并存入数据库方法");
    	log.info(date + "传入的参数为：appKey="+appKey+"  appSecret="+appSecret+"  channelNo="+channelNo+"  date="+date);
    	cameraFlowStatisticsDao = new CameraFlowStatisticsDao();
    	List<String> devices = findAllShopCameras();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String dateStr = "";
    	try {
			 dateStr = sdf.parse(date).getTime()+"";
		} catch (ParseException e) {
			log.error("日期格式转换出错", e);
		}
    	
    	List<DailyFlowStatistics> willSave = new ArrayList<DailyFlowStatistics>();
    	
    	if(devices != null && devices.size() > 0){
    		for(String deviceSerial:devices){
    			String sonAccessToken = getSonAccessToken(deviceSerial,appKey,appSecret);
    			if(sonAccessToken == null){
    				log.error("获取子账户accessToken失败，对应的参数为deviceSerial="+deviceSerial+"  appKey="+appKey+"  appSecret="+appSecret);
    				return;
    			}
    			//查询数据
    	    	List<HiKAccountResponseData> list = cameraFlowStatisticsDao.getPassengerflow(sonAccessToken, deviceSerial, channelNo, dateStr);
    	    	if(list != null && list.size()>0){
    	    		int inFlow = 0;
    	    		int outFlow = 0;
    	    		DailyFlowStatistics dailyFlowStatistics = null;
    	    		for(HiKAccountResponseData singleData:list){
    	    			dailyFlowStatistics = new DailyFlowStatistics();
    	    			inFlow += singleData.getInFlow();
    	    			outFlow += singleData.getOutFlow();
    	    		}
    	    		dailyFlowStatistics.setDate(date);
    	    		dailyFlowStatistics.setDeviceSerial(deviceSerial);
    	    		dailyFlowStatistics.setInFlow(inFlow);
    	    		dailyFlowStatistics.setOutFlow(outFlow);
    	    		willSave.add(dailyFlowStatistics);
    	    	}else{
    	    		log.info(date + " " + deviceSerial + "摄像头无客流数据");
    	    	}
    		}
    	}else{
    		log.info(date + "未找到商铺宝摄像头");
    	}
    	
    	//保存数据
    	if(willSave != null && willSave.size() > 0){
    		String result = cameraFlowStatisticsDao.addBatch(willSave);
    		if("success".equals(result)){
    			log.info(date + "日数据保存成功");
    		}else{
    			log.info(date + "日数据保存失败");
    		}
    	}else{
    		log.info(date + " " + "摄像头均无客流数据");
    	}
    	
    	log.info(date + "统计单日客流量并存入数据库方法结束");
    	
    }
}
