package com.topcheer.ybt.system.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class TopUserinfo {
	
	//用户ID
	
	private    String   userId ;
	//登录账号
	
	private    String   loginAccount ;
	//用户名
	
	private    String   loginPwd ;
	//姓名
	
	private    String   userName ;
	//状态（0:有效 1:无效）
	
	private    String   userStatus ;
	//所属机构
	
	private    String   userDept ;
	//创建日期
	
	private    String   createDate ;
	//用户电话
	
	private    String   operatorPhone ;
	//更新日期
	
	private    String   updateDate ;
	//更新时间
	
	private    String   updateTime ;
	//更新账号
	
	private    String   updateOperator ;
	//文件路径
	
	private    String   filePath ;
	//备注字段1
	
	private    String   remark1 ;
	//备注字段2
	
	private    String   remark2 ;
	//备注字段3
	
	private    String   remark3 ;
	//备注字段4
	
	private    String   remark4 ;
    
    
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
	
    
	public String getUserStatus() {
		return userStatus;
	}
	
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
    
	public String getUserDept() {
		return userDept;
	}
	
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}
	
    
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
    
	public String getOperatorPhone() {
		return operatorPhone;
	}
	
	public void setOperatorPhone(String operatorPhone) {
		this.operatorPhone = operatorPhone;
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
	
    
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	@Override
	public String toString() {
		return "TopUserinfo [userId=" + userId + ", loginAccount="
				+ loginAccount + ", loginPwd=" + loginPwd + ", userName="
				+ userName + ", userStatus=" + userStatus + ", userDept="
				+ userDept + ", createDate=" + createDate + ", operatorPhone="
				+ operatorPhone + ", updateDate=" + updateDate
				+ ", updateTime=" + updateTime + ", updateOperator="
				+ updateOperator + ", filePath=" + filePath + ", remark1="
				+ remark1 + ", remark2=" + remark2 + ", remark3=" + remark3
				+ ", remark4=" + remark4 + "]";
	}
	
	
}
