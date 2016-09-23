package com.topcheer.ybt.basedata.entity;

import org.hibernate.validator.constraints.NotBlank;

public class TopInsCorpInfo {
	private String id;
	@NotBlank(message="保险公司编码不能为空")
	private String insCorpCode;
	@NotBlank(message="保险公司名称不能为空")
	private String insCorpName;
	//保险公司中文简称
	private String insSimpName;
	//级别 0-总公司  1-分公司
	@NotBlank(message="保险公司级别设置不能为空")
	private String insCorpLevel;
	//总公司编码  如果是总公司  值为-1
	@NotBlank(message="总公司编码设置不能为空")
	private String upCorpCode;
	//保险公司英文名称
	private String insCorpEnName;
	//地址
	private String address;
	//邮编
	private String postCode;
	//联系电话
	private String phone;
	//传真
	private String fax;
	//公司邮箱
	private String email;
	//状态
	private String status;
	//操作人员
	private String operatorCode;
	//操作机构
	private String operatorBank;
	//创建日期
	private String createDate;
	//更新日期
	private String updateDate;
	//更新时间
	private String updateTime;
	//统一柜面接口
	private String commonCountFlag;
	//统一网销接口
	private String commonNetFlag;
	//统一对账接口
	private String commonCheckFlag;
	//统一非实时对账接口
	private String commonNossdcheckFlag;
	//统一退保接口
	private String commonSystbFlag;
	//开通渠道
    private String channelFlag;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInsCorpCode() {
		return insCorpCode;
	}
	public void setInsCorpCode(String insCorpCode) {
		this.insCorpCode = insCorpCode;
	}
	public String getInsCorpName() {
		return insCorpName;
	}
	public void setInsCorpName(String insCorpName) {
		this.insCorpName = insCorpName;
	}
	public String getInsSimpName() {
		return insSimpName;
	}
	public void setInsSimpName(String insSimpName) {
		this.insSimpName = insSimpName;
	}
	public String getInsCorpLevel() {
		return insCorpLevel;
	}
	public void setInsCorpLevel(String insCorpLevel) {
		this.insCorpLevel = insCorpLevel;
	}
	public String getUpCorpCode() {
		return upCorpCode;
	}
	public void setUpCorpCode(String upCorpCode) {
		this.upCorpCode = upCorpCode;
	}
	public String getInsCorpEnName() {
		return insCorpEnName;
	}
	public void setInsCorpEnName(String insCorpEnName) {
		this.insCorpEnName = insCorpEnName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getOperatorBank() {
		return operatorBank;
	}
	public void setOperatorBank(String operatorBank) {
		this.operatorBank = operatorBank;
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
	public String getCommonCountFlag() {
		return commonCountFlag;
	}
	public void setCommonCountFlag(String commonCountFlag) {
		this.commonCountFlag = commonCountFlag;
	}
	public String getCommonNetFlag() {
		return commonNetFlag;
	}
	public void setCommonNetFlag(String commonNetFlag) {
		this.commonNetFlag = commonNetFlag;
	}
	public String getCommonCheckFlag() {
		return commonCheckFlag;
	}
	public void setCommonCheckFlag(String commonCheckFlag) {
		this.commonCheckFlag = commonCheckFlag;
	}
	public String getCommonNossdcheckFlag() {
		return commonNossdcheckFlag;
	}
	public void setCommonNossdcheckFlag(String commonNossdcheckFlag) {
		this.commonNossdcheckFlag = commonNossdcheckFlag;
	}
	public String getCommonSystbFlag() {
		return commonSystbFlag;
	}
	public void setCommonSystbFlag(String commonSystbFlag) {
		this.commonSystbFlag = commonSystbFlag;
	}
	public String getChannelFlag() {
		return channelFlag;
	}
	public void setChannelFlag(String channelFlag) {
		this.channelFlag = channelFlag;
	}

}
