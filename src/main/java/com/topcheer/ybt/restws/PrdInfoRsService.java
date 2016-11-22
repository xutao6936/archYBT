package com.topcheer.ybt.restws;

import java.util.ArrayList;
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
import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.basedata.entity.TopPayperiod;
import com.topcheer.ybt.basedata.entity.TopPaytype;
import com.topcheer.ybt.basedata.service.ITopInsPrdPeriodInfoService;
import com.topcheer.ybt.basedata.service.ITopPayperiodService;
import com.topcheer.ybt.basedata.service.ITopPaytypeService;
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
	@Resource(name= "topPayperiodService")
	ITopPayperiodService topPayperiodService;
	@Resource(name= "topInsPrdPeriodInfoService")
	ITopInsPrdPeriodInfoService topInsPrdPeriodInfoService;
	@Resource(name="topPaytypeService")
	ITopPaytypeService topPaytypeService;
	
	@GET
	@Path("/findInsPrdInfoByCode/{insPrdCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public InsPrdResult findSpecialPrd(@PathParam("insPrdCode") String insPrdCode) {
		List<TopInsprdInfo> insprodINfo = insPrdBiz.getInsPrdInfoByInsPrdCode(insPrdCode);
		List insPrdPeriodInfosList =topInsPrdPeriodInfoService.getInsPrdPeriodByInsPrdCode(insPrdCode); //保障年期信息
		List payperiodsList = topPayperiodService.getTopPayperiodListByInsPrdCode(insPrdCode);//缴费年期信息
		List payTypeList=topPaytypeService.getTopPaytypeListByInsPrdCode(insPrdCode);
		TopInsprdInfo topinsprdinfo = insprodINfo.get(0);
		String inscorpcode = topinsprdinfo.getInsCorpCode();
		String insprdcode = topinsprdinfo.getInsPrdCode();
		return new InsPrdResult(inscorpcode,insprdcode, "", "", "", "", "", "", "", "", "", "", "",insPrdPeriodInfosList,payperiodsList,payTypeList);
	}

	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}
	
}
