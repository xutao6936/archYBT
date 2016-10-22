package com.topcheer.ybt.restws;


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
import com.topcheer.ybt.basedata.entity.TopBuyInfo;
import com.topcheer.ybt.restws.pojo.BaseInfoInReqPojo;
import com.topcheer.ybt.restws.pojo.BaseInfoInRespPojo;
import com.topcheer.ybt.util.OracleSequenceUtil;

/**
 * @ClassName: BaseInfoInRsService
 * @Description: TODO(基本信息录入)
 * @author xuxl
 * @date 
 * 
 */
@Path("/baseInfoInRsService")
public class BaseInfoInRsService {

	@Resource(name = "oracleSequenceUtil")
	OracleSequenceUtil oracleSequenceUtil;
	
	@Resource(name = "topTradeInfoBizImpl")
	ITopTradeInfoBiz iTopTradeInfoBiz;
	@Path("/baseInfoIn")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseInfoInRespPojo BaseInfoIn(BaseInfoInReqPojo baseInfoInPojo) {

		String serialno = "";
		String resultInfo = "";
		String resultCode = "";
		try{
		//1封装数据
		TopBuyInfo topBuyInfo = new TopBuyInfo();
	    serialno = oracleSequenceUtil.getPhInfoSerialNo();
		topBuyInfo.setSerialno(serialno);
		topBuyInfo.setInscorpcode(baseInfoInPojo.getInsCorpCode());
		topBuyInfo.setAreaid(baseInfoInPojo.getBankCode());
		topBuyInfo.setChannelflag(baseInfoInPojo.getChannelType());
		//2将数据插入数据库
		iTopTradeInfoBiz.insertBaseInfo(topBuyInfo);
		
		resultInfo = "返回成功";
		resultCode = "000000";
		}catch(Exception e){
			resultInfo = "处理失败";
			resultCode = "111111";
		}
		//3响应结果
		BaseInfoInRespPojo baseInfoInResult = new BaseInfoInRespPojo(); 
		baseInfoInResult.setSerialNo(serialno);
		baseInfoInResult.setResultCode(resultCode);
		baseInfoInResult.setResultInfo(resultInfo);
		return baseInfoInResult;
	}
	
	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}

}
