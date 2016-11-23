package com.topcheer.ybt.restws;


import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.topcheer.ybt.basedata.biz.ITopTradeInfoBiz;
import com.topcheer.ybt.basedata.entity.TopBfyInfo;
import com.topcheer.ybt.basedata.entity.TopBuyInfo;
import com.topcheer.ybt.basedata.entity.TopBuyInfoAdd;
import com.topcheer.ybt.basedata.entity.TopPhInfo;
import com.topcheer.ybt.basedata.entity.TopRnInfo;
import com.topcheer.ybt.basedata.entity.TopSpecialInfo;
import com.topcheer.ybt.restws.pojo.InsureInfoReqPojo;
import com.topcheer.ybt.restws.pojo.InsureInfoRespPojo;
import com.topcheer.ybt.util.DateUtil;

/**
 * @ClassName: InsureInforInRsService
 * @Description: TODO(保险详细信息录入)
 * @author xuxl
 * @date 
 * 
 */
@Path("/insureInforInRsService")
public class InsureInforInRsService {

	@Resource(name = "topTradeInfoBizImpl")
	ITopTradeInfoBiz iTopTradeInfoBiz;

	@Path("/insureInfoin")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public InsureInfoRespPojo insureInfoin(InsureInfoReqPojo insureinfopojo) {
		
		String resultInfo = "";
		String resultCode = "";
		InsureInfoRespPojo insureInfoRespPojo;
		try{
			//根据流水号查询银保通系统中的交易信息
			List<TopBuyInfo> list = iTopTradeInfoBiz.selectBaseInfo(insureinfopojo.getSerialNo());
			if(0==list.size()){
				insureInfoRespPojo = new InsureInfoRespPojo();
			    resultInfo = "银保通系统中无此流水";
			    resultCode = "000001";
			    insureInfoRespPojo.setResultCode(resultCode);
				insureInfoRespPojo.setResultInfo(resultInfo);
				return insureInfoRespPojo;
			}
			//1分布封装数据
			TopBuyInfo topbuyinfo = setBuyInfo(insureinfopojo);
			TopBfyInfo topbfyinfo = setBfyInfo(insureinfopojo);
			TopPhInfo topphinfo   = setPhInfo(insureinfopojo);
			TopRnInfo toprninfo  = setRnInfo(insureinfopojo);
			TopSpecialInfo topspecialinfo = setSpecialInfo(insureinfopojo);
			TopBuyInfoAdd topBuyInfoAdd = setBuyInfoAdd(insureinfopojo);
			
			//2将数据插入数据库
			iTopTradeInfoBiz.updateInfo(topbuyinfo);
			iTopTradeInfoBiz.insertPhInfo(topphinfo);
			iTopTradeInfoBiz.insertBfyInfo(topbfyinfo);
			iTopTradeInfoBiz.insertRnInfo(toprninfo);
			iTopTradeInfoBiz.insertSpecialInfo(topspecialinfo);
			iTopTradeInfoBiz.insertBuyInfoAddInfo(topBuyInfoAdd);
			resultInfo = "返回成功";
			resultCode = "000000";
		}catch(Exception e){
			resultInfo = "处理失败";
			resultCode = "000001";
		}finally{}
	    insureInfoRespPojo = new InsureInfoRespPojo();
		insureInfoRespPojo.setResultCode(resultCode);
		insureInfoRespPojo.setResultInfo(resultInfo);
		insureInfoRespPojo.setAccount(insureinfopojo.getAccount());
		insureInfoRespPojo.setAmount(insureinfopojo.getBaseEnsureAmt());
		insureInfoRespPojo.setSerialNo(insureinfopojo.getSerialNo());
		return insureInfoRespPojo;

	}
	
	private TopBuyInfoAdd setBuyInfoAdd(InsureInfoReqPojo insureinfopojo) {
		TopBuyInfoAdd topBuyInfoAdd = new TopBuyInfoAdd();
		topBuyInfoAdd.setAddserialno(insureinfopojo.getSerialNo());
		topBuyInfoAdd.setSerialno(insureinfopojo.getSerialNo());
		topBuyInfoAdd.setInsprdcode(insureinfopojo.getInsPrdCode());
		topBuyInfoAdd.setPay_type(insureinfopojo.getPayType());
		topBuyInfoAdd.setPay_period(insureinfopojo.getPayPeriod());
		topBuyInfoAdd.setPay_period_type(insureinfopojo.getPayPeriodType());
		topBuyInfoAdd.setIntialnumber(insureinfopojo.getIntialNumber());
		topBuyInfoAdd.setBasepremiumamt(insureinfopojo.getBasePremiumAmt());
		topBuyInfoAdd.setBaseensureamt(insureinfopojo.getBaseEnsureAmt());
		topBuyInfoAdd.setOperatorbankcode("2");
		topBuyInfoAdd.setOperatorcode("2");
		topBuyInfoAdd.setUpdatedate(DateUtil.getCurrentDate());
		topBuyInfoAdd.setUpdatetime(DateUtil.getCurrentTime_S());
		return topBuyInfoAdd;
	}

	private TopSpecialInfo setSpecialInfo(InsureInfoReqPojo insureinfopojo) {
		TopSpecialInfo topSpecialInfo = new TopSpecialInfo();
		topSpecialInfo.setSpserialno(insureinfopojo.getSerialNo());
		topSpecialInfo.setSerialno(insureinfopojo.getSerialNo());
		topSpecialInfo.setIshealth(insureinfopojo.getIsHealth());
		topSpecialInfo.setIsjob(insureinfopojo.getIsJob());
		return topSpecialInfo;
	}

	private TopRnInfo setRnInfo(InsureInfoReqPojo insureinfopojo) {
		TopRnInfo TopRnInfo = new TopRnInfo();
		TopRnInfo.setPrrelation(insureinfopojo.getPrRelation());
		TopRnInfo.setSerialno(insureinfopojo.getSerialNo());
		TopRnInfo.setRnserialno(insureinfopojo.getSerialNo());
		TopRnInfo.setRnname(insureinfopojo.getPhName());
		TopRnInfo.setRnsex(insureinfopojo.getPhSex());
		TopRnInfo.setRnbirthday(insureinfopojo.getPhBirthday());
		TopRnInfo.setRncfctype(insureinfopojo.getPhCfcType());
		TopRnInfo.setRncfcno(insureinfopojo.getPhCfcNo());
		TopRnInfo.setRnexpirydate(insureinfopojo.getPhCfcStart());
		TopRnInfo.setRemark1(insureinfopojo.getPhCfcEnd());
		TopRnInfo.setRnaddress(insureinfopojo.getPhAddress());
		TopRnInfo.setRnpostcode(insureinfopojo.getPhPostcode());
		TopRnInfo.setRncontactphone(insureinfopojo.getPhContactPhone());
		TopRnInfo.setRnfphone(insureinfopojo.getPhFphone());
		TopRnInfo.setRncphone(insureinfopojo.getPhCphone());
		TopRnInfo.setRnemail(insureinfopojo.getPhEamil());
		TopRnInfo.setRnteincome(insureinfopojo.getPhTeinCome());
		TopRnInfo.setRnnality(insureinfopojo.getPhNality());
		TopRnInfo.setRnjob(insureinfopojo.getPhJob());
		TopRnInfo.setRneducation(insureinfopojo.getPhEducation());
		TopRnInfo.setRnmarried(insureinfopojo.getPhMarried());
//		TopRnInfo.setUpdatedate(DateUtil.getCurrentDate());
//		TopRnInfo.setUpdatetime(DateUtil.getCurrentTime_S());
		return TopRnInfo;
	}

	private TopPhInfo setPhInfo(InsureInfoReqPojo insureinfopojo) {
		TopPhInfo topPhInfo = new TopPhInfo();
		
		topPhInfo.setPhserialno(insureinfopojo.getSerialNo());
		topPhInfo.setSerialno(insureinfopojo.getSerialNo());
		topPhInfo.setPhacctype(insureinfopojo.getPhAccType());
		topPhInfo.setPhaccno(insureinfopojo.getAccount());
		topPhInfo.setPhname(insureinfopojo.getPhName());
		topPhInfo.setPhsex(insureinfopojo.getPhSex());
		topPhInfo.setPhcfctype(insureinfopojo.getPhCfcType());
		topPhInfo.setPhcfcno(insureinfopojo.getPhCfcNo());
		topPhInfo.setPhexpirydate(insureinfopojo.getPhCfcStart());
		topPhInfo.setRemark1(insureinfopojo.getPhCfcEnd());
		topPhInfo.setPhbirthday(insureinfopojo.getPhBirthday());
		topPhInfo.setPhaddress(insureinfopojo.getPhAddress());
		topPhInfo.setPhpostcode(insureinfopojo.getPhPostcode());
		topPhInfo.setPhcontactphone(insureinfopojo.getPhContactPhone());
		topPhInfo.setPhfphone(insureinfopojo.getPhFphone());
		topPhInfo.setPhcphone(insureinfopojo.getPhCphone());
		topPhInfo.setPhemail(insureinfopojo.getPhEamil());
		topPhInfo.setPhteincome(insureinfopojo.getPhTeinCome());
		topPhInfo.setRemark2(insureinfopojo.getPhTeHomeinCome());
		topPhInfo.setRemark3(insureinfopojo.getPhZoneType());
		topPhInfo.setPhnality(insureinfopojo.getPhNality());
		topPhInfo.setPhjob(insureinfopojo.getPhJob());
		topPhInfo.setPheducation(insureinfopojo.getPhEducation());
		topPhInfo.setPhmarried(insureinfopojo.getPhMarried());
		topPhInfo.setPhrisklevel(insureinfopojo.getPhRiskType());;
		return topPhInfo;
	}

	private TopBfyInfo setBfyInfo(InsureInfoReqPojo insureinfopojo) {
		TopBfyInfo topBfyInfo = new TopBfyInfo();
		topBfyInfo.setBrrelation(insureinfopojo.getBrrRelation());
		topBfyInfo.setSerialno(insureinfopojo.getSerialNo());
		topBfyInfo.setBfyserialno(insureinfopojo.getSerialNo());
		return topBfyInfo;
	}

	private TopBuyInfo setBuyInfo(InsureInfoReqPojo insureinfopojo) {
		TopBuyInfo topBuyInfo = new TopBuyInfo();
		topBuyInfo.setSerialno(insureinfopojo.getSerialNo());
		topBuyInfo.setAreaid(insureinfopojo.getBankCode());
		topBuyInfo.setTzoperatorid(insureinfopojo.getTzFirstId());
		topBuyInfo.setInscorpstatus("2"); //保险公司核保成功，暂时写死
		topBuyInfo.setCorestatus("1");//核心状态未扣款
		topBuyInfo.setRecordstatus("2");//报单打印状态未打印
		topBuyInfo.setSerialtype("1");//报单状态正常
		return topBuyInfo;
		
	}

	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}

}
