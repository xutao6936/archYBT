package com.topcheer.ybt.restws.pojo;
/**
 * 核心扣款返回手机端信息
 * @author liuc
 *
 */
public class CorePayValRespPojo {
	private String contractId;//保单号
	private String resultCode;//结果编码(000000为成功)
	private String resultInfo;//结果信息
	
	public CorePayValRespPojo() {
		super();
	}
	
	public CorePayValRespPojo(String contractId, String resultCode,
			String resultInfo) {
		super();
		this.contractId = contractId;
		this.resultCode = resultCode;
		this.resultInfo = resultInfo;
	}

	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
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
	@Override
	public String toString() {
		return "CorePayValRespPojo [contractId=" + contractId + ", resultCode="
				+ resultCode + ", resultInfo=" + resultInfo + "]";
	}
	
}
