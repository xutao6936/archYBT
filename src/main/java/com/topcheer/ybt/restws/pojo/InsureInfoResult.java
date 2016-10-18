package com.topcheer.ybt.restws.pojo;

public class InsureInfoResult {

	private String insPrdCode;
	private String insPrdName;
	private String account;
	private String amount;
	private String serialNo;

	public InsureInfoResult(String insPrdCode, String insPrdName,
			String account, String amount, String serialNo) {
		super();
		this.insPrdCode = insPrdCode;
		this.insPrdName = insPrdName;
		this.account = account;
		this.amount = amount;
		this.serialNo = serialNo;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}


}
