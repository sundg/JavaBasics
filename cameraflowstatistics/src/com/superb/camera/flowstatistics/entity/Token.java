package com.superb.camera.flowstatistics.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 海康token结构
 * @author sundg
 *
 * 2018年10月9日下午12:26:23
 */
public class Token extends HiKResponse {

	private static final long serialVersionUID = -4998241819453848660L;

	private AccessToken data;

	

	public AccessToken getData() {
		return data;
	}



	public void setData(AccessToken data) {
		this.data = data;
	}



	@Override
	public String toString() {
		return "HiKAccountResponse [code=" + this.getCode() + ", msg=" + getMsg()
				+ ", listData=" + data + "]";
	}
	
}
