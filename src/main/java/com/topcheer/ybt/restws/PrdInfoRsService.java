package com.topcheer.ybt.restws;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.topcheer.ybt.basedata.biz.ITopInsPrdInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.data.InsPrdResult;
import com.topcheer.ybt.data.MenuResult;
import com.topcheer.ybt.restws.pojo.InsPrdReqPojo;
import com.topcheer.ybt.restws.pojo.InsPrdsRespPojo;
import com.topcheer.ybt.system.service.ITopMenuinfoService;

/**
 * @ClassName: ProdRsService
 * @Description: TODO(产品详情查询)
 * @author xuxl
 * @date 2016-10-17 
 * 
 */
@Path("prdInfoRsService")
public class PrdInfoRsService {

	@Resource(name = "topInsPrdInfoBizImpl")
	ITopInsPrdInfoBiz insPrdBiz;

	@Path("/findInsPrdInfoByCode/{insPrdCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public InsPrdResult findSpecialPrd(@PathParam("insPrdCode") String insPrdCode) {
		List<TopInsprdInfo> insprodINfo = insPrdBiz.getInsPrdInfoByInsPrdCode(insPrdCode);
		TopInsprdInfo topinsprdinfo = insprodINfo.get(0);
		String inscorpcode = topinsprdinfo.getInsCorpCode();
		String insprdcode = topinsprdinfo.getInsPrdCode();
		return new InsPrdResult(inscorpcode,insprdcode, "28", "1", "60", "2", "每天不到3毛钱，即可享受最高100万的保障", "保险责任详细信息请参考以下相关文档");
	}

	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}
	
	@Path("test123")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public InsPrdResult test(InsPrdReqPojo pojo){
		System.out.println(pojo);
		return new InsPrdResult("","100001", "28", "1", "60", "2", "每天不到3毛钱，即可享受最高100万的保障", "保险责任详细信息请参考以下相关文档");
		
	}
	

}
