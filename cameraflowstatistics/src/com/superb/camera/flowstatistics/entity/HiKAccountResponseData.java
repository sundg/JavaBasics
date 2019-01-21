package com.superb.camera.flowstatistics.entity;



/**
 * 海康响应JSON子串的data对象
 * 
 * @author sundg
 */
public class HiKAccountResponseData {


  private int hourIndex;
  private int inFlow;
  private int outFlow;
	public int getHourIndex() {
		return hourIndex;
	}
	public void setHourIndex(int hourIndex) {
		this.hourIndex = hourIndex;
	}
	public int getInFlow() {
		return inFlow;
	}
	public void setInFlow(int inFlow) {
		this.inFlow = inFlow;
	}
	public int getOutFlow() {
		return outFlow;
	}
	public void setOutFlow(int outFlow) {
		this.outFlow = outFlow;
	}
	@Override
	public String toString() {
		return "HiKAccountResponseData [hourIndex=" + hourIndex + ", inFlow="
				+ inFlow + ", outFlow=" + outFlow + "]";
	}

  

  
}
