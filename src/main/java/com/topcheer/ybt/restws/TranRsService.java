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

import org.apache.poi.ss.formula.functions.T;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.topcheer.ybt.basedata.biz.ITopInsPrdInfoBiz;
import com.topcheer.ybt.data.InsPrdResult;
import com.topcheer.ybt.data.MenuResult;
import com.topcheer.ybt.restws.pojo.InsPrdPojo;
import com.topcheer.ybt.restws.pojo.InsPrdsResult;
import com.topcheer.ybt.restws.pojo.PolicyInquiryPojo;
import com.topcheer.ybt.system.entity.TopMenuinfo;
import com.topcheer.ybt.system.service.ITopMenuinfoService;

/**
 * @ClassName: TranRsService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author XUTAO
 * @date 2016-7-4 下午11:07:32
 * 
 */
public class TranRsService {

	@Resource(name = "topMenuinfoService")
	ITopMenuinfoService menuService;

	@Resource(name = "topInsPrdInfoBizImpl")
	ITopInsPrdInfoBiz insPrdBiz;

	@GET
	@Path("/getInsPrdInfos/{bankCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public InsPrdsResult searchPrds(@PathParam("bankCode") String bankCode) {
		/*if (Strings.isNullOrEmpty(bankCode)) {
			String msg = "机构号为空";
			throw buildException(Status.NOT_FOUND, msg);
		}
		List<T> insPrds = new ArrayList<T>();
		for (int i = 0; i < 4; i++) {
			InsPrdPojo re = new InsPrdPojo("100001", "心享恒安B款", "9%", "1000000.00", "1");
			insPrds.add(re);
		}
		InsPrdsResult result = new InsPrdsResult();
		result.setInsPrds(insPrds);*/
		return null;

	}

	@Path("findInsPrdInfoByCode")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public InsPrdResult findSpecialPrd(@QueryParam("topMenuinfo") String topMenuinfo) {
		/*
		 * if (Strings.isNullOrEmpty(topMenuinfo)) {
		 * String msg = "产品编号为空";
		 * throw buildException(Status.NOT_FOUND, msg);
		 * }
		 */
		return new InsPrdResult("100001", "28", "1", "60", "2", "每天不到3毛钱，即可享受最高100万的保障", "保险责任详细信息请参考以下相关文档");
	}

	@GET
	@Path("/getMenu/{loginAccount}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MenuResult> getMenu(@PathParam("loginAccount") String loginAccount) {
		return menuService.getTopMenusByUserId(loginAccount);
	}

	
	@GET
	@Path("/getPolicyInquiry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public InsPrdsResult PolicyInquiry(@PathParam("userId") String bankCode) {
		
		List<PolicyInquiryPojo> policyInquirylist = new ArrayList<PolicyInquiryPojo>();
		
		PolicyInquiryPojo data1 = new PolicyInquiryPojo("5300", "安邦人寿", "1", "201610131605", "11124212", "10000.0", "20161013", "安邦分红险一号");
		PolicyInquiryPojo data2 = new PolicyInquiryPojo("5400", "新华人寿", "1", "201610131606", "11124213", "10000.0", "20161013", "新华分红险一号");
		PolicyInquiryPojo data3 = new PolicyInquiryPojo("5500", "国华人寿", "1", "201610131607", "11124214", "10000.0", "20161013", "国华分红险一号");
		policyInquirylist.add(data1);
		policyInquirylist.add(data2);
		policyInquirylist.add(data3);
		
		List<TopMenuinfo> list = menuService.searchAll();
		InsPrdsResult insPrdsResult = new InsPrdsResult();
		insPrdsResult.setResultCode("000000");
		insPrdsResult.setResultInfo("success");
		//insPrdsResult.setList(policyInquirylist);
		insPrdsResult.setList(list);
		return insPrdsResult;

	}
	
	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}

}
