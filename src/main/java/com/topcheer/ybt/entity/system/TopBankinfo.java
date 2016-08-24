package com.topcheer.ybt.entity.system;

import org.hibernate.validator.constraints.NotBlank;


public class TopBankinfo {
	
	@NotBlank(message="机构号不能为空")
	private String bankCode;
	
	@NotBlank(message="机构名称不能为空")
	private String bankName;
	/*
	0-总行
	1-分行
	2-支行
	3-网点
	*/
	private String bankLevel;
	
	@NotBlank(message="上级机构号不能为空")
	private String upBankcode;

	private String adminFlag;

	private String address;

	private String postcode;

	private String phone;

	private String fax;

	private String status;

	private String operatorBankcode;

	private String operatorCode;

	private String updatedate;

	private String updatetime;

	private String certno;

	private String certenddate;

	private String certstartdate;

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankLevel() {
		return bankLevel;
	}

	public void setBankLevel(String bankLevel) {
		this.bankLevel = bankLevel;
	}

	public String getUpBankcode() {
		return upBankcode;
	}

	public void setUpBankcode(String upBankcode) {
		this.upBankcode = upBankcode;
	}

	public String getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperatorBankcode() {
		return operatorBankcode;
	}

	public void setOperatorBankcode(String operatorBankcode) {
		this.operatorBankcode = operatorBankcode;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getCertno() {
		return certno;
	}

	public void setCertno(String certno) {
		this.certno = certno;
	}

	public String getCertenddate() {
		return certenddate;
	}

	public void setCertenddate(String certenddate) {
		this.certenddate = certenddate;
	}

	public String getCertstartdate() {
		return certstartdate;
	}

	public void setCertstartdate(String certstartdate) {
		this.certstartdate = certstartdate;
	}

}
