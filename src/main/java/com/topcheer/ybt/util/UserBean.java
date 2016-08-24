package com.topcheer.ybt.util;

/** 
* @ClassName: UserBean 
* @Description: 
* @author XUTAO 
* @date 2016-6-17 上午09:15:56 
*  
*/
public class UserBean {
	private String userCode;
	private String userName;
	private String roleId;
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "UserBean [userCode=" + userCode + ", userName=" + userName
				+ ", roleId=" + roleId + "]";
	}
	
	

}
