package com.topcheer.ybt.data;

/**
 * @ClassName: InsPrdResult
 * @Description: 产品详情查询
 * @author XUTAO
 * @date 2016-7-4 下午11:09:41
 * 
 */
public class InsPrdResult {

	private String inscorpCode = "";
	private String insPrdCode;
	private String minInsYear;
	private String minInsYearUnit;
	private String maxInsYear;
	private String maxInsYearUnit;
	private String insPrdSpecial;
	private String insNotice;

	public InsPrdResult() {
		super();
	}

	public InsPrdResult(String inscorpCode, String insPrdCode,
			String minInsYear, String minInsYearUnit, String maxInsYear,
			String maxInsYearUnit, String insPrdSpecial, String insNotice) {
		super();
		this.inscorpCode = inscorpCode;
		this.insPrdCode = insPrdCode;
		this.minInsYear = minInsYear;
		this.minInsYearUnit = minInsYearUnit;
		this.maxInsYear = maxInsYear;
		this.maxInsYearUnit = maxInsYearUnit;
		this.insPrdSpecial = insPrdSpecial;
		this.insNotice = insNotice;
	}


	public String getInsPrdCode() {
		return insPrdCode;
	}

	public void setInsPrdCode(String insPrdCode) {
		this.insPrdCode = insPrdCode;
	}

	public String getMinInsYear() {
		return minInsYear;
	}

	public void setMinInsYear(String minInsYear) {
		this.minInsYear = minInsYear;
	}

	public String getMinInsYearUnit() {
		return minInsYearUnit;
	}

	public void setMinInsYearUnit(String minInsYearUnit) {
		this.minInsYearUnit = minInsYearUnit;
	}

	public String getMaxInsYear() {
		return maxInsYear;
	}

	public void setMaxInsYear(String maxInsYear) {
		this.maxInsYear = maxInsYear;
	}

	public String getMaxInsYearUnit() {
		return maxInsYearUnit;
	}

	public void setMaxInsYearUnit(String maxInsYearUnit) {
		this.maxInsYearUnit = maxInsYearUnit;
	}

	public String getInsPrdSpecial() {
		return insPrdSpecial;
	}

	public void setInsPrdSpecial(String insPrdSpecial) {
		this.insPrdSpecial = insPrdSpecial;
	}

	public String getInsNotice() {
		return insNotice;
	}

	public void setInsNotice(String insNotice) {
		this.insNotice = insNotice;
	}
	
	public String getInscorpCode() {
		return inscorpCode;
	}

	public void setInscorpCode(String inscorpCode) {
		this.inscorpCode = inscorpCode;
	}

}
