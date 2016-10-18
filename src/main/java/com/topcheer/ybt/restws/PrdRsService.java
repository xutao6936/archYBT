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
import com.topcheer.ybt.restws.pojo.InsPrdPojo;
import com.topcheer.ybt.restws.pojo.InsPrdsResult;

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
	public InsPrdsResult searchPrds(@PathParam("bankCode") String bankCode) {
		if (Strings.isNullOrEmpty(bankCode)) {
			String msg = "机构号为空";
			throw buildException(Status.NOT_FOUND, msg);
		}
		List<TopInsprdInfo>  insPrds = insPrdBiz.getTopInsPrdInfoListByInsPrdCode(bankCode);
		List<InsPrdPojo> insPrdsresults = Lists.newArrayList();
		TopInsprdInfo topInsprdInfo = null;
		for (int i = 0; i < insPrds.size(); i++) {
			topInsprdInfo = insPrds.get(i);
			InsPrdPojo re = new InsPrdPojo(topInsprdInfo.getInsPrdCode(), topInsprdInfo.getInsPrdCnName(), topInsprdInfo.getYieldRate(), topInsprdInfo.getStartAMT(),topInsprdInfo.getHotType());
			insPrdsresults.add(re);
		}
		InsPrdsResult result = new InsPrdsResult("000000", "返回成功", insPrdsresults);
		return result;

	}
	
	
	@Path("test123")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public InsPrdResult test(@FormParam("pojo") InsPrdPojo pojo){
		System.out.println(pojo);
		return new InsPrdResult("","100001", "28", "1", "60", "2", "每天不到3毛钱，即可享受最高100万的保障", "保险责任详细信息请参考以下相关文档");
		
	}
	

	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}

}
