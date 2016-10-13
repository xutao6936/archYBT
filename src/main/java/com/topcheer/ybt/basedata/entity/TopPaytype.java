package com.topcheer.ybt.basedata.entity;

public class TopPaytype {

	// ID

	private String id;
	// 产品编码

	private String insprdCode;
	// 键(1:趸缴 2:月缴 3:季缴 4:半年缴 5:年缴)

	private String key;
	// 值(1:趸缴 2:月缴 3:季缴 4:半年缴 5:年缴)

	private String value;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
