package com.topcheer.ybt.restws.pojo;

public class InsPrdPojo {

	private String insPrdCode="";
	private String insPrdName="";
	private String yieldRate="";
	private String startAmt="";
	private String hotType="";

	public InsPrdPojo(String insPrdCode, String insPrdName, String yieldRate, String startAmt, String hotType) {
		super();
		this.insPrdCode = insPrdCode;
		this.insPrdName = insPrdName;
		this.yieldRate = yieldRate;
		this.startAmt = startAmt;
		this.hotType = hotType;
	}
	
	

	public InsPrdPojo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getInsPrdCode() {
		return insPrdCode;
	}

	public void setInsPrdCode(String insPrdCode) {
		this.insPrdCode = insPrdCode;
	}

	public String getInsPrdName() {
		return insPrdName;
	}

	public void setInsPrdName(String insPrdName) {
		this.insPrdName = insPrdName;
	}

	public String getYieldRate() {
		return yieldRate;
	}

	public void setYieldRate(String yieldRate) {
		this.yieldRate = yieldRate;
	}

	public String getStartAmt() {
		return startAmt;
	}

	public void setStartAmt(String startAmt) {
		this.startAmt = startAmt;
	}

	public String getHotType() {
		return hotType;
	}

	public void setHotType(String hotType) {
		this.hotType = hotType;
	}

	@Override
	public String toString() {
		return "InsPrdPojo [insPrdCode=" + insPrdCode + ", insPrdName=" + insPrdName + ", yieldRate=" + yieldRate
				+ ", startAmt=" + startAmt + ", hotType=" + hotType + "]";
	}

}
