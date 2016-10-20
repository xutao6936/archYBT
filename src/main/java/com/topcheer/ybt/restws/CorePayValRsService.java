package com.topcheer.ybt.restws;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.topcheer.ybt.restws.pojo.CorePayValReqPojo;
import com.topcheer.ybt.restws.pojo.CorePayValRespPojo;


/**
 * @ClassName: CorePayValRsService
 * @Description: TODO(核心扣款)
 * @author	liuc
 * @date 
 * 
 */
@Path("/corePayValRsService")
public class CorePayValRsService {

	
	@Path("/corePayVal")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CorePayValRespPojo CorePayVal(CorePayValReqPojo corePayValReqPojo) {
		Map<String, String> map = new HashMap<String, String>();
		//校验非空
		map = check(corePayValReqPojo);
		if("false".equals(map.get("status"))){
			return new CorePayValRespPojo("20161018000000000001",map.get("returnCode"),map.get("returnMsg"));
		}else{
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
