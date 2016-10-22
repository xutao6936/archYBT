package com.topcheer.ybt.restws.pojo;

/**
 * 当日撤单手机端入参
 * @author liuc
 *
 */
public class CancleBusinessReqPojo {
	private String channelType;//渠道标志(01:柜面 02:网银 03:手机 04:直销 05:自助)
	private String serialNo;//银保通流水号
	
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	@Override
	public String toString() {
		return "CancleBusinessReqPojo [channelType=" + channelType
				+ ", serialNo=" + serialNo + "]";
	}
}
