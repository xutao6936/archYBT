package com.topcheer.ybt.entity.system;

import org.hibernate.validator.constraints.NotBlank;

public class TopUserinfo {

	private String userId;
	
	@NotBlank(message="登录账号不能为空")
	private String loginAccount;
	
	@NotBlank(message="密码不能为空")
	private String loginPwd;
	
	@NotBlank(message="用户名不能为空")
	private String userName;

	private String userLevel;

	private String userDept;

	private String userStatus;

	private String isreview;

	private String createDate;

	private String updateDate;

	private String updateTime;

	private String updateOperator;

	private String salt;
	
	private String filePath ;

	private String remark1;

	private String remark2;

	private String remark3;

	private String remark4;

	private String remark5;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getIsreview() {
		return isreview;
	}

	public void setIsreview(String isreview) {
		this.isreview = isreview;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "TopUserinfo [userId=" + userId + ", loginAccount="
				+ loginAccount + ", loginPwd=" + loginPwd + ", userName="
				+ userName + ", userLevel=" + userLevel + ", userDept="
				+ userDept + ", userStatus=" + userStatus + ", isreview="
				+ isreview + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", updateTime=" + updateTime
				+ ", updateOperator=" + updateOperator + ", salt=" + salt
				+ ", filePath=" + filePath + ", remark1=" + remark1
				+ ", remark2=" + remark2 + ", remark3=" + remark3
				+ ", remark4=" + remark4 + ", remark5=" + remark5 + "]";
	}
	
	
}
