package com.topcheer.ybt.entity.system;

import org.hibernate.validator.constraints.NotBlank;

public class TopMenuInfoForSelect2 {
	@NotBlank(message="菜单编号不能为空")
	private String menuCode;
	@NotBlank(message="菜单名称不能为空")
	private String menuName;
	@NotBlank(message="父菜单名称不能为空")
	private String faMenuCode;
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
	public String getFaMenuCode() {
		return faMenuCode;
	}
	public void setFaMenuCode(String faMenuCode) {
		this.faMenuCode = faMenuCode;
	}
	
	
}
