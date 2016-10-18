package com.topcheer.ybt.restws.pojo;

/**
 * 
 * @author Administrator
 *
 */
public class BaseInfoInPojo {

	private String insCorpCode; //保险公司编号
	private String bankCode; //开户卡所属支行
	private String insPrdCode;//保险产品编码
	private String channelType;//渠道标志
	
	
	
	public BaseInfoInPojo() {
		super();
	}
	public BaseInfoInPojo(String insCorpCode, String bankCode,
			String insPrdCode, String channelType) {
		super();
		this.insCorpCode = insCorpCode;
		this.bankCode = bankCode;
		this.insPrdCode = insPrdCode;
		this.channelType = channelType;
	}
	public String getInsCorpCode() {
		return insCorpCode;
	}
	public void setInsCorpCode(String insCorpCode) {
		this.insCorpCode = insCorpCode;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getInsPrdCode() {
		return insPrdCode;
	}
	public void setInsPrdCode(String insPrdCode) {
		this.insPrdCode = insPrdCode;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	@Override
	public String toString() {
		return "BaseInfoInPojo [insCorpCode=" + insCorpCode + ", bankCode="
				+ bankCode + ", insPrdCode=" + insPrdCode + ", channelType="
				+ channelType + "]";
	}
	
	
}
