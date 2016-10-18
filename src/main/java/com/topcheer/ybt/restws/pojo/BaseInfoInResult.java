package com.topcheer.ybt.restws.pojo;

/**
 * 
 * @author Administrator
 *
 */
public class BaseInfoInResult{

	private String serialNo; //银保通流水号
	private String resultCode;
	private String resultInfo;
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultInfo() {
		return resultInfo;
	}
	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}
	public BaseInfoInResult(String serialNo, String resultCode,
			String resultInfo) {
		super();
		this.serialNo = serialNo;
		this.resultCode = resultCode;
		this.resultInfo = resultInfo;
	}
	public BaseInfoInResult() {
		super();
	}

	
	
	

	
	
}
