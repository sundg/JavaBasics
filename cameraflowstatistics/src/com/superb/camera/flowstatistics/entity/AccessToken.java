package com.superb.camera.flowstatistics.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 海康accessToken
 * @author sundg
 *
 * 2018年10月9日下午12:22:53
 */
public class AccessToken implements Serializable {

	private static final long serialVersionUID = 930628658675735928L;

	private String accessToken;
	
	private long expireTime;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}

	
}
