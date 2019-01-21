package com.superb.camera.flowstatistics.entity;

import java.util.List;


/**
 * 海康响应JSON字串封装
 * 
 * @author sundg
 */
public class HiKAccountResponse extends HiKResponse {

  private static final long serialVersionUID = 984359021174598202L;

  private List<HiKAccountResponseData> data;


	public List<HiKAccountResponseData> getListData() {
		return data;
	}
	
	public void setListData(List<HiKAccountResponseData> listData) {
		this.data = listData;
	}

	@Override
	public String toString() {
		return "HiKAccountResponse [code=" + this.getCode() + ", msg=" + getMsg()
				+ ", listData=" + data + "]";
	}
	



  
}
