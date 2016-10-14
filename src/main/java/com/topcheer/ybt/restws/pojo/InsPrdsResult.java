package com.topcheer.ybt.restws.pojo;

import java.util.List;


public class InsPrdsResult<T> {

	private String resultCode;
	private String resultInfo;
	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public InsPrdsResult(String resultCode, String resultInfo, List<T> list) {
		super();
		this.resultCode = resultCode;
		this.resultInfo = resultInfo;
		this.list = list;
	}

	public InsPrdsResult() {
		super();
	}

	public void setList(List<T> list) {
		this.list = list;
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


}
