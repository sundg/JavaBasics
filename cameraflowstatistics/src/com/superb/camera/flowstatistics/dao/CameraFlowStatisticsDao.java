package com.superb.camera.flowstatistics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import util.DbUtil;

import com.superb.camera.flowstatistics.entity.DailyFlowStatistics;
import com.superb.camera.flowstatistics.entity.HiKAccountResponse;
import com.superb.camera.flowstatistics.entity.HiKAccountResponseData;
import com.superb.camera.flowstatistics.entity.Token;
import com.superb.camera.util.GsonUtils;
import com.superb.camera.util.HttpClientUtil;
import com.superb.camera.util.ReadConfigUtil;

public class CameraFlowStatisticsDao {

	private static final Logger log = Logger.getLogger(CameraFlowStatisticsDao.class);
	
	/**
	 * 根据摄像头类型查询对应摄像头
	 * @return
	 */
	public List<String> findAllCamera(){
		String cameraType = ReadConfigUtil.getKeyValue("cameraType");
		String sql = "select t.camera_num from sys_eye_camera t where t.type in ("+cameraType+")";
		//Connection conn = DBUtil.getConnection();
		Connection conn = DbUtil.getConn();
		if(conn == null){
			log.error("CameraFlowStatisticsDao.findAllCamera()方法中数据库连接获取失败");
			return null;
		}
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				String deviceSerial = rs.getString(1);
				list.add(deviceSerial);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据设备序列号查询accountId
	 * @param deviceSerial
	 * @return
	 */
	public String findAccountIdByDeviceSerial(String deviceSerial){
		String sql = "select t.hik_account_id from sys_enterprise t where t.pk_id=(select c.enterprise_id from sys_eye_camera c where c.camera_num='"+deviceSerial+"')";
		//Connection conn = DBUtil.getConnection();
		Connection conn = DbUtil.getConn();
		if(conn == null){
			log.error("CameraFlowStatisticsDao.findAccountIdByDeviceSerial()方法中数据库连接获取失败");
			return null;
		}
		PreparedStatement pst = null;
		ResultSet rs = null;
		String accountId = "";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				accountId = rs.getString(1);
			}
		} catch (SQLException e) {
			log.error("查询失败", e);
		}
		return accountId;
	}
	
	
	/**
	 * 获取token
	 * @param appKey
	 * @param appSecret
	 * @return
	 */
	public String getAccessToken(String appKey,String appSecret){
		HttpClientUtil httpClient = new HttpClientUtil();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("appKey", ReadConfigUtil.getKeyValue("appKey"));
		map.put("appSecret", ReadConfigUtil.getKeyValue("appSecret"));
		
		String result = httpClient.doPost("https://open.ys7.com/api/lapp/token/get", map, "");
		Token hikResponse = GsonUtils.fromJson(result, Token.class);
		if(null != hikResponse && "200".equals(hikResponse.getCode())){
			log.debug("获取B账号token成功");
			return hikResponse.getData().getAccessToken();
		}else{
			log.error("获取B账号token失败");
			return null;
		}
	}
	
	/**
	 * 获取子账号token
	 * @param accessToken
	 * @param accountId
	 * @return
	 */
	public String getSonAccessToken(String accessToken,String accountId){
		HttpClientUtil httpClient = new HttpClientUtil();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("accessToken", accessToken);
		map.put("accountId", accountId);
		
		String result = httpClient.doPost("https://open.ys7.com/api/lapp/ram/token/get", map, "");
		Token hikResponse = GsonUtils.fromJson(result, Token.class);
		if(null != hikResponse && "200".equals(hikResponse.getCode())){
			log.debug("获取子账号token成功");
			return hikResponse.getData().getAccessToken();
		}else{
			log.error("获取子账号token失败");
			return null;
		}
	}
	
	/**
	 * 获取指定日期的客流数据
	 * @param accessToken 
	 * @param deviceSerial
	 * @param channelNo
	 * @param date 字符串形式的时间戳
	 * @return
	 */
	public List<HiKAccountResponseData> getPassengerflow(String accessToken,String deviceSerial,String channelNo,String date){
		HttpClientUtil httpClient = new HttpClientUtil();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("accessToken", accessToken);
		map.put("deviceSerial", deviceSerial);
		map.put("channelNo", channelNo);
		map.put("date", date);
		
		String result = httpClient.doPost("https://open.ys7.com/api/lapp/passengerflow/hourly", map, "");
		HiKAccountResponse hikResponse = GsonUtils.fromJson(result, HiKAccountResponse.class);
		if(null != hikResponse && "200".equals(hikResponse.getCode())){
			log.debug("获取"+date+"日客流数据成功");
			return hikResponse.getListData();
		}else{
			log.error("获取"+date+"日客流数据失败");
			return null;
		}
	}
	
	/**
	 * 批量插入数据
	 * @param willSave
	 * @return
	 */
	public String addBatch(List<DailyFlowStatistics> willSave){
		//Connection conn = DBUtil.getConnection();
		Connection conn = DbUtil.getConn();
		if(conn == null){
			log.error("CameraFlowStatisticsDao.addBatch()方法中数据库连接获取失败");
			return null;
		}
		PreparedStatement pst = null;
		try {
			//开启事务
			conn.setAutoCommit(false);
			pst = conn.prepareStatement("insert into camera_flow_statistics values(SEQ_CAMERA_FLOW_STATISTICS.NEXTVAL,?,?,?,?)");
			for(DailyFlowStatistics single:willSave){
				pst.setString(1, single.getDate());
				pst.setString(2, single.getDeviceSerial());
				pst.setInt(3, single.getInFlow());
				pst.setInt(4, single.getOutFlow());
				pst.addBatch();
			}
			
			pst.executeBatch();
			conn.commit();
			conn.close();
			
			log.info("数据保存成功");
		} catch (Exception e) {
			//保存失败进行事务回滚并重新保存
			try {
				conn.rollback();
				log.error("批量保存失败，正在进行重试", e);
				addBatch(willSave);
			} catch (Exception e1) {
				log.error("回滚失败", e1);
				return "failure";
			}
		}
		return "success";
	}
}
