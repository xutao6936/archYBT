package com.topcheer.ybt.restws;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.topcheer.ybt.basedata.biz.ITopInsPrdInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.data.InsPrdResult;
import com.topcheer.ybt.restws.pojo.BaseInfoInPojo;
import com.topcheer.ybt.restws.pojo.BaseInfoInResult;
import com.topcheer.ybt.restws.pojo.InsPrdPojo;
import com.topcheer.ybt.restws.pojo.InsPrdsResult;
import com.topcheer.ybt.system.entity.TopMenuinfo;

/**
 * @ClassName: ProdRsService
 * @Description: TODO(基本信息录入)
 * @author xuxl
 * @date 
 * 
 */
@Path("/baseInfoInRsService")
public class BaseInfoInRsService {

	
//	@Resource(name = "topInsPrdInfoBizImpl")
//	ITopInsPrdInfoBiz insPrdBiz;
	@Path("/baseInfoIn")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseInfoInResult BaseInfoIn(BaseInfoInPojo baseInfoInPojo) {

//		System.out.println(baseInfoInPojo);
		//BaseInfoInResult baseInfoInResult = new BaseInfoInResult(); 
		/*baseInfoInResult.setSerialNo("20161018000000000001");
		baseInfoInResult.setResultCode("000000");
		baseInfoInResult.setResultInfo("返回成功");*/
		return new BaseInfoInResult("20161018000000000001","000000","返回成功");
	}
	
	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}

}
