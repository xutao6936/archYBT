package com.topcheer.ybt.restws.pojo;

/**
 * 保单查询类
 * @author liuc
 *
 */
public class PolicyInquiryPojo {
	private String insCorpCode;//保险公司编号
	private String insCorpCHname;//保险公司中文名称
	private String channelType;//销售渠道
	private String contractId;//保单号
	private String serialNo;//银保通流水号
	private String amount;//首期付款金额
	private String updateDate;//销售日期
	private String insPrdCHname;//产品名称
	
	public PolicyInquiryPojo(String insCorpCode, String insCorpCHname,
			String channelType, String contractId, String serialNo,
			String amount, String updateDate, String insPrdCHname) {
		super();
		this.insCorpCode = insCorpCode;
		this.insCorpCHname = insCorpCHname;
		this.channelType = channelType;
		this.contractId = contractId;
		this.serialNo = serialNo;
		this.amount = amount;
		this.updateDate = updateDate;
		this.insPrdCHname = insPrdCHname;
	}
	
	public String getInsCorpCode() {
		return insCorpCode;
	}
	public void setInsCorpCode(String insCorpCode) {
		this.insCorpCode = insCorpCode;
	}
	public String getInsCorpCHname() {
		return insCorpCHname;
	}
	public void setInsCorpCHname(String insCorpCHname) {
		this.insCorpCHname = insCorpCHname;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getInsPrdCHname() {
		return insPrdCHname;
	}
	public void setInsPrdCHname(String insPrdCHname) {
		this.insPrdCHname = insPrdCHname;
	}
}
