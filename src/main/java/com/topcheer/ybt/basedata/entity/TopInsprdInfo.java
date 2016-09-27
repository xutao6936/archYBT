package com.topcheer.ybt.basedata.entity;

public class TopInsprdInfo {

	private String id;

	private String insPrdCode;//产品代码
	
	private String insPrdTrueCode;//产品真实代码
	
	private String insCorpCode;//公司编码
	
	private String insPrdCnName;//产品名称
	
	private String insPrdSimName;//产品简称
	
	private String assuranceType;//主附险标志(0:主险 1:附加险)
	
	private String buyUnit;//购买单位(0:份数 1:保费 2:保额)
	
	private String  insPrdType; //产品类型
	
	private String insBeginDate; //代理开始日期
	
	private String insEndDate;//代理结束日期
	
	private String startAMT;//起购金额/数量
	
	private String entAMT;//最高金额/数量
	
	private String inCreaseAMT;//递增金额/数量
	
	private String status;//状态(0:有效 1:无效)
	
	private String impawnFlag;//是否可质押(0:是 1:否)
	
	private String transType;//交易类型(0:全部1:实时2:非实时)
	
	private String channelType;//交易渠道(01:柜面02:网银03:手机04:直销05:自助)
	
	private String createDate;//创建日期
	
	private String updateDate;//更新日期
	
	private String updateTime;//更新时间
	
	private String operator;//操作员

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInsPrdCode() {
		return insPrdCode;
	}

	public void setInsPrdCode(String insPrdCode) {
		this.insPrdCode = insPrdCode;
	}

	public String getInsPrdTrueCode() {
		return insPrdTrueCode;
	}

	public void setInsPrdTrueCode(String insPrdTrueCode) {
		this.insPrdTrueCode = insPrdTrueCode;
	}

	public String getInsCorpCode() {
		return insCorpCode;
	}

	public void setInsCorpCode(String insCorpCode) {
		this.insCorpCode = insCorpCode;
	}

	public String getInsPrdCnName() {
		return insPrdCnName;
	}

	public void setInsPrdCnName(String insPrdCnName) {
		this.insPrdCnName = insPrdCnName;
	}

	public String getInsPrdSimName() {
		return insPrdSimName;
	}

	public void setInsPrdSimName(String insPrdSimName) {
		this.insPrdSimName = insPrdSimName;
	}

	public String getAssuranceType() {
		return assuranceType;
	}

	public void setAssuranceType(String assuranceType) {
		this.assuranceType = assuranceType;
	}

	public String getBuyUnit() {
		return buyUnit;
	}

	public void setBuyUnit(String buyUnit) {
		this.buyUnit = buyUnit;
	}

	public String getInsPrdType() {
		return insPrdType;
	}

	public void setInsPrdType(String insPrdType) {
		this.insPrdType = insPrdType;
	}

	public String getInsBeginDate() {
		return insBeginDate;
	}

	public void setInsBeginDate(String insBeginDate) {
		this.insBeginDate = insBeginDate;
	}

	public String getInsEndDate() {
		return insEndDate;
	}

	public void setInsEndDate(String insEndDate) {
		this.insEndDate = insEndDate;
	}

	public String getStartAMT() {
		return startAMT;
	}

	public void setStartAMT(String startAMT) {
		this.startAMT = startAMT;
	}

	public String getEntAMT() {
		return entAMT;
	}

	public void setEntAMT(String entAMT) {
		this.entAMT = entAMT;
	}

	public String getInCreaseAMT() {
		return inCreaseAMT;
	}

	public void setInCreaseAMT(String inCreaseAMT) {
		this.inCreaseAMT = inCreaseAMT;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImpawnFlag() {
		return impawnFlag;
	}

	public void setImpawnFlag(String impawnFlag) {
		this.impawnFlag = impawnFlag;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}


}
