package com.topcheer.ybt.restws;


import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.topcheer.ybt.basedata.entity.TopBfyInfo;
import com.topcheer.ybt.basedata.entity.TopBuyInfo;
import com.topcheer.ybt.basedata.entity.TopPhInfo;
import com.topcheer.ybt.basedata.entity.TopRnInfo;
import com.topcheer.ybt.basedata.entity.TopSpecialInfo;
import com.topcheer.ybt.restws.pojo.InsPrdsRespPojo;
import com.topcheer.ybt.restws.pojo.InsureInfoReqPojo;

/**
 * @ClassName: ProdRsService
 * @Description: TODO(保险详细信息录入)
 * @author xuxl
 * @date 
 * 
 */
@Path("/insureInforInRsService")
public class InsureInforInRsService {

//	@Resource(name = "topTransInfoBizImpl")
//	ITopTransInfoBiz insureInfoin;

	@Path("/insureInfoin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public InsPrdsRespPojo insureInfoin(InsureInfoReqPojo insureinfopojo) {
		
		System.out.println(insureinfopojo);
		try{
			//1分布封装数据
			TopBuyInfo topbuyinfo = new TopBuyInfo();
			TopBfyInfo topbfyinfo = new TopBfyInfo();
			TopPhInfo topphinfo   = new TopPhInfo();
			TopRnInfo toprninfo  = new TopRnInfo();
			TopSpecialInfo topspecialinfo = new TopSpecialInfo();
			
		}catch(Exception e){
			
		}finally{}
		return null;

	}
	
	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}

}
