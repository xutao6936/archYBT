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
	private String faMenuCode;
	private String menuName;
	private String menuUrl;
	
	
	
	
	public MenuResult() {
		super();
	}
	public MenuResult(String menuCode, String faMenuCode, String menuName,
			String menuUrl) {
		super();
		this.menuCode = menuCode;
		this.faMenuCode = faMenuCode;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
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
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	
	
	

}
