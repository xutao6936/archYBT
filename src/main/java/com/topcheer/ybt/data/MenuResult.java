package com.topcheer.ybt.data;

/** 
 * @ClassName: MenuResult 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author XUTAO 
 * @date 2016-7-5 上午09:03:10 
 *  
 */
public class MenuResult {
	
	private String menuCode;
	private String upMenuCode;
	private String menuName;
	private String menuUrl;
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getUpMenuCode() {
		return upMenuCode;
	}
	public void setUpMenuCode(String upMenuCode) {
		this.upMenuCode = upMenuCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public MenuResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuResult(String menuCode, String upMenuCode, String menuName,
			String menuUrl) {
		super();
		this.menuCode = menuCode;
		this.upMenuCode = upMenuCode;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
	}
	@Override
	public String toString() {
		return "MenuResult [menuCode=" + menuCode + ", upMenuCode="
				+ upMenuCode + ", menuName=" + menuName + ", menuUrl="
				+ menuUrl + "]";
	}

	
	
	

}
