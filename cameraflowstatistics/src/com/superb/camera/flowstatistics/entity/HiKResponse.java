package com.superb.camera.flowstatistics.entity;

import java.io.Serializable;

/**
 * 海康响应JSON字串封装
 * 
 * @author caiz
 */
public class HiKResponse implements Serializable {

  private static final long serialVersionUID = 984359021174598202L;

  private String code;
  private String msg;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
