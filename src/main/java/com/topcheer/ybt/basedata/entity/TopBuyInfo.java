package com.topcheer.ybt.basedata.entity;


public class TopBuyInfo {
	
	private String serialno ;        //交易流水号
	private String channelflag ;     //渠道标志(01: 柜面   02: 网银   03: 手机  04: 直销  05:自助)
	private String channelno ;       //渠道流水号
	private String inscorpcode ;     //保险公司代码
	private String templateid ;      //产品库ID
	private String areaid ;          //地区代码
	private String prepolicyid ;     //投保单号
	private String policyid ;        //保单印刷号
	private String oldpolicyid ;     //旧保单印刷号
	private String contractid ;      //保单合同号码
	private String orgnserialno ;    //原交易流水号
	private String firstpremium ;    //首期保费
	private String firstpremiumcn ;  //首期保费大写
	private String effdate ;         //保单生效日期
	private String revdate ;         //保单到期日期
	private String innercommission ; //内扣手续费
	private String outercommission ; //外扣手续费
	private String lcoperatorcode ;  //销售人员网点号
	private String lcoperatorid ;    //销售人员ID
	private String lcoperatorname ;  //销售人员姓名
	private String tzoperatorcode ;  //拓展人员网点号
	private String tzoperatorid ;    //拓展人员ID
	private String tzoperatorname ;  //拓展人员姓名
	private String inscorpstatus ;   //保险公司状态(1: 待核保   2: 核保成功   3: 核保失败   4: 冲正成功   5: 冲正失败)
	private String corestatus ;      //核心状态(1: 未扣款   2: 扣款成功   3: 扣款失败   4: 冲正成功   5: 冲正失败   6: 撤单未还款)
	private String recordstatus ;    //保单打印状态(1: 已打印   2: 未打印)
	private String serialtype ;      //保单状态(1: 正常   2: 失效   3: 终止)
	private String deliver ;         //保单传递方式(1: 银行柜台   2: 邮件发送   3: 上门递送   4: 邮寄)
	private String operatorbankcode ;//操作机构
	private String operatorcode ;    //操作人员
	private String updatedate ;      //操作日期
	private String updatetime ;      //操作时间
	private String remark1 ;         //备注字段一
	private String remark2 ;         //备注字段二
	private String remark3 ;         //备注字段三
	private String remark4 ;         //备注字段四
	private String remark5 ;         //备注字段五
	private String remark6 ;         //备注字段六
	private String remark7 ;         //备注字段七
	private String remark8 ;         //备注字段八
	private String remark9 ;         //备注字段九
	private String remark10 ;        //备注字段十

	public String getChannelflag() {
		return channelflag;
	}
	public void setChannelflag(String channelflag) {
		this.channelflag = channelflag;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public String getChannelno() {
		return channelno;
	}
	public void setChannelno(String channelno) {
		this.channelno = channelno;
	}
	public String getInscorpcode() {
		return inscorpcode;
	}
	public void setInscorpcode(String inscorpcode) {
		this.inscorpcode = inscorpcode;
	}
	public String getTemplateid() {
		return templateid;
	}
	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getPrepolicyid() {
		return prepolicyid;
	}
	public void setPrepolicyid(String prepolicyid) {
		this.prepolicyid = prepolicyid;
	}
	public String getPolicyid() {
		return policyid;
	}
	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}
	public String getOldpolicyid() {
		return oldpolicyid;
	}
	public void setOldpolicyid(String oldpolicyid) {
		this.oldpolicyid = oldpolicyid;
	}
	public String getContractid() {
		return contractid;
	}
	public void setContractid(String contractid) {
		this.contractid = contractid;
	}
	public String getOrgnserialno() {
		return orgnserialno;
	}
	public void setOrgnserialno(String orgnserialno) {
		this.orgnserialno = orgnserialno;
	}
	public String getFirstpremium() {
		return firstpremium;
	}
	public void setFirstpremium(String firstpremium) {
		this.firstpremium = firstpremium;
	}
	public String getFirstpremiumcn() {
		return firstpremiumcn;
	}
	public void setFirstpremiumcn(String firstpremiumcn) {
		this.firstpremiumcn = firstpremiumcn;
	}
	public String getEffdate() {
		return effdate;
	}
	public void setEffdate(String effdate) {
		this.effdate = effdate;
	}
	public String getRevdate() {
		return revdate;
	}
	public void setRevdate(String revdate) {
		this.revdate = revdate;
	}
	public String getInnercommission() {
		return innercommission;
	}
	public void setInnercommission(String innercommission) {
		this.innercommission = innercommission;
	}
	public String getOutercommission() {
		return outercommission;
	}
	public void setOutercommission(String outercommission) {
		this.outercommission = outercommission;
	}
	public String getLcoperatorcode() {
		return lcoperatorcode;
	}
	public void setLcoperatorcode(String lcoperatorcode) {
		this.lcoperatorcode = lcoperatorcode;
	}
	public String getLcoperatorid() {
		return lcoperatorid;
	}
	public void setLcoperatorid(String lcoperatorid) {
		this.lcoperatorid = lcoperatorid;
	}
	public String getLcoperatorname() {
		return lcoperatorname;
	}
	public void setLcoperatorname(String lcoperatorname) {
		this.lcoperatorname = lcoperatorname;
	}
	public String getTzoperatorcode() {
		return tzoperatorcode;
	}
	public void setTzoperatorcode(String tzoperatorcode) {
		this.tzoperatorcode = tzoperatorcode;
	}
	public String getTzoperatorid() {
		return tzoperatorid;
	}
	public void setTzoperatorid(String tzoperatorid) {
		this.tzoperatorid = tzoperatorid;
	}
	public String getTzoperatorname() {
		return tzoperatorname;
	}
	public void setTzoperatorname(String tzoperatorname) {
		this.tzoperatorname = tzoperatorname;
	}
	public String getInscorpstatus() {
		return inscorpstatus;
	}
	public void setInscorpstatus(String inscorpstatus) {
		this.inscorpstatus = inscorpstatus;
	}
	public String getCorestatus() {
		return corestatus;
	}
	public void setCorestatus(String corestatus) {
		this.corestatus = corestatus;
	}
	public String getRecordstatus() {
		return recordstatus;
	}
	public void setRecordstatus(String recordstatus) {
		this.recordstatus = recordstatus;
	}
	public String getSerialtype() {
		return serialtype;
	}
	public void setSerialtype(String serialtype) {
		this.serialtype = serialtype;
	}
	public String getDeliver() {
		return deliver;
	}
	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}
	public String getOperatorbankcode() {
		return operatorbankcode;
	}
	public void setOperatorbankcode(String operatorbankcode) {
		this.operatorbankcode = operatorbankcode;
	}
	public String getOperatorcode() {
		return operatorcode;
	}
	public void setOperatorcode(String operatorcode) {
		this.operatorcode = operatorcode;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	public String getRemark4() {
		return remark4;
	}
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
	public String getRemark5() {
		return remark5;
	}
	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}
	public String getRemark6() {
		return remark6;
	}
	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}
	public String getRemark7() {
		return remark7;
	}
	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}
	public String getRemark8() {
		return remark8;
	}
	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}
	public String getRemark9() {
		return remark9;
	}
	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}
	public String getRemark10() {
		return remark10;
	}
	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}
	
	
}
