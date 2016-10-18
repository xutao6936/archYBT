package com.topcheer.ybt.restws.pojo;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.topcheer.ybt.system.entity.TopMenuinfo;

public class InsPrdsResult {

	private String resultCode;
	private String resultInfo;
	//private List<PolicyInquiryPojo> list;
	
	private List<TopMenuinfo> list;

	public InsPrdsResult() {
		super();
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

	public List<TopMenuinfo> getList() {
		return list;
	}

	public void setList(List<TopMenuinfo> list) {
		this.list = list;
	}


}
