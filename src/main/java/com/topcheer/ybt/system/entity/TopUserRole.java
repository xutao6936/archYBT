package com.topcheer.ybt.system.entity;



public class TopUserRole {
	
	//ID
	
	private    String   id ;
	//角色ID
	
	private    String   roleId ;
	//用户ID
	
	private    String   userId ;
	//创建日期
	
	private    String   createDate ;
	//更新日期
	
	private    String   updateDate ;
    
    
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
    
	public String getRoleId() {
		return roleId;
	}
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
    
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "TopUserRole [id=" + id + ", roleId=" + roleId + ", userId="
				+ userId + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", getId()=" + getId() + ", getRoleId()="
				+ getRoleId() + ", getUserId()=" + getUserId()
				+ ", getCreateDate()=" + getCreateDate() + ", getUpdateDate()="
				+ getUpdateDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
