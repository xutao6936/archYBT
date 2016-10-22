package com.topcheer.ybt.restws.pojo;

/**
 * 交易查询手机端入参
 * @author liuc
 *
 */
public class TransQueryReqPojo {
	private String phCfcType   ;//证件类型
	private String phCfcNo     ;//证件号码
	private String channelType ;//渠道标志(01:柜面 02:网银 03:手机 04:直销 05:自助)
	private String startDate   ;//开始日期
	private String endDate     ;//结束日期
	private String selectFlag  ;//查询标志(1-当日查询（待生效）   2-历史查询（已生效）  3-我的保单(全部) 4-已撤单查询)
	
	public String getPhCfcType() {
		return phCfcType;
	}
	public void setPhCfcType(String phCfcType) {
		this.phCfcType = phCfcType;
	}
	public String getPhCfcNo() {
		return phCfcNo;
	}
	public void setPhCfcNo(String phCfcNo) {
		this.phCfcNo = phCfcNo;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getSelectFlag() {
		return selectFlag;
	}
	public void setSelectFlag(String selectFlag) {
		this.selectFlag = selectFlag;
	}
	@Override
	public String toString() {
		return "TransQueryReqPojo [phCfcType=" + phCfcType + ", phCfcNo="
				+ phCfcNo + ", channelType=" + channelType + ", startDate="
				+ startDate + ", endDate=" + endDate + ", selectFlag="
				+ selectFlag + "]";
	}

}
