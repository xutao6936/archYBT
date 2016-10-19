package com.topcheer.ybt.restws.pojo;
/**
 * 核心扣款手机端入参
 * @author liuc
 *
 */
public class CorePayValReqPojo {
	private String account;//扣款帐号
	private String amount;//首期保费
	private String serialNo;//银保通流水号
	private String pwd;//客户密码（加密）
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "CorePayValPojo [account=" + account + ", amount=" + amount
				+ ", serialNo=" + serialNo + ", pwd=" + pwd + "]";
	}
	
}
