package com.topcheer.ybt.basedata.entity;

public class TopPayperiod {

	// ID
	private String id;
	// 产品编码
	private String insprdCode;
	// 值(如单位为终身, 则值为2)
	private String key;
	// 单位(0-年 1-周岁 2-终身 )
	private String unit;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInsprdCode() {
		return insprdCode;
	}

	public void setInsprdCode(String insprdCode) {
		this.insprdCode = insprdCode;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
