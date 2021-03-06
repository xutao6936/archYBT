package com.topcheer.ybt.restws;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.google.common.collect.Lists;
import com.topcheer.ybt.restws.pojo.TransQueryReqPojo;
import com.topcheer.ybt.restws.pojo.TransQueryRespPojo;

/**
 * @ClassName: TransQueryRsService
 * @Description: 交易查询
 * @author liuc
 * @date 2016-10-19
 * 
 */
@Path("transQueryRsService")
public class TransQueryRsService {


	@POST
	@Path("/transQuery")
	@Produces(MediaType.APPLICATION_JSON)
	public TransQueryRespPojo transQuery(TransQueryReqPojo transQueryReqPojo) {
//		List<TransQueryRespPojo> transQueryList = insPrdBiz
//				.getTopInsPrdInfoListByInsPrdCode(transQueryReqPojo);
//		
		List<TransQueryRespPojo> transQueryList = new ArrayList<TransQueryRespPojo>();
		List<TransQueryRespPojo> transQueryresults = Lists.newArrayList();
		TransQueryRespPojo transQueryRespInfo = null;
		for (int i = 0; i < transQueryList.size(); i++) {
			transQueryRespInfo = transQueryList.get(i);
			TransQueryRespPojo re = new TransQueryRespPojo(
					transQueryRespInfo.getInsCorpCode(),
					transQueryRespInfo.getInsCorpCHname(),
					transQueryRespInfo.getChannelType(),
					transQueryRespInfo.getContractId(),
					transQueryRespInfo.getSerialNo(),
					transQueryRespInfo.getAmount(),
					transQueryRespInfo.getUpdateDate(),
					transQueryRespInfo.getInsPrdCHname());
			transQueryresults.add(re);
		}
		TransQueryRespPojo result = new TransQueryRespPojo("000000", "返回成功",
				transQueryresults);
		return result;

	}

	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status)
				.entity(message).type(MediaType.APPLICATION_JSON).build());
	}

}
