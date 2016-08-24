package com.topcheer.ybt.restws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.topcheer.ybt.data.InsPrdForGridResult;
import com.topcheer.ybt.data.InsPrdResult;
import com.topcheer.ybt.data.MenuResult;
import com.topcheer.ybt.entity.system.TopMenuinfo;
import com.topcheer.ybt.service.system.ITopMenuinfoService;

/** 
 * @ClassName: TranRsService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author XUTAO 
 * @date 2016-7-4 下午11:07:32 
 *  
 */
public class TranRsService {
	
	@Autowired
	ITopMenuinfoService  menuService;
	@GET
	@Path("getInsPrdInfos/{bankCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<InsPrdForGridResult> searchPrds(@PathParam("bankCode") String bankCode){
		if(Strings.isNullOrEmpty(bankCode)){
			String msg = "机构号为空";
			throw buildException(Status.NOT_FOUND, msg);
		}
		List<InsPrdForGridResult> result =  Lists.newArrayList();
		InsPrdForGridResult re =  new InsPrdForGridResult("100001","心享恒安B款","9%","1000000.00","1","1000");
		result.add(re);
		return result;
		
	}
	@GET
	@Path("findInsPrdInfoByCode/{insPrdCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public InsPrdResult findSpecialPrd(@PathParam("insPrdCode") String insPrdCode){
		if(Strings.isNullOrEmpty(insPrdCode)){
			String msg = "产品编号为空";
			throw buildException(Status.NOT_FOUND, msg);
		}
		return new InsPrdResult("100001","28","1","60","2","每天不到3毛钱，即可享受最高100万的保障","保险责任详细信息请参考以下相关文档");
	}
	
	@GET
	@Path("/getMenu/{loginAccount}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MenuResult> getMenu(@PathParam("loginAccount") String loginAccount){
		return menuService.getTopMenusByUserId(loginAccount);
	}
	
	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON).build());
	}

}
