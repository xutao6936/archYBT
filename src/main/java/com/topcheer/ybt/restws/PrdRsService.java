package com.topcheer.ybt.restws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.topcheer.ybt.restws.pojo.InsPrdReqPojo;
import com.topcheer.ybt.restws.pojo.InsPrdsRespPojo;

/**
 * @ClassName: ProdRsService
 * @Description: TODO(产品列表查询)
 * @author xuxl
 * @date 2016-10-17 
 * 
 */
@Path("prdRsService")
public class PrdRsService {

	
	@Resource(name = "topInsPrdInfoBizImpl")
	ITopInsPrdInfoBiz insPrdBiz;

	@GET
	@Path("/getInsPrdInfos/{bankCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public InsPrdsRespPojo searchPrds(@PathParam("bankCode") String bankCode) {
		
		Map resultmap = checkData(bankCode);
		
		List<TopInsprdInfo>  insPrds = insPrdBiz.getTopInsPrdInfoListByInsPrdCode(bankCode);
		List<InsPrdReqPojo> insPrdsresults = Lists.newArrayList();
		TopInsprdInfo topInsprdInfo = null;
		for (int i = 0; i < insPrds.size(); i++) {
			topInsprdInfo = insPrds.get(i);
			InsPrdReqPojo re = new InsPrdReqPojo(topInsprdInfo.getInsPrdCode(), topInsprdInfo.getInsPrdCnName(), topInsprdInfo.getYieldRate(), topInsprdInfo.getStartAMT(),topInsprdInfo.getHotType());
			insPrdsresults.add(re);
		}
		InsPrdsRespPojo result = new InsPrdsRespPojo((String)resultmap.get("resultCode"), (String)resultmap.get("resultMsg"), insPrdsresults);
		return result;

	}
	
	
	private Map checkData(String bankCode) {
		Map map = new HashMap();
		String resultMsg = "";
		String resultCode = "";
		if (Strings.isNullOrEmpty(bankCode)) {
				resultMsg = "机构号为空";
				resultCode = "000001";
				map.put("resultMsg", resultMsg);
				map.put("resultCode", resultCode);
		}
		return map;
	}

	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}

}
