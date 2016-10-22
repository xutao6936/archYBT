package com.topcheer.ybt.restws.pojo;

/**
 * 当日撤单返回手机端信息
 * @author liuc
 *
 */
public class CancleBusinessRespPojo {
	private String resultCode   ;// 结果编码(000000为成功)
	private String resultInfo   ;// 结果信息
	private String insCorpCode  ;// 保险公司编号
	private String insCorpCHname;// 保险公司中文名称
	private String channelType  ;// 销售渠道
	private String contractId   ;// 保单号
	private String serialNo     ;// 银保通流水号
	private String amount       ;// 首期付款金额
	private String updateDate   ;// 销售日期
	private String insPrdCHname ;// 产品名称
	
	
	public CancleBusinessRespPojo() {
		super();
	}
	
	
	public CancleBusinessRespPojo(String resultCode, String resultInfo,
			String insCorpCode, String insCorpCHname, String channelType,
			String contractId, String serialNo, String amount,
			String updateDate, String insPrdCHname) {
		super();
		this.resultCode = resultCode;
		this.resultInfo = resultInfo;
		this.insCorpCode = insCorpCode;
		this.insCorpCHname = insCorpCHname;
		this.channelType = channelType;
		this.contractId = contractId;
		this.serialNo = serialNo;
		this.amount = amount;
		this.updateDate = updateDate;
		this.insPrdCHname = insPrdCHname;
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


	@Override
	public String toString() {
		return "CancleBusinessRespPojo [resultCode=" + resultCode
				+ ", resultInfo=" + resultInfo + ", insCorpCode=" + insCorpCode
				+ ", insCorpCHname=" + insCorpCHname + ", channelType="
				+ channelType + ", contractId=" + contractId + ", serialNo="
				+ serialNo + ", amount=" + amount + ", updateDate="
				+ updateDate + ", insPrdCHname=" + insPrdCHname + "]";
	}
	
	
}
