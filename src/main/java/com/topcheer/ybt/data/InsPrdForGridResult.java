package com.topcheer.ybt.data;

/** 
 * @ClassName: InsPrdForGridResult 
 * @Description: 产品列表查询
 * @author XUTAO 
 * @date 2016-7-4 下午11:09:27 
 *  
 */
public class InsPrdForGridResult {
	private String insPrdCode;
	private String insPrdName;
	private String menuName;
	private String sumInsured;
	/*
	1-新
	2-抢
	3-热
	*/
	private String hotType;
	private String premium;
	
	
	
	
	public InsPrdForGridResult() {
		super();
	}
	public InsPrdForGridResult(String insPrdCode, String insPrdName,
			String menuName, String sumInsured, String hotType, String premium) {
		super();
		this.insPrdCode = insPrdCode;
		this.insPrdName = insPrdName;
		this.menuName = menuName;
		this.sumInsured = sumInsured;
		this.hotType = hotType;
		this.premium = premium;
	}
	public String getInsPrdCode() {
		return insPrdCode;
	}
	public void setInsPrdCode(String insPrdCode) {
		this.insPrdCode = insPrdCode;
	}
	public String getInsPrdName() {
		return insPrdName;
	}
	public void setInsPrdName(String insPrdName) {
		this.insPrdName = insPrdName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getSumInsured() {
		return sumInsured;
	}
	public void setSumInsured(String sumInsured) {
		this.sumInsured = sumInsured;
	}
	public String getHotType() {
		return hotType;
	}
	public void setHotType(String hotType) {
		this.hotType = hotType;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
}
