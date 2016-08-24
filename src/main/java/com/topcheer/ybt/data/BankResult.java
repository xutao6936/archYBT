package com.topcheer.ybt.data;

/**
 * @ClassName: BankResult
 * @Description:
 * @author XUTAO
 * @date 2016-6-30 下午02:23:08
 * 
 */
public class BankResult {

	private String bankCode;
	private String bankName;
	private String bankLevel;
	private String upBankcode;
	private String status;
	private String updatedate;

	public BankResult() {
		super();
	}

	public BankResult(String bankCode, String bankName, String bankLevel,
			String upBankcode, String status, String updatedate) {
		super();
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.bankLevel = bankLevel;
		this.upBankcode = upBankcode;
		this.status = status;
		this.updatedate = updatedate;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankLevel() {
		return bankLevel;
	}

	public void setBankLevel(String bankLevel) {
		this.bankLevel = bankLevel;
	}

	public String getUpBankcode() {
		return upBankcode;
	}

	public void setUpBankcode(String upBankcode) {
		this.upBankcode = upBankcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "BankResult [bankCode=" + bankCode + ", bankName=" + bankName
				+ ", bankLevel=" + bankLevel + ", upBankcode=" + upBankcode
				+ ", status=" + status + ", updatedate=" + updatedate + "]";
	}

}
