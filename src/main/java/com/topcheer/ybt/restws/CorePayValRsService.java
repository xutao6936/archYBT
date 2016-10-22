package com.topcheer.ybt.restws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.topcheer.ybt.restws.pojo.CorePayValReqPojo;
import com.topcheer.ybt.restws.pojo.CorePayValRespPojo;
import com.topcheer.ybt.restws.pojo.InsureInfoRespPojo;


/**
 * @ClassName: CorePayValRsService
 * @Description: TODO(核心扣款)
 * @author	liuc
 * @date 
 * 
 */
@Path("/corePayValRsService")
public class CorePayValRsService {

	@Resource(name = "topTradeInfoBizImpl")
	ITopTradeInfoBiz iTopTradeInfoBiz;
	
	@Path("/corePayVal")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CorePayValRespPojo CorePayVal(CorePayValReqPojo corePayValReqPojo) {
		Map<String, String> map = new HashMap<String, String>();
		//校验非空
		map = check(corePayValReqPojo);
		
		CorePayValRespPojo corePayValRespPojo;
		String resultInfo = "";
		String resultCode = "";
		//将核心扣款对象数转换成投保对象便于数据存储
		TopBuyInfo topBuyInfo = new TopBuyInfo();
		topBuyInfo.setSerialno(corePayValReqPojo.getSerialNo());
		topBuyInfo.setCorestatus("2");//扣款成功
		topBuyInfo.setInscorpstatus("2");
		topBuyInfo.setSerialtype("1");
		topBuyInfo.setRecordstatus("2");
		
		//根据流水号查询银保通系统中的交易信息
		List<TopBuyInfo> list = iTopTradeInfoBiz.selectBaseInfo(corePayValReqPojo.getSerialNo());
		if(0==list.size()){
		    resultInfo = "银保通系统中无此流水";
		    resultCode = "000001";
		    corePayValRespPojo = new CorePayValRespPojo();
		    corePayValRespPojo.setResultCode(resultCode);
		    corePayValRespPojo.setResultInfo(resultInfo);
			return corePayValRespPojo;
		}
		if("false".equals(map.get("status"))){
			return new CorePayValRespPojo("20161018000000000001",map.get("returnCode"),map.get("returnMsg"));
		}else{
			//核心扣款直接更新数据库为扣款成功并响应
			iTopTradeInfoBiz.updateInfo(topBuyInfo);
			return new CorePayValRespPojo("20161018000000000001",map.get("returnCode"),map.get("returnMsg"));
		}
		
	}
	
	@SuppressWarnings("unused")
	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}
	
	public Map<String, String> check(CorePayValReqPojo corePayValReqPojo){
		Map<String,String> map = new HashMap<String,String>();		
		if("".equals(corePayValReqPojo.getSerialNo())||null == corePayValReqPojo.getSerialNo()){
			map.put("returnCode", "111111");
			map.put("returnMsg", "银保通流水号不能为空");
			map.put("status", "false");
			return map;
		}
		if("".equals(corePayValReqPojo.getAccount())||null ==corePayValReqPojo.getAccount()){
			map.put("returnCode", "111111");
			map.put("returnMsg", "扣款账号不能为空");
			map.put("status", "false");
			return map;
		}
		if("".equals(corePayValReqPojo.getAmount()) || null == corePayValReqPojo.getAmount()){
			map.put("returnCode", "111111");
			map.put("returnMsg", "首期保费不能为空");
			map.put("status", "false");
			return map;
		}
		if("".equals(corePayValReqPojo.getPwd()) || null == corePayValReqPojo.getPwd()){
			map.put("returnCode", "111111");
			map.put("returnMsg", "客户密码（加密）不能为空");
			map.put("status", "false");
			return map;
		}
		map.put("returnCode", "000000");
		map.put("returnMsg", "返回成功");
		map.put("status", "true");
		return map;
	}

}
