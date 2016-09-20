package com.topcheer.ybt.system.entity;

import org.hibernate.validator.constraints.NotBlank;


public class TopRoleinfo {

	private String roleId;
	
	@NotBlank(message="角色代码不能为空")
	private String roleCode;
	
	@NotBlank(message="角色代码不能为空")
	private String roleName;

	private String description;

	private String isreview;
	
	@NotBlank(message="状态不能为空")
	private String status;

	private String createDate;

	private String updateDate;

	private String updateTime;

	private String updateOperator;

	private String remark1;

	private String remark2;

	private String remark3;

	private String remark4;

	private String remark5;
	
	private boolean checked;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsreview() {
		return isreview;
	}

	public void setIsreview(String isreview) {
		this.isreview = isreview;
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

	public String getUpdateOperator() {
		return updateOperator;
	}

	public void setUpdateOperator(String updateOperator) {
		this.updateOperator = updateOperator;
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

	public String getRemark5() {
		return remark5;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
	
}
