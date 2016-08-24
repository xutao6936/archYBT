package com.topcheer.ybt.entity.system;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class TopMenuinfo {
	
	//@NotBlank(message="ID不能为空")
	private String menuId;
	
	@NotBlank(message="菜单编号不能为空")
	private String menuCode;
	@NotBlank(message="父菜单不能为空")
	private String faMenuCode;
	@NotBlank(message="菜单名称不能为空")
	private String menuName;
	
	private String icon;
	
	private String menuUrl;

	private String status;

	private String createDate;

	private String updateDate;

	private String updateTime;

	private String updateOperator;
	
	private List<TopMenuinfo> menulist;//子菜单
	
	private boolean checked;//权限标志

	private String remark1;

	private String remark2;

	private String remark3;

	private String remark4;

	private String remark5;

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

	public String getFaMenuCode() {
		return faMenuCode;
	}

	public void setFaMenuCode(String faMenuCode) {
		this.faMenuCode = faMenuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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

	public TopMenuinfo(String menuCode, String faMenuCode, String menuName) {
		super();
		this.menuCode = menuCode;
		this.faMenuCode = faMenuCode;
		this.menuName = menuName;
	}

	public TopMenuinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TopMenuinfo [menuId=" + menuId + ", menuCode=" + menuCode
				+ ", faMenuCode=" + faMenuCode + ", menuName=" + menuName
				+ ", icon=" + icon + ", menuUrl=" + menuUrl + ", status="
				+ status + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", updateTime=" + updateTime
				+ ", updateOperator=" + updateOperator + ", menulist="
				+ menulist + ", checked=" + checked + ", remark1=" + remark1
				+ ", remark2=" + remark2 + ", remark3=" + remark3
				+ ", remark4=" + remark4 + ", remark5=" + remark5 + "]";
	}

	

}
