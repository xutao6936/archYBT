package com.topcheer.ybt.system.entity;

import java.util.List;

public class TopMenuinfo {
	// 菜单ID
	private String menuId;
	// 菜单编号
	private String menuCode;
	// 菜单名称
	private String menuName;
	// 上级菜单编号
	private String upMenuCode;
	// URL
	private String menuUrl;
	// 状态(0:有效 1:无效)
	private String status;
	// 创建日期
	private String createDate;
	// 更新日期
	private String updateDate;
	// 更新时间
	private String updateTime;
	// 更新账号
	private String updateOperator;
	// 图标
	private String icon;
	//子菜单
	private List<TopMenuinfo> menulist;
	//权限标志
	private boolean checked;
	// 备用字段1
	private String remark1;
	// 备用字段2
	private String remark2;
	// 备用字段3
	private String remark3;
	// 备用字段4
	private String remark4;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUpMenuCode() {
		return upMenuCode;
	}

	public void setUpMenuCode(String upMenuCode) {
		this.upMenuCode = upMenuCode;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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

	public List<TopMenuinfo> getMenulist() {
		return menulist;
	}

	public void setMenulist(List<TopMenuinfo> menulist) {
		this.menulist = menulist;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
