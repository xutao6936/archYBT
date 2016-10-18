package com.topcheer.ybt.restws.pojo;

import java.util.List;
import org.apache.poi.ss.formula.functions.T;

public class InsPrdsResult<T> {

	private String resultCode;
	private String resultInfo;
	private List<T> insPrds;

	

	public InsPrdsResult(String resultCode, String resultInfo, List<T> insPrds) {
		super();
	}



	public InsPrdsResult() {
		super();
	}

	

	public List<T> getInsPrds() {
		return insPrds;
	}



	public void setInsPrds(List<T> insPrds) {
		this.insPrds = insPrds;
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
