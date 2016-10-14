package com.topcheer.ybt.restws.pojo;

import java.util.List;

public class InsPrdsResult {

	private String resultCode;
	private String resultInfo;
	private List<InsPrdPojo> insPrds;

	public InsPrdsResult(String resultCode, String resultInfo, List<InsPrdPojo> insPrds) {
		super();
		this.resultCode = resultCode;
		this.resultInfo = resultInfo;
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

	public List<InsPrdPojo> getInsPrds() {
		return insPrds;
	}

	public void setInsPrds(List<InsPrdPojo> insPrds) {
		this.insPrds = insPrds;
	}

	@Override
	public String toString() {
		return "InsPrdsResult [resultCode=" + resultCode + ", resultInfo=" + resultInfo + ", insPrds=" + insPrds + "]";
	}

}
