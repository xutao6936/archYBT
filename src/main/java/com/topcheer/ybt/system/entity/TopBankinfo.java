package com.topcheer.ybt.system.entity;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class TopBankinfo {

	// 机构ID

	private String bankId;
	// 机构编号
	@NotBlank(message="机构编号不能为空")
	private String bankCode;
	// 机构名称
	@NotBlank(message="机构名称不能为空")
	@Size(max=40,message="机构名称不能大于20")
	private String bankName;
	// 机构级别(0:总行 1:分行 2:支行 3:网点 )
	@NotBlank(message="机构等级不能为空")
	private String bankLevel;
	// 上级机构编号
	private String upBankCode;
	// 机构地址

	private String address;
	// 邮编

	private String postcode;
	// 电话

	private String phone;
	// 传真

	private String fax;
	// 状态(0:有效 1:无效)

	private String status;
	// 创建日期

	private String createDate;
	// 更新日期

	private String updateDate;
	// 更新时间

	private String updateTime;
	// 机构代理编号

	private String certNo;
	// 代理开始日期

	private String certStartDate;
	// 代理结束日期

	private String certEndDate;
	// 备用字段1

	private String remark1;
	// 备用字段2

	private String remark2;
	// 备用字段3

	private String remark3;
	// 备用字段4

	private String remark4;

	//子机构
	private List<TopBankinfo> topBankinfolist;
		
	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

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

	public String getUpBankCode() {
		return upBankCode;
	}

	public void setUpBankCode(String upBankCode) {
		this.upBankCode = upBankCode;
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

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getCertStartDate() {
		return certStartDate;
	}

	public void setCertStartDate(String certStartDate) {
		this.certStartDate = certStartDate;
	}

	public String getCertEndDate() {
		return certEndDate;
	}

	public void setCertEndDate(String certEndDate) {
		this.certEndDate = certEndDate;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark4() {
		return remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public List<TopBankinfo> getTopBankinfolist() {
		return topBankinfolist;
	}

	public void setTopBankinfolist(List<TopBankinfo> topBankinfolist) {
		this.topBankinfolist = topBankinfolist;
	}

	@Override
	public String toString() {
		return "TopBankinfo [bankId=" + bankId + ", bankCode=" + bankCode
				+ ", bankName=" + bankName + ", bankLevel=" + bankLevel
				+ ", upBankCode=" + upBankCode + ", address=" + address
				+ ", postcode=" + postcode + ", phone=" + phone + ", fax="
				+ fax + ", status=" + status + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", updateTime=" + updateTime
				+ ", certNo=" + certNo + ", certStartDate=" + certStartDate
				+ ", certEndDate=" + certEndDate + ", remark1=" + remark1
				+ ", remark2=" + remark2 + ", remark3=" + remark3
				+ ", remark4=" + remark4 + "]";
	}
	
	
	

}
