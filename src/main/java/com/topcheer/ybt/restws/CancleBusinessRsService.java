package com.topcheer.ybt.restws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.topcheer.ybt.restws.pojo.CancleBusinessReqPojo;
import com.topcheer.ybt.restws.pojo.CancleBusinessRespPojo;

/**
 * @ClassName: CancleBusinessRsService
 * @Description: 当日撤单
 * @author	liuc
 * @date 
 * 
 */
@Path("/cancleBusinessRsService")
public class CancleBusinessRsService {
		@Path("/cancleBusiness")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public CancleBusinessRespPojo CancleBusiness(CancleBusinessReqPojo cancleBusinessReqPojo) {

//			System.out.println(baseInfoInPojo);
			//BaseInfoInResult baseInfoInResult = new BaseInfoInResult(); 
			/*baseInfoInResult.setSerialNo("20161018000000000001");
			baseInfoInResult.setResultCode("000000");
			baseInfoInResult.setResultInfo("返回成功");*/
			return new CancleBusinessRespPojo("000000","返回成功","2800","新华人寿","03","20161018000000000001","355124","10000","20161019","新华人寿一号分红险");
		}
		
		@SuppressWarnings("unused")
		private WebApplicationException buildException(Status status, String message) {
			return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
					.build());
		}

}
