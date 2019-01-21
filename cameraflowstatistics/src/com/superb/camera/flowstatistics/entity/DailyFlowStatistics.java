package com.superb.camera.flowstatistics.entity;

public class DailyFlowStatistics {
	
	public String date;
	
	public String deviceSerial;
	
	public int inFlow;
	
	public int outFlow;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDeviceSerial() {
		return deviceSerial;
	}

	public void setDeviceSerial(String deviceSerial) {
		this.deviceSerial = deviceSerial;
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
	
	
	

}
