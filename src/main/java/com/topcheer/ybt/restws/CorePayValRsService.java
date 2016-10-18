package com.topcheer.ybt.restws;

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

//		System.out.println(baseInfoInPojo);
		//BaseInfoInResult baseInfoInResult = new BaseInfoInResult(); 
		/*baseInfoInResult.setSerialNo("20161018000000000001");
		baseInfoInResult.setResultCode("000000");
		baseInfoInResult.setResultInfo("返回成功");*/
		return new CorePayValRespPojo("20161018000000000001","000000","返回成功");
	}
	
	@SuppressWarnings("unused")
	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}

}
